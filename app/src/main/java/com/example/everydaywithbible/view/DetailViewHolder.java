package com.example.everydaywithbible.view;

import android.content.Intent;
import android.net.Uri;
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
    private TextView detailTitleText;
    private TextView detailAuthorText;
    private TextView detailVerseText;
    private Button detailWebButton;


    public DetailViewHolder(@NonNull View itemView) {
        super(itemView);
        detailTitleText = itemView.findViewById(R.id.detail_story_title_textView);
        detailAuthorText = itemView.findViewById(R.id.detail_story_author_textView);
        detailVerseText = itemView.findViewById(R.id.detail_story_verse_textView);
        detailWebButton = itemView.findViewById(R.id.detail_story_web_button);

    }

    public void onBind(StoryValue storyValue) {

        detailTitleText.setText(itemView.getContext().getString(R.string.english_title_text, storyValue.getTitle()));
        detailAuthorText.setText(itemView.getContext().getString(R.string.english_author_text, storyValue.getAuthor()));
        detailVerseText.setText(itemView.getContext().getString(R.string.english_verse_text, storyValue.getBible_ref()));
        if (storyValue.getAuthor() == null) {
            detailAuthorText.setText(itemView.getContext().getString(R.string.english_null_author));
        }

        detailWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(storyValue.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                itemView.getContext().startActivity(intent);
            }
        });
    }


}

