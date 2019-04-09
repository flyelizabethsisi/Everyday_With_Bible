package com.example.everydaywithbible.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.SearchView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.FrenchStoryAdapter;
import com.example.everydaywithbible.controller.SpanishStoryAdapter;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.network.APIServiceFrench;
import com.example.everydaywithbible.network.APIServiceSpanish;
import com.example.everydaywithbible.network.RetrofitSingletonFrench;
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
public class TitleFragmentFrench extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "TitleFragmentFrench";
    private FragmentInterface fragmentInterface;
    private SearchView searchView;
    private FrenchStoryAdapter frenchStoryAdapter;
    private List<StoryKey> storyList = new ArrayList<>();
    private RecyclerView recyclerView;


    public TitleFragmentFrench() {
        // Required empty public constructor
    }

    public static TitleFragmentFrench newInstance() {
        TitleFragmentFrench titleFragmentFrench = new TitleFragmentFrench();
        return new TitleFragmentFrench();
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
        return inflater.inflate(R.layout.fragment_title_fragment_french, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_french);
        searchView = view.findViewById(R.id.story_searchView_french);

        final Retrofit retrofit = RetrofitSingletonFrench.getInstance();
        Log.d(TAG, "onViewCreated: " + retrofit.toString());

        APIServiceFrench apiService = retrofit.create(APIServiceFrench.class);

        Log.d(TAG, "onViewCreated: apiservice" + apiService.toString());
        Observable<StoryResponse> responseCall = apiService.getStoryListFrench();

        Log.d(TAG, "onViewCreated: responsecall" + responseCall.toString());

        responseCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StoryResponse>() {
                    @Override
                    public void accept(StoryResponse response) throws Exception {

                        Log.d(TAG, response.getData().getStoryTitleList().get(0).getTitle());
                        storyList = response.getData().getStoryTitleList();
                        frenchStoryAdapter = new FrenchStoryAdapter(storyList, fragmentInterface);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(frenchStoryAdapter);
                        searchView.setOnQueryTextListener(TitleFragmentFrench.this);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d(TAG, throwable.getMessage());

                    }
                });

    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        List<StoryKey> newStoryTitleList = new ArrayList<>();
        for (StoryKey story : storyList) {
            if (story.getTitle().toLowerCase().startsWith(newText.toLowerCase())) {
                newStoryTitleList.add(story);
            }
        }
        Log.d(TAG, "we got here");
        frenchStoryAdapter.setData(newStoryTitleList);
        return false;
    }
}
