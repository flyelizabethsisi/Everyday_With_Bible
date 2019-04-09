package com.example.everydaywithbible.fragment;

import com.example.everydaywithbible.model.StoryKey;

public interface FragmentInterface {
    void toSplashFragment();
    void toOnboardingFragment();
    void toTitleFragment();
    void toDetailFragment(StoryKey story);
    void toTitleSpanishFragment();
    void toSpanishDetailFragment(StoryKey story);
    void toTitleFrenchFragment();
    void toFrenchDetailFragment(StoryKey story);

}
