package com.ashwani.newsfeed;

import com.ashwani.newsfeed.domain.interactors.impl.NewsFeedInteractorImpl;
import com.ashwani.newsfeed.domain.repository.NewsFeedRepository;
import com.ashwani.newsfeed.service.APIInterface;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NewsFeedInteractorTest {
    @Mock private Executor mExecutor;
    @Mock private NewsFeedRepository mMessageRepository;
    @Mock private APIInterface apiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testGetNewsFeed(){
        NewsFeedInteractorImpl interactor = new NewsFeedInteractorImpl(mMessageRepository);
        interactor.run();

        Mockito.verify(mMessageRepository).getNewsFeed();
    }
}
