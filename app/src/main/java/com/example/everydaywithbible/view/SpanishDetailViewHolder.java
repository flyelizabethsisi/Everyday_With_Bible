package com.example.everydaywithbible.view;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.model.StoryValue;

public class SpanishDetailViewHolder extends RecyclerView.ViewHolder {
    private TextView spanishDetailTitleText;
    private TextView spanishDetailAuthorText;
    private TextView spanishDetailVerseText;
    private Button spanishDetailWebButton;


    public SpanishDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        spanishDetailTitleText = itemView.findViewById(R.id.spanish_detail_story_title_textView);
        spanishDetailAuthorText = itemView.findViewById(R.id.spanish_detail_story_author_textView);
        spanishDetailVerseText = itemView.findViewById(R.id.spanish_detail_story_verse_textView);
        spanishDetailWebButton = itemView.findViewById(R.id.spanish_detail_story_web_button);

    }

    public void onBind(StoryValue storyValue) {

        spanishDetailTitleText.setText(itemView.getContext().getString(R.string.spanish_detail_title, storyValue.getTitle()));
        spanishDetailAuthorText.setText(itemView.getContext().getString(R.string.spanish_author_detail, storyValue.getAuthor()));
        spanishDetailVerseText.setText(itemView.getContext().getString(R.string.spanish_verse_detail, storyValue.getBible_ref()));
        if (storyValue.getAuthor() == null) {
            spanishDetailAuthorText.setText(itemView.getContext().getString(R.string.spanish_null_author));
        }
        spanishDetailWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(storyValue.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                itemView.getContext().startActivity(intent);
            }
        });
    }


}

