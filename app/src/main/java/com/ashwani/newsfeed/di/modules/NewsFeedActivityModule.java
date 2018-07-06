package com.ashwani.newsfeed.di.modules;

import com.ashwani.newsfeed.BuildConfig;
import com.ashwani.newsfeed.di.scope.MainActivityScope;
import com.ashwani.newsfeed.domain.repository.NewsFeedRepository;
import com.ashwani.newsfeed.presentation.adapters.NewsFeedAdapter;
import com.ashwani.newsfeed.presentation.presenters.impl.NewsFeedPresenterImpl;
import com.ashwani.newsfeed.presentation.ui.activities.NewsFeedActivity;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsFeedActivityModule {
    private final NewsFeedActivity newsFeedActivity;

    public NewsFeedActivityModule(NewsFeedActivity newsFeedActivity) {
        this.newsFeedActivity = newsFeedActivity;
    }

    @Provides
    @MainActivityScope
    public NewsFeedAdapter newsFeedAdapter(Picasso picasso) {
        return new NewsFeedAdapter(newsFeedActivity, picasso);
    }

    @Provides
    @MainActivityScope
    public NewsFeedPresenterImpl newsFeedPresenter(NewsFeedRepository newsFeedRepository) {
        return new NewsFeedPresenterImpl(newsFeedActivity, newsFeedRepository);
    }

    @Provides
    @MainActivityScope
    public NewsFeedRepository newFeedRepository() {
        return new NewsFeedRepository(BuildConfig.API_KEY);
    }
}
