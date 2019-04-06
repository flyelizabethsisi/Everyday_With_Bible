package com.example.everydaywithbible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.fragment.DetailFragment;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.fragment.TitleFragment;
import com.example.everydaywithbible.model.StoryKey;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, TitleFragment.newInstance())
                .commit();
    }

    @Override
    public void toDetailFragment(StoryKey story) {
        String json = new Gson().toJson(story);

        DetailFragment detailFragment = DetailFragment.newInstance(json);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, detailFragment).addToBackStack(null)
                .commit();
    }
}
