package com.ashwani.newsfeed.presentation.presenters;

import com.ashwani.newsfeed.domain.model.ResultDomain;
import com.ashwani.newsfeed.entity.model.Result;
import com.ashwani.newsfeed.presentation.ui.NewsFeedView;

import java.util.List;


public interface NewsFeedPresenter {

    interface View extends NewsFeedView {
        void newsFeedResponse(List<ResultDomain> results);
    }
}
