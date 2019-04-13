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

public class ChineseDetailViewHolder extends RecyclerView.ViewHolder {

    private TextView chineseDetailTitleText;
    private TextView chineseDetailAuthorText;
    private TextView chineseDetailVerseText;
    private Button chineseDetailWebButton;

    public ChineseDetailViewHolder(@NonNull View itemView) {
        super(itemView);
        chineseDetailTitleText = itemView.findViewById(R.id.chinese_detail_story_title_textView);
        chineseDetailAuthorText = itemView.findViewById(R.id.chinese_detail_story_author_textView);
        chineseDetailVerseText = itemView.findViewById(R.id.chinese_detail_story_verse_textView);
        chineseDetailWebButton = itemView.findViewById(R.id.chinese_detail_story_web_button);
    }

    public void onBind(StoryValue storyValue) {

        chineseDetailTitleText.setText(itemView.getContext().getString(R.string.chinese_detail_text, storyValue.getTitle()));
        chineseDetailAuthorText.setText(itemView.getContext().getString(R.string.chinese_author_text, storyValue.getAuthor()));
        chineseDetailVerseText.setText(itemView.getContext().getString(R.string.chinese_verse_text, storyValue.getBible_ref()));
        if (storyValue.getAuthor() == null) {
            chineseDetailAuthorText.setText("作者: -");
        }
        chineseDetailWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(storyValue.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
