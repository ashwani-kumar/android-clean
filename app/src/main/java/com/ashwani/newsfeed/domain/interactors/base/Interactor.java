package com.ashwani.newsfeed.domain.interactors.base;


import com.ashwani.newsfeed.entity.model.NewFeed;

import io.reactivex.Observable;

public interface Interactor {

    Observable<NewFeed> execute();
}
