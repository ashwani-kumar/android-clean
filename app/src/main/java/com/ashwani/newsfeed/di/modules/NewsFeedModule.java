package com.ashwani.newsfeed.di.modules;

import com.ashwani.newsfeed.di.scope.NewsFeedApplicationScope;
import com.ashwani.newsfeed.service.ApiClient;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class NewsFeedModule {
    public static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/";

    @Provides
    public ApiClient apiClient(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }

    @NewsFeedApplicationScope
    @Provides
    public Retrofit retrofit(JacksonConverterFactory jacksonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @NewsFeedApplicationScope
    @Provides
    public JacksonConverterFactory jacksonConverterFactory(){
        return JacksonConverterFactory.create();
    }

    @NewsFeedApplicationScope
    @Provides
    public RxJava2CallAdapterFactory rxJava2CallAdapterFactory(){
        return RxJava2CallAdapterFactory.create();
    }

}
