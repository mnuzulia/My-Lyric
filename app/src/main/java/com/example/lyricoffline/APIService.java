package com.example.lyricoffline;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIService {
    @GET("novels/{id}")
    Call<Lyric> getLyrics(
    );
}


