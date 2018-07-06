package com.ashwani.newsfeed.domain.interactors.base;


import com.ashwani.newsfeed.domain.model.NewFeed;

import io.reactivex.Observable;

public interface Interactor {

    Observable<NewFeed> execute();
}
