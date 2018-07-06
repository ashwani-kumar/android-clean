package com.ashwani.newsfeed.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ashwani.newsfeed.R;
import com.ashwani.newsfeed.constants.ApplicationConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_news_title)
    TextView mNewsTitle;
    @BindView(R.id.tv_news_description)
    TextView mNewsDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);

        String title = getIntent().getStringExtra(ApplicationConstants.BUNDLE_CONSTANT_TITLE);
        String description = getIntent().getStringExtra(ApplicationConstants.BUNDLE_CONSTANT_DESCRIPTION);

        mNewsTitle.setText(title);
        mNewsDescription.setText(description);
    }
}
