package com.ashwani.newsfeed.di.modules;

import android.content.Context;

import com.ashwani.newsfeed.di.scope.ApplicationContext;
import com.ashwani.newsfeed.di.scope.NewsFeedApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PicassoModule {
    @NewsFeedApplicationScope
    @Provides
    public Picasso picasso(@ApplicationContext Context context){
        return Picasso.with(context.getApplicationContext());
    }
}
