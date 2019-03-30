package com.example.everydaywithbible.network;

import com.example.everydaywithbible.model.StoryData;
import com.example.everydaywithbible.model.StoryResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
   // String PATH = "{es}/api/stories";
    String PATH = "api/stories";

    @GET (PATH)
    Observable<StoryResponse> getStoryList();
    //Call<StoryWrapper> getStoryList (@Path ("es") String languageString);

}
//https://biblestories.org/api/stories
//https://biblestories.org/es/api/stories