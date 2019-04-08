package com.example.everydaywithbible.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.SpanishStoryAdapter;
import com.example.everydaywithbible.controller.StoryAdapter;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.network.APIService;
import com.example.everydaywithbible.network.APIServiceSpanish;
import com.example.everydaywithbible.network.RetrofitSingleton;
import com.example.everydaywithbible.network.RetrofitSingletonSpanish;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragmentSpanish extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "TitleFragmentSpanish";

    private FragmentInterface fragmentInterface;
    private SearchView searchView;
    private SpanishStoryAdapter spanishStoryAdapter;
    private List<StoryKey> storyList = new ArrayList<>();
    private RecyclerView recyclerView;

    public TitleFragmentSpanish() {
    }

    public static TitleFragmentSpanish newInstance() {
        TitleFragmentSpanish fragment = new TitleFragmentSpanish();
        return new TitleFragmentSpanish();
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_fragment_spanish, container, false);
    }
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_spanish);
        searchView = view.findViewById(R.id.story_searchView_spanish);

        final Retrofit retrofit = RetrofitSingletonSpanish.getInstance();
        Log.d(TAG, "onViewCreated: " + retrofit.toString());

        APIServiceSpanish apiService = retrofit.create(APIServiceSpanish.class);

        Log.d(TAG, "onViewCreated: apiservice" + apiService.toString() );
        Observable<StoryResponse> responseCall = apiService.getStoryListSpanish();

        Log.d(TAG, "onViewCreated: responsecall" + responseCall.toString());

        responseCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StoryResponse>() {
                    @Override
                    public void accept(StoryResponse response) throws Exception {

                        Log.d(TAG, response.getData().getStoryTitleList().get(0).getTitle() );
                        storyList = response.getData().getStoryTitleList();
                        spanishStoryAdapter = new SpanishStoryAdapter(storyList,fragmentInterface);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(spanishStoryAdapter);
                        searchView.setOnQueryTextListener(TitleFragmentSpanish.this);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d(TAG,  throwable.getMessage());

                    }
                });

    }




    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<StoryKey> newStoryTitleList = new ArrayList<>();
        for (StoryKey story : storyList) {
            if (story.getTitle().toLowerCase().startsWith(s.toLowerCase())) {
                newStoryTitleList.add(story);
            }
        }
        Log.d(TAG, "we got here");
        spanishStoryAdapter.setData(newStoryTitleList);
        return false;
    }
}


