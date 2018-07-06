package com.ashwani.newsfeed.di.modules;

import android.app.Activity;
import android.content.Context;

import com.ashwani.newsfeed.di.scope.NewsFeedApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    Context context;

    public ActivityModule(Activity context){
        this.context = context;
    }

    @Named("activity_context")
    @NewsFeedApplicationScope
    @Provides
    public Context context(){
        return this.context;
    }
}
