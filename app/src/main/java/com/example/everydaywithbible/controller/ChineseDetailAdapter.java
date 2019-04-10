package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.view.ChineseDetailViewHolder;
import com.example.everydaywithbible.view.FrenchDetailViewHolder;

import java.util.List;

public class ChineseDetailAdapter extends RecyclerView.Adapter<ChineseDetailViewHolder> {
    private List<StoryValue> storyDetailList;

    public ChineseDetailAdapter(List<StoryValue> storyDetailList) {
        this.storyDetailList = storyDetailList;
    }

    @NonNull
    @Override
    public ChineseDetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chinese_detail_item_view, viewGroup, false);
        return new ChineseDetailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChineseDetailViewHolder chineseDetailViewHolder, int i) {
        chineseDetailViewHolder.onBind(storyDetailList.get(i));

    }

    @Override
    public int getItemCount() {
        return storyDetailList.size();
    }
}
