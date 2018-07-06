package com.ashwani.newsfeed.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiClient {
        public static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/";
        private static Retrofit retrofit = null;

        public static Retrofit getClient() {
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(JacksonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }
            return retrofit;
        }
}
