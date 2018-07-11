package com.ashwani.newsfeed.presentation.adapters;

import com.ashwani.newsfeed.domain.model.ResultDomain;

public interface NewsFeedClickListener {
    void listItemClicked(ResultDomain result);
}
