package com.uele.reidx.android.ui.activities.main;

import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainReidxView mMockMainReidxView;

    @Mock
    DataManager mMockDataManager;

    private MainPresenter<MainReidxView> mMainPresenter;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mMainPresenter = new MainPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mMainPresenter.onAttach(mMockMainReidxView);
    }

    @After
    public void tearDown() throws Exception {

    }

}