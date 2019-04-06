package com.example.everydaywithbible.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.controller.StoryAdapter;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryValue;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class DetailFragment extends Fragment {

    private DetailAdapter detailAdapter;
    private StoryKey story;
    private StoryValue storyWeb;
    private RecyclerView recyclerView;
    private static final String STORY_KEY = "story_key";
    private FragmentInterface mListener;
    private Button detailWebButton;
    private Button detailVerseButton;

    public static DetailFragment newInstance(String story) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(STORY_KEY, story);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String json = getArguments().getString(STORY_KEY);
            story = new Gson().fromJson(json, StoryKey.class);
        }

    }

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
        detailAdapter = new DetailAdapter(story.getAccounts());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(detailAdapter);

    }


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
