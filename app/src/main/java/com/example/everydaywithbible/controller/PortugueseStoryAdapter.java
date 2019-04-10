package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.view.PortugueseStoryViewHolder;
import com.example.everydaywithbible.view.SpanishStoryViewHolder;

import java.util.List;

public class PortugueseStoryAdapter extends RecyclerView.Adapter<PortugueseStoryViewHolder> {

    private List<StoryKey> storyList;
    private FragmentInterface fragmentInterface;

    public PortugueseStoryAdapter(List<StoryKey> storyList, FragmentInterface fragmentInterface) {
        this.storyList = storyList;
        this.fragmentInterface = fragmentInterface;
    }

    @NonNull
    @Override
    public PortugueseStoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_portuguese, viewGroup, false);
        return new PortugueseStoryViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull PortugueseStoryViewHolder portugueseStoryViewHolder, int i) {
        portugueseStoryViewHolder.onBind(storyList.get(i), fragmentInterface);

    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public void setData(List<StoryKey> newStoryTitleList) {
        this.storyList = newStoryTitleList;
        notifyDataSetChanged();
    }
}
