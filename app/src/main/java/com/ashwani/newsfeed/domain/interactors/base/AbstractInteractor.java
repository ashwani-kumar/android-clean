package com.ashwani.newsfeed.domain.interactors.base;

import com.ashwani.newsfeed.domain.model.NewFeed;

import io.reactivex.Observable;

public abstract class AbstractInteractor implements Interactor {

    protected volatile boolean mIsCanceled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor() {
    }

    public abstract Observable<NewFeed> run();

    public void cancel() {
        mIsCanceled = true;
        mIsRunning = false;
    }

    public boolean isRunning() {
        return mIsRunning;
    }

    public void onFinished() {
        mIsRunning = false;
        mIsCanceled = false;
    }

    public Observable<NewFeed> execute() {

        // mark this interactor as running
        this.mIsRunning = true;

        // start running this interactor in a background thread
        // run the main logic
        Observable<NewFeed> result = run();
        // mark it as finished
        onFinished();
        return result;
    }

}
