package com.example.everydaywithbible.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.view.DetailViewHolder;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailViewHolder> {
    private List<StoryValue> storyDetailList;

    public DetailAdapter(List<StoryValue> storyDetailList) {
        this.storyDetailList = storyDetailList;
    }

    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_item_view, viewGroup, false);
        return new DetailViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder detailViewHolder, int i) {
        detailViewHolder.onBind(storyDetailList.get(i));
    }

    @Override
    public int getItemCount() {
        return storyDetailList.size();
    }
}
