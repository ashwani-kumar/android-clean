package com.ashwani.newsfeed.di.component;

import com.ashwani.newsfeed.di.modules.NewsFeedActivityModule;
import com.ashwani.newsfeed.di.scope.MainActivityScope;
import com.ashwani.newsfeed.presentation.adapters.NewsFeedAdapter;
import com.ashwani.newsfeed.presentation.ui.activities.NewsFeedActivity;
import com.ashwani.newsfeed.service.ApiClient;

import dagger.Component;

@Component(modules = NewsFeedActivityModule.class, dependencies = NewsFeedComponent.class)
@MainActivityScope
public interface NewFeedActivityComponent {
    NewsFeedAdapter getNewsFeedAdapter();
    ApiClient getApiClient();
    void injectMainActivity(NewsFeedActivity newsFeedActivity);
}
