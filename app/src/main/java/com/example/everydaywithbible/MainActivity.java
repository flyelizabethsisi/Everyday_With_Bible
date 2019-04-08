package com.example.everydaywithbible;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.fragment.DetailFragment;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.fragment.OnboardingFragment;
import com.example.everydaywithbible.fragment.SpanishDetailFragment;
import com.example.everydaywithbible.fragment.SplashFragment;
import com.example.everydaywithbible.fragment.TitleFragment;
import com.example.everydaywithbible.fragment.TitleFragmentSpanish;
import com.example.everydaywithbible.model.StoryKey;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements FragmentInterface, OnboardingFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSplashFragment();

    }

    @Override
    public void toSplashFragment() {
        SplashFragment splashFragment = SplashFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, splashFragment)
                .commit();
    }

    @Override
    public void toOnboardingFragment() {
        OnboardingFragment onboardingFragment = OnboardingFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, onboardingFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toTitleFragment() {
        TitleFragment titleFragment = TitleFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, titleFragment)
                .addToBackStack(null)
                .commit();
    }

    public void toTitleSpanishFragment() {
        TitleFragmentSpanish titleFragmentSpanish = TitleFragmentSpanish.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, titleFragmentSpanish)
                .addToBackStack(null)
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

    @Override
    public void toSpanishDetailFragment(StoryKey story) {
        String json = new Gson().toJson(story);

        SpanishDetailFragment spanishDetailFragment = SpanishDetailFragment.newInstance(json);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, spanishDetailFragment).addToBackStack(null)
                .commit();

    }

    @Override
    public void onFragmentInteraction() {
        toTitleFragment();
    }

    @Override
    public void spanishOnFragmentInteration() {
        toTitleSpanishFragment();
    }
}
