package com.example.everydaywithbible.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingletonPortuguese {
    private static Retrofit instance;
    private static final String URL = "https://historiasdabiblia.com.br/";

    private RetrofitSingletonPortuguese() {
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
}
//https://historiasdabiblia.com.br/api/stories