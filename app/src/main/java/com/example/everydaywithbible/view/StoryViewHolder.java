package com.example.everydaywithbible.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.controller.StoryAdapter;
import com.example.everydaywithbible.fragment.DetailFragment;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryData;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryResponse;
import com.example.everydaywithbible.model.StoryValue;
import com.example.everydaywithbible.network.APIService;
import com.example.everydaywithbible.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class StoryViewHolder extends RecyclerView.ViewHolder {
    private TextView titleFragmentTextView;

    public StoryViewHolder(@NonNull View itemView) {
        super(itemView);
        titleFragmentTextView = itemView.findViewById(R.id.story_title_textView);
    }

    public void onBind(final StoryKey story, FragmentInterface fragmentInterface) {
        titleFragmentTextView.setText(story.getTitle());

        itemView.setOnClickListener(v -> {
            if (story.getAccounts().size() != 0) {
                fragmentInterface.toDetailFragment(story);
            }
        });
    }
}
