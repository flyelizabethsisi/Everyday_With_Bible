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

public class FrenchDetailViewHolder extends RecyclerView.ViewHolder {

    private TextView frenchDetailTitleText;
    private TextView frenchDetailAuthorText;
    private TextView frenchDetailVerseText;
    private Button frenchDetailWebButton;

    public FrenchDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        frenchDetailTitleText = itemView.findViewById(R.id.french_detail_story_title_textView);
        frenchDetailAuthorText = itemView.findViewById(R.id.french_detail_story_author_textView);
        frenchDetailVerseText = itemView.findViewById(R.id.french_detail_story_verse_textView);
        frenchDetailWebButton = itemView.findViewById(R.id.french_detail_story_web_button);

    }

    public void onBind(StoryValue storyValue) {

        frenchDetailTitleText.setText(itemView.getContext().getString(R.string.french_detail_title, storyValue.getTitle()));
        frenchDetailAuthorText.setText(itemView.getContext().getString(R.string.french_detail_author, storyValue.getAuthor()));
        frenchDetailVerseText.setText(itemView.getContext().getString(R.string.french_detail_verse, storyValue.getBible_ref()));
        if (storyValue.getAuthor() == null) {
            frenchDetailAuthorText.setText(itemView.getContext().getString(R.string.french_null_author));
        }
        frenchDetailWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(storyValue.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                itemView.getContext().startActivity(intent);
            }
        });
    }


}
