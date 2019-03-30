package com.example.everydaywithbible.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.everydaywithbible.R;

import org.w3c.dom.Text;


public class DetailFragment extends Fragment {

    private static final String TITLE_KEY = "title_key";
    private static final String AUTHOR_KEY = "author_key";
    private static final String VERSE_KEY = "verse_key";
    private static final String WEB_KEY = "web_key";

    TextView detailTitleText;
    TextView detailAuthorText;
    TextView detailVerseText;
    Button detailWebText;

    String title, author, bibleVerse, website;

    private FragmentInterface mListener;

    public DetailFragment() {
    }


    public static DetailFragment newInstance(String title, String author, String bibleVerse, String website) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, title);
        args.putString(AUTHOR_KEY, author);
        args.putString(VERSE_KEY, bibleVerse);
        args.putString(WEB_KEY, website);

        fragment.setArguments(args);
        return fragment;
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(TITLE_KEY);
//            mParam2 = getArguments().getString(AUTHOR_KEY);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailTitleText = view.findViewById(R.id.detail_story_title_textView);
        detailAuthorText = view.findViewById(R.id.detail_story_author_textView);
        detailVerseText = view.findViewById(R.id.detail_story_verse_textView);

        detailTitleText.setText(getArguments().getString(TITLE_KEY));
        detailAuthorText.setText(getArguments().getString(AUTHOR_KEY));
        detailVerseText.setText(getArguments().getString(VERSE_KEY));
    }
// TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.toDetailFragment(website);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            mListener = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
