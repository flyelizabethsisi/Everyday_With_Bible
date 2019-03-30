package com.example.everydaywithbible.model;

public class StoryResponse {
    private StoryData data;

    public StoryResponse(StoryData data){
        this.data = data;
    }

    public StoryData getData() {
        return data;
    }
}
