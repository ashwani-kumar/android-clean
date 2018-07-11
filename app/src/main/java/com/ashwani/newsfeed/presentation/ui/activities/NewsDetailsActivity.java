package com.ashwani.newsfeed.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashwani.newsfeed.R;
import com.ashwani.newsfeed.constants.ApplicationConstants;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_news_title)
    TextView mNewsTitle;
    @BindView(R.id.tv_news_description)
    TextView mNewsDescription;
    @BindView(R.id.im_news_img)
    ImageView mNewsImage;
    @Inject
    Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);

        String title = getIntent().getStringExtra(ApplicationConstants.BUNDLE_CONSTANT_TITLE);
        String description = getIntent().getStringExtra(ApplicationConstants.BUNDLE_CONSTANT_DESCRIPTION);
        String url = getIntent().getStringExtra(ApplicationConstants.BUNDLE_CONSTANT_TITLE_IMAGE);
        String format = getIntent().getStringExtra(ApplicationConstants.BUNDLE_CONSTANT_TITLE_IMAGE_FORMAT);
        mNewsTitle.setText(title);
        mNewsDescription.setText(description);
        if (url != null) {
            Picasso.with(this).load(url).into(mNewsImage);
        }
    }
}
