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
import com.example.everydaywithbible.controller.ChineseStoryAdapter;
import com.example.everydaywithbible.controller.FrenchStoryAdapter;
import com.example.everydaywithbible.controller.PortugueseStoryAdapter;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.network.APIServiceChinese;
import com.example.everydaywithbible.network.APIServiceFrench;
import com.example.everydaywithbible.network.RetrofitSingletonChinese;
import com.example.everydaywithbible.network.RetrofitSingletonFrench;

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
public class TitleFragmentChinese extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "TitleFragmentChinese";
    private FragmentInterface fragmentInterface;
    private SearchView searchView;
    private ChineseStoryAdapter chineseStoryAdapter;
    private List<StoryKey> storyList = new ArrayList<>();
    private RecyclerView recyclerView;

    public TitleFragmentChinese() {
        // Required empty public constructor
    }

    public static TitleFragmentChinese newInstance() {
        TitleFragmentChinese titleFragmentChinese = new TitleFragmentChinese();
        return new TitleFragmentChinese();
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
        return inflater.inflate(R.layout.fragment_title_fragment_chinese, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_chinese);
        searchView = view.findViewById(R.id.story_searchView_chinese);

        final Retrofit retrofit = RetrofitSingletonChinese.getInstance();
        Log.d(TAG, "onViewCreated: " + retrofit.toString());

        APIServiceChinese apiService = retrofit.create(APIServiceChinese.class);

        Log.d(TAG, "onViewCreated: apiservice" + apiService.toString());
        Observable<StoryResponse> responseCall = apiService.getStoryListChinese();

        Log.d(TAG, "onViewCreated: responsecall" + responseCall.toString());

        responseCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StoryResponse>() {
                    @Override
                    public void accept(StoryResponse response) throws Exception {

                        Log.d(TAG, response.getData().getStoryTitleList().get(0).getTitle());
                        storyList = response.getData().getStoryTitleList();
                        chineseStoryAdapter = new ChineseStoryAdapter(storyList, fragmentInterface);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(chineseStoryAdapter);
                        searchView.setOnQueryTextListener(TitleFragmentChinese.this);

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
        chineseStoryAdapter.setData(newStoryTitleList);
        return false;
    }
}

