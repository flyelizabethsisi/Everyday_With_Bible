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

public class PortugueseDetailViewHolder extends RecyclerView.ViewHolder {

    private TextView portugueseDetailTitleText;
    private TextView portugueseDetailAuthorText;
    private TextView portugueseDetailVerseText;
    private Button portugueseDetailWebButton;

    public PortugueseDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        portugueseDetailTitleText = itemView.findViewById(R.id.portuguese_detail_story_title_textView);
        portugueseDetailAuthorText = itemView.findViewById(R.id.portuguese_detail_story_author_textView);
        portugueseDetailVerseText = itemView.findViewById(R.id.portuguese_detail_story_verse_textView);
        portugueseDetailWebButton = itemView.findViewById(R.id.portuguese_detail_story_web_button);

    }

    public void onBind(StoryValue storyValue) {

        portugueseDetailTitleText.setText(itemView.getContext().getString(R.string.portuguese_detail_title, storyValue.getTitle()));
        portugueseDetailAuthorText.setText(itemView.getContext().getString(R.string.portuguese_detail_author, storyValue.getAuthor()));
        portugueseDetailVerseText.setText(itemView.getContext().getString(R.string.portuguese_detail_verse, storyValue.getBible_ref()));
        if (storyValue.getAuthor() == null) {
            portugueseDetailAuthorText.setText(itemView.getContext().getString(R.string.portuguese_null_author));
        }
        portugueseDetailWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(storyValue.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
