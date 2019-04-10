package com.example.everydaywithbible;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.everydaywithbible.controller.DetailAdapter;
import com.example.everydaywithbible.fragment.ChineseDetailFragment;
import com.example.everydaywithbible.fragment.DetailFragment;
import com.example.everydaywithbible.fragment.FragmentInterface;
import com.example.everydaywithbible.fragment.FrenchDetailFragment;
import com.example.everydaywithbible.fragment.OnboardingFragment;
import com.example.everydaywithbible.fragment.PortugueseDetailFragment;
import com.example.everydaywithbible.fragment.SpanishDetailFragment;
import com.example.everydaywithbible.fragment.SplashFragment;
import com.example.everydaywithbible.fragment.TitleFragment;
import com.example.everydaywithbible.fragment.TitleFragmentChinese;
import com.example.everydaywithbible.fragment.TitleFragmentFrench;
import com.example.everydaywithbible.fragment.TitleFragmentPortuguese;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulinks, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github_menu:
                String githubLink = "https://github.com/flyelizabethsisi/";
                goToUrl(githubLink);
                return true;
            case R.id.linked_in:
                String linkedinLink = "https://www.linkedin.com/in/flyelizabethsisi/";
                goToUrl(linkedinLink);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToUrl(String url) {
        Uri website = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, website);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        }
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
                //  .addToBackStack(null)
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
    public void toTitleFrenchFragment() {
        TitleFragmentFrench titleFragmentFrench = TitleFragmentFrench.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, titleFragmentFrench)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toFrenchDetailFragment(StoryKey story) {
        String json = new Gson().toJson(story);

        FrenchDetailFragment frenchDetailFragment = FrenchDetailFragment.newInstance(json);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, frenchDetailFragment).addToBackStack(null)
                .commit();
    }

    @Override
    public void toTitlePortugueseFragment() {
        TitleFragmentPortuguese titleFragmentPortuguese = TitleFragmentPortuguese.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, titleFragmentPortuguese)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toPortugeseDetailFragment(StoryKey story) {
        String json = new Gson().toJson(story);

        PortugueseDetailFragment portugueseDetailFragment = PortugueseDetailFragment.newInstance(json);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, portugueseDetailFragment).addToBackStack(null)
                .commit();
    }

    @Override
    public void toTitleChineseFragment() {
        TitleFragmentChinese titleFragmentChinese = TitleFragmentChinese.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, titleFragmentChinese)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toChineseDetailFragment(StoryKey story) {
        String json = new Gson().toJson(story);

        ChineseDetailFragment chineseDetailFragment = ChineseDetailFragment.newInstance(json);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_container, chineseDetailFragment).addToBackStack(null)
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

    @Override
    public void frenchOnFragmentInteraction() {
        toTitleFrenchFragment();
    }

    @Override
    public void portugueseOnFragmentInteraction() {
        toTitlePortugueseFragment();
    }

    @Override
    public void chineseOnFragmentInteraction() { toTitleChineseFragment();

    }


}
