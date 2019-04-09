package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.view.FrenchDetailViewHolder;
import com.example.everydaywithbible.view.SpanishDetailViewHolder;

import java.util.List;

public class FrenchDetailAdapter extends RecyclerView.Adapter<FrenchDetailViewHolder> {
    private List<StoryValue> storyDetailList;

    public FrenchDetailAdapter(List<StoryValue> storyDetailList) {
        this.storyDetailList = storyDetailList;
    }

    @NonNull
    @Override
    public FrenchDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.french_detail_item_view, viewGroup, false);
        return new FrenchDetailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull FrenchDetailViewHolder frenchDetailViewHolder, int i) {
        frenchDetailViewHolder.onBind(storyDetailList.get(i));

    }

    @Override
    public int getItemCount() {
        return storyDetailList.size();
    }
}
