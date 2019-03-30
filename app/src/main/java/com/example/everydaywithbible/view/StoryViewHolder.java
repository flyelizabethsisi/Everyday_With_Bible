package com.example.everydaywithbible.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.everydaywithbible.R;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.model.StoryKey;

public class StoryViewHolder extends RecyclerView.ViewHolder {
    private TextView titleFragmentTextView;

    public StoryViewHolder(@NonNull View itemView) {
        super(itemView);
        titleFragmentTextView = itemView.findViewById(R.id.story_title_textView);
    }

    public void onBind(final StoryKey story, final FragmentInterface fragmentInterface) {
        titleFragmentTextView.setText(story.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (story.getAccounts().size() == 1) {
                                                fragmentInterface.toDetailFragment(story.getAccounts().get(0).getAuthor(), story.getAccounts().get(0).getBible_ref(), story.getAccounts().get(0).getTitle(), story.getAccounts().get(0).getUrl());
                                            }
                                            if(story.getAccounts().size() ==2){
                                                fragmentInterface.toDetailFragment(story.getAccounts().get(0).getAuthor(), story.getAccounts().get(0).getBible_ref(), story.getAccounts().get(0).getTitle(), story.getAccounts().get(0).getUrl());
                                                fragmentInterface.toDetailFragment(story.getAccounts().get(1).getAuthor(), story.getAccounts().get(1).getBible_ref(), story.getAccounts().get(1).getTitle(), story.getAccounts().get(1).getUrl());
                                            }
                                        }
                                    }

        );

    }

    ;

}
