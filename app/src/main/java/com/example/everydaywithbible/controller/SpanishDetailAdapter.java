package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.view.DetailViewHolder;
import com.example.everydaywithbible.view.SpanishDetailViewHolder;

import java.util.List;

public class SpanishDetailAdapter extends RecyclerView.Adapter<SpanishDetailViewHolder> {
    private List<StoryValue> storyDetailList;

    public SpanishDetailAdapter(List<StoryValue> storyDetailList) {
        this.storyDetailList = storyDetailList;
    }

    @NonNull
    @Override
    public SpanishDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spanish_detail_item_view, viewGroup, false);
        return new SpanishDetailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpanishDetailViewHolder spanishDetailViewHolder, int i) {
        spanishDetailViewHolder.onBind(storyDetailList.get(i));

    }

    @Override
    public int getItemCount() {
        return storyDetailList.size();
    }
}
