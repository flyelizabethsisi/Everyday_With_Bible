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
import com.example.everydaywithbible.controller.StoryAdapter;
import com.example.everydaywithbible.model.StoryData;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.network.APIService;
import com.example.everydaywithbible.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class TitleFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "TitleFragment";

    private FragmentInterface fragmentInterface;
    private SearchView searchView;
    private StoryAdapter storyAdapter;
    private StoryData storyData;
    private List<StoryKey> storyList = new ArrayList<>();
    private RecyclerView recyclerView;
    // private CompositeDisposable disposable = new CompositeDisposable();

    public TitleFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TitleFragment newInstance() {
        TitleFragment fragment = new TitleFragment();
        return new TitleFragment();
    }

//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

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
        return inflater.inflate(R.layout.fragment_title, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        searchView = view.findViewById(R.id.story_searchView);

        final Retrofit retrofit = RetrofitSingleton.getInstance();
        Log.d(TAG, "onViewCreated: " + retrofit.toString());

        APIService apiService = retrofit.create(APIService.class);

        Log.d(TAG, "onViewCreated: apiservice" + apiService.toString() );
        Observable<StoryResponse> responseCall = apiService.getStoryList();

        Log.d(TAG, "onViewCreated: responsecall" + responseCall.toString());

        responseCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StoryResponse>() {
                    @Override
                    public void accept(StoryResponse response) throws Exception {
//                        TitleFragment.this.accept(storyData1);

                        Log.d(TAG, response.getData().getStoryTitleList().get(0).getTitle() );
                        storyList = response.getData().getStoryTitleList();
                        storyAdapter = new StoryAdapter(storyList,fragmentInterface);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(storyAdapter);
                        searchView.setOnQueryTextListener(TitleFragment.this);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d(TAG,  throwable.getMessage());

                    }
                });

    }


//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }


    @Override
    public void onDetach() {
        super.onDetach();
        // mListener = null;
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
        storyAdapter.setData(newStoryTitleList);
        return false;
    }
}


