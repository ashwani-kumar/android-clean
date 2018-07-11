package com.ashwani.newsfeed.presentation.presenters.impl;

import com.ashwani.newsfeed.domain.interactors.base.NewsFeedInteractor;
import com.ashwani.newsfeed.domain.interactors.impl.NewsFeedInteractorImpl;
import com.ashwani.newsfeed.domain.model.NewsFeedEntityDomainMapper;
import com.ashwani.newsfeed.domain.repository.FeedRepository;
import com.ashwani.newsfeed.presentation.presenters.NewsFeedPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsFeedPresenterImpl implements NewsFeedPresenter {

    private final FeedRepository mFeedRepository;
    private NewsFeedPresenter.View mView;
    private NewsFeedEntityDomainMapper newsFeedEntityDomainMapper;

    @Inject
    public NewsFeedPresenterImpl(View view, FeedRepository feedRepository, NewsFeedEntityDomainMapper newsFeedEntityDomainMapper) {
        super();
        mView = view;
        mFeedRepository = feedRepository;
        this.newsFeedEntityDomainMapper = newsFeedEntityDomainMapper;
    }

    public void getNewsFeeds() {
        mView.showProgress();
        NewsFeedInteractor newsFeedInteractor = new NewsFeedInteractorImpl(mFeedRepository);
        newsFeedInteractor.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(results -> {
            if(mView != null){
                mView.hideProgress();
                mView.newsFeedResponse(newsFeedEntityDomainMapper.mapResults(results.getResults()));
            }
        }, throwable ->{
            mView.hideProgress();
            mView.showError(throwable.getMessage());
        });
    }
}
