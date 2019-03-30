package com.example.everydaywithbible.model;

import java.util.List;

public class StoryKey {
    private List<StoryValue> accounts;
    private String title;

    public StoryKey(List<StoryValue> accounts, String title) {
        this.accounts = accounts;
        this.title = title;
    }

    public List<StoryValue> getAccounts() {
        return accounts;
    }

    public String getTitle() {
        return title;
    }
}
