package com.ashwani.newsfeed.presentation.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ashwani.newsfeed.NewsFeedApplication;
import com.ashwani.newsfeed.R;
import com.ashwani.newsfeed.constants.ApplicationConstants;
import com.ashwani.newsfeed.di.component.DaggerNewFeedActivityComponent;
import com.ashwani.newsfeed.di.component.NewFeedActivityComponent;
import com.ashwani.newsfeed.di.modules.NewsFeedActivityModule;
import com.ashwani.newsfeed.domain.model.ResultDomain;
import com.ashwani.newsfeed.entity.model.Result;
import com.ashwani.newsfeed.presentation.adapters.NewsFeedAdapter;
import com.ashwani.newsfeed.presentation.adapters.NewsFeedClickListener;
import com.ashwani.newsfeed.presentation.presenters.NewsFeedPresenter.View;
import com.ashwani.newsfeed.presentation.presenters.impl.NewsFeedPresenterImpl;
import com.ashwani.newsfeed.utility.AppUtils;
import com.ashwani.newsfeed.utility.PermissionUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsFeedActivity extends AppCompatActivity implements View, NewsFeedClickListener {

    @BindView(R.id.rv_news_list)
    RecyclerView mNewsFeedRecyclerView;
    @BindView(R.id.progress_bar_news_feed)
    ProgressBar mProgressBar;

    @Inject
    NewsFeedAdapter mNewsFeedAdapter;
    @Inject
    NewsFeedPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);
        ButterKnife.bind(this);
        NewFeedActivityComponent mainActivityComponent = DaggerNewFeedActivityComponent.builder()
                .newsFeedActivityModule(new NewsFeedActivityModule(this))
                .newsFeedComponent(NewsFeedApplication.get(this).getRandomUserApplicationComponent())
                .build();
        mainActivityComponent.injectMainActivity(this);

        mNewsFeedAdapter = mainActivityComponent.getNewsFeedAdapter();
        if(PermissionUtils.checkInternetPermission(this)){
            mPresenter.getNewsFeeds();
        }
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(android.view.View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(android.view.View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void newsFeedResponse(List<ResultDomain> results) {
        initializeAdapter(results);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionUtils.REQUEST_PERMISSION_INTERNET:
                if (ContextCompat.checkSelfPermission(NewsFeedActivity.this,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    mPresenter.getNewsFeeds();
                }else{
                    Toast.makeText(this, "Internet Permission required..!", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    public void initializeAdapter(List<ResultDomain> newsFeeds){
        LinearLayoutManager linearLayoutManagerForNewsFeedList = new LinearLayoutManager(this);
        linearLayoutManagerForNewsFeedList.setOrientation(LinearLayoutManager.VERTICAL);
        mNewsFeedRecyclerView.setLayoutManager(linearLayoutManagerForNewsFeedList);
        mNewsFeedRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mNewsFeedAdapter.setClickListener(this);
        mNewsFeedAdapter.setNewsFeedModel(newsFeeds);
        mNewsFeedRecyclerView.setAdapter(mNewsFeedAdapter);
    }

    @Override
    public void listItemClicked(ResultDomain result) {
        if(result != null){
            Intent detailIntent = new Intent(this, NewsDetailsActivity.class);
            detailIntent.putExtra(ApplicationConstants.BUNDLE_CONSTANT_TITLE, result.getTitle());
            detailIntent.putExtra(ApplicationConstants.BUNDLE_CONSTANT_DESCRIPTION, result.getAbstract());
            detailIntent.putExtra(ApplicationConstants.BUNDLE_CONSTANT_TITLE_IMAGE, AppUtils.getImageUrlFromResult(result));
            startActivity(detailIntent);
        }
    }
}
