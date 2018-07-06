package com.ashwani.newsfeed.domain.repository;

import com.ashwani.newsfeed.domain.model.NewFeed;

import io.reactivex.Observable;

public interface FeedRepository {
    Observable<NewFeed> getNewsFeed();
}
