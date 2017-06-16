package com.uele.reidx.android.ui.activities.splash;

import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {

    @Mock
    SplashReidxView mMockSplashReidxView;

    @Mock
    DataManager mMockDataManager;

    private SplashPresenter<SplashReidxView> mSplashPresenter;
    private TestScheduler mTestScheduler;

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mSplashPresenter = new SplashPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mSplashPresenter.onAttach(mMockSplashReidxView);
    }

    @After
    public void tearDown() throws Exception {

    }
}