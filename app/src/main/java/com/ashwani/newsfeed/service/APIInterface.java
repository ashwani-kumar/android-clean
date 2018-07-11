package com.ashwani.newsfeed.service;

import com.ashwani.newsfeed.entity.model.NewFeed;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("7.json")
    Observable<NewFeed> getNewsFeed(@Query("api-key") String apiKey);
}
