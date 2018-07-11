package com.ashwani.newsfeed.domain.interactors.impl;

import com.ashwani.newsfeed.domain.interactors.base.AbstractInteractor;
import com.ashwani.newsfeed.domain.interactors.base.NewsFeedInteractor;
import com.ashwani.newsfeed.entity.model.NewFeed;
import com.ashwani.newsfeed.domain.repository.FeedRepository;

import io.reactivex.Observable;

public class NewsFeedInteractorImpl extends AbstractInteractor implements NewsFeedInteractor{
    private FeedRepository mFeedRepository;

    public NewsFeedInteractorImpl(FeedRepository feedRepository) {
        super();
        mFeedRepository = feedRepository;
    }

    @Override
    public Observable<NewFeed> run() {
        return mFeedRepository.getNewsFeed();
    }
}
