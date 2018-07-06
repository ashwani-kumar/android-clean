package com.ashwani.newsfeed.di.modules;


import android.content.Context;

import com.ashwani.newsfeed.di.scope.ApplicationContext;
import com.ashwani.newsfeed.di.scope.NewsFeedApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @ApplicationContext
    @NewsFeedApplicationScope
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }
}
