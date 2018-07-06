package com.ashwani.newsfeed;

import com.ashwani.newsfeed.domain.interactors.impl.NewsFeedInteractorImpl;
import com.ashwani.newsfeed.domain.repository.NewsFeedRepository;
import com.ashwani.newsfeed.presentation.presenters.impl.NewsFeedPresenterImpl;
import com.ashwani.newsfeed.presentation.ui.activities.NewsFeedActivity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NewsFeedPresenterImplTest {

    @Mock private NewsFeedRepository mMessageRepository;
    @Mock private NewsFeedInteractorImpl mNewsFeedInteractor;
    @Mock private NewsFeedActivity mMockedView;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNewsFeed(){
        NewsFeedPresenterImpl presenter = new NewsFeedPresenterImpl(mMockedView, mMessageRepository);
        presenter.getNewsFeeds();

        Mockito.verify(mNewsFeedInteractor).run();
    }
}
