package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.view.StoryViewHolder;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryViewHolder> {
    private FragmentInterface fragmentInterface;
    private List<StoryKey> storyList;

    public StoryAdapter(FragmentInterface fragmentInterface, List<StoryKey> storyList) {
        this.fragmentInterface = fragmentInterface;
        this.storyList = storyList;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view, viewGroup, false);
        return new StoryViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder storyViewHolder, int i) {
        storyViewHolder.onBind(storyList.get(i), fragmentInterface);
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public void setData(List<StoryKey> newStoryTitleList){
        this.storyList = newStoryTitleList;
        notifyDataSetChanged();
    }
}
