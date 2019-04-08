package com.example.everydaywithbible.network;

import com.example.everydaywithbible.model.StoryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIServiceSpanish { // String PATH = "{es}/api/stories";
    String PATH = "es/api/stories";

    @GET(PATH)
    Observable<StoryResponse> getStoryListSpanish();

}
//https://biblestories.org/api/stories
//https://biblestories.org/es/api/stories