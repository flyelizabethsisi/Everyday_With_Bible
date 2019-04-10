package com.example.everydaywithbible.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;

public class ChineseStoryViewHolder extends RecyclerView.ViewHolder {
    private TextView chineseTitleFragmentTextView;

    public ChineseStoryViewHolder(@NonNull View itemView) {
        super(itemView);
        chineseTitleFragmentTextView = itemView.findViewById(R.id.story_title_textView_chinese);
    }
    public void onBind(final StoryKey story, FragmentInterface fragmentInterface) {
        chineseTitleFragmentTextView.setText(story.getTitle());

        itemView.setOnClickListener(v -> {
            if (story.getAccounts().size() != 0) {
                fragmentInterface.toChineseDetailFragment(story);

            }
        });
    }
}
