package com.example.everydaywithbible.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;
import com.example.everydaywithbible.model.StoryValue;

public class DetailViewHolder extends RecyclerView.ViewHolder {
    TextView detailTitleText;
    TextView detailAuthorText;
    TextView detailVerseText;
    Button detailWebButton;
    Button detailVerseButton;

    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
        detailTitleText = itemView.findViewById(R.id.detail_story_title_textView);
        detailAuthorText = itemView.findViewById(R.id.detail_story_author_textView);
        detailVerseText = itemView.findViewById(R.id.detail_story_verse_textView);

    }

    public void onBind(StoryKey storyKey, FragmentInterface fragmentInterface) {
       // for (storyKey.getAccounts().)


            for (StoryValue storyValue : storyKey.getAccounts()) {
                detailTitleText.setText(storyValue.getTitle());
                detailAuthorText.setText(storyValue.getAuthor());
                detailVerseText.setText(storyValue.getBible_ref());
                // detailWebButton.setText(storyValue.getUrl());
            }


    }
}
