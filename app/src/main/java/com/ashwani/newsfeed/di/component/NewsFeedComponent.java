package com.ashwani.newsfeed.di.component;

import com.ashwani.newsfeed.di.scope.NewsFeedApplicationScope;
import com.ashwani.newsfeed.di.modules.NewsFeedModule;
import com.ashwani.newsfeed.di.modules.PicassoModule;
import com.ashwani.newsfeed.service.ApiClient;
import com.squareup.picasso.Picasso;

import dagger.Component;

@NewsFeedApplicationScope
@Component(modules = {NewsFeedModule.class, PicassoModule.class})
public interface NewsFeedComponent {
    ApiClient getApiClient();
    Picasso getPicasso();
}
