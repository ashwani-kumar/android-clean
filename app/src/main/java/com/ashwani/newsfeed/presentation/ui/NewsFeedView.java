package com.ashwani.newsfeed.presentation.ui;

public interface NewsFeedView {

    void showProgress();

    void hideProgress();

    void showError(String message);
}
