package com.example.everydaywithbible.model;

public class StoryValue {
    private String title;
    private String author;
    private String bible_ref;
    private String url;

    public StoryValue(String title, String author, String bible_ref, String url) {
        this.title = title;
        this.author = author;
        this.bible_ref = bible_ref;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBible_ref() {
        return bible_ref;
    }

    public String getUrl() {
        return url;
    }
}
