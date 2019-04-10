package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.view.PortugueseDetailViewHolder;
import com.example.everydaywithbible.view.SpanishDetailViewHolder;

import java.util.List;

public class PortugueseDetailAdapter extends RecyclerView.Adapter<PortugueseDetailViewHolder> {
    private List<StoryValue> storyDetailList;

    public PortugueseDetailAdapter(List<StoryValue> storyDetailList) {
        this.storyDetailList = storyDetailList;
    }

    @NonNull
    @Override
    public PortugueseDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.portuguese_detail_item_view, viewGroup, false);
        return new PortugueseDetailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull PortugueseDetailViewHolder portugueseDetailViewHolder, int i) {
        portugueseDetailViewHolder.onBind(storyDetailList.get(i));

    }

    @Override
    public int getItemCount() {
        return storyDetailList.size();
    }
}
