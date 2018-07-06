package com.ashwani.newsfeed;

import android.app.Activity;
import android.app.Application;

import com.ashwani.newsfeed.di.component.DaggerNewsFeedComponent;
import com.ashwani.newsfeed.di.component.NewsFeedComponent;
import com.ashwani.newsfeed.di.modules.ContextModule;

import timber.log.Timber;

public class NewsFeedApplication extends Application {

    private NewsFeedComponent newsFeedComponent;

    public static NewsFeedApplication get(Activity activity){
        return (NewsFeedApplication) activity.getApplication();
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        newsFeedComponent = DaggerNewsFeedComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public NewsFeedComponent getRandomUserApplicationComponent(){
        return newsFeedComponent;
    }
}
