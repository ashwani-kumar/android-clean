package com.ashwani.newsfeed.domain.repository;

import com.ashwani.newsfeed.domain.model.NewFeed;
import com.ashwani.newsfeed.service.APIInterface;
import com.ashwani.newsfeed.service.ApiClient;

import javax.inject.Inject;

import io.reactivex.Observable;

public class NewsFeedRepository implements FeedRepository {

    private String paramApiKey;

    @Inject
    public NewsFeedRepository(String apiKey) {
        paramApiKey = apiKey;
    }

    @Override
    public Observable<NewFeed> getNewsFeed() {
        return ApiClient.getClient().create(APIInterface.class).getNewsFeed(paramApiKey);
    }
}
