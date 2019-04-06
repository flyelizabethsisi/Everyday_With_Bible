package com.example.everydaywithbible.fragment;

import android.content.Context;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.controller.StoryAdapter;
import com.example.everydaywithbible.model.StoryData;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.network.APIService;
import com.example.everydaywithbible.network.RetrofitSingleton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class DetailFragment extends Fragment {

    private FragmentInterface fragmentInterface;
    private DetailAdapter detailAdapter;
    private StoryData storyData;
    private List<StoryKey> storyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private static final String TAG = "DetailFragment";

    private static final String TITLE_KEY = "title_key";
    private static final String AUTHOR_KEY = "author_key";
    private static final String VERSE_KEY = "verse_key";
    private static final String WEB_KEY = "web_key";



    TextView detailTitleText;
    TextView detailAuthorText;
    TextView detailVerseText;
    Button detailWebText;


    String title, author, bibleVerse, website;


    private FragmentInterface mListener;

    public DetailFragment() {
    }


    public static DetailFragment newInstance(String title, String author, String bibleVerse, String website) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        args.putString(AUTHOR_KEY, author);
        args.putString(VERSE_KEY, bibleVerse);
        args.putString(WEB_KEY, website);

        fragment.setArguments(args);
        return fragment;
    }

//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(TITLE_KEY);
//            mParam2 = getArguments().getString(AUTHOR_KEY);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.detail_recycler_view);

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
                        detailAdapter = new DetailAdapter(fragmentInterface,storyList);
                        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        recyclerView.setAdapter(detailAdapter);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        Log.d(TAG, "?"+ throwable.getMessage());

                    }
                });





    }
// TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.toDetailFragment(website);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            mListener = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
