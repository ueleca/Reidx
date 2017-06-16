package com.uele.reidx.android.ui.activities.analyzer;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface AnalyzerReidxPresenter<V extends AnalyzerReidxView> extends ReidxPresenter<V> {
}
