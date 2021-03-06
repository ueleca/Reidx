/*
 * Copyright (C) 2017 Uele, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.reidx.android.data.db.repository;

import com.uele.reidx.android.data.DealEx;
import com.uele.reidx.android.data.db.model.DaoSession;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

public class DealRepository {

    private final DaoSession mDaoSession;

    @Inject
    public DealRepository(DaoSession daoSession) {
        mDaoSession = daoSession;
    }
    public Observable<Boolean> isDealEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getDealDao().count() > 0);
            }
        });
    }

    public Observable<Boolean> saveDeal(final DealEx deal) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getDealDao().insert(property);
                return true;
            }
        });
    }

    public Observable<Boolean> saveDealList(final List<DealEx> propertyList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getDealDao().insertInTx(dealList);
                return true;
            }
        });
    }

    public Observable<List<DealEx>> getAllDeals() {
        return Observable.fromCallable(new Callable<List<DealEx>>() {
            @Override
            public List<DealEx> call() throws Exception {
                return mDaoSession.getDealDao().loadAll();
            }
        });
    }
}

