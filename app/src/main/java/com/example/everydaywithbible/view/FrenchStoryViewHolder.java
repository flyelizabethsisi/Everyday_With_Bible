package com.example.everydaywithbible.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;

import org.w3c.dom.Text;

public class FrenchStoryViewHolder extends RecyclerView.ViewHolder {
    private TextView frenchTitleFragmentTextView;

    public FrenchStoryViewHolder(@NonNull View itemView) {
        super(itemView);
        frenchTitleFragmentTextView = itemView.findViewById(R.id.story_title_textView_french);
    }


    public void onBind(final StoryKey story, FragmentInterface fragmentInterface) {
        frenchTitleFragmentTextView.setText(story.getTitle());

        itemView.setOnClickListener(v -> {
            if (story.getAccounts().size() != 0) {
                //  fragmentInterface.(story);
                fragmentInterface.toFrenchDetailFragment(story);

            }
        });
    }
}
