package com.example.everydaywithbible.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.PortugueseDetailAdapter;
import com.example.everydaywithbible.controller.SpanishDetailAdapter;
import com.example.everydaywithbible.model.StoryKey;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortugueseDetailFragment extends Fragment {

    private PortugueseDetailAdapter portugueseDetailAdapter;
    private StoryKey story;
    private RecyclerView recyclerView;
    private static final String STORY_KEY = "story_key";
    private FragmentInterface mListener;

    public PortugueseDetailFragment() {
    }


    public static PortugueseDetailFragment newInstance(String story) {
        PortugueseDetailFragment fragment = new PortugueseDetailFragment();
        Bundle args = new Bundle();
        args.putString(STORY_KEY, story);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
        return inflater.inflate(R.layout.fragment_portuguese_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.portuguese_detail_recyclerView);
        portugueseDetailAdapter = new PortugueseDetailAdapter(story.getAccounts());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(portugueseDetailAdapter);
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
