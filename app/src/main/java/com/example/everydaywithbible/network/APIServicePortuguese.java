package com.example.everydaywithbible.network;

import com.example.everydaywithbible.model.StoryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIServicePortuguese {
    String PATH = "api/stories";
    @GET(PATH)
    Observable<StoryResponse> getStoryListPortuguese();
}