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

import com.uele.reidx.android.data.db.model.DaoSession;
import com.uele.reidx.android.data.db.model.Property;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

public class PropertyRepository {

    private final DaoSession mDaoSession;

    @Inject
    public PropertyRepository(DaoSession daoSession) {
        mDaoSession = daoSession;
    }

    public Observable<Boolean> isPropertyEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getPropertyDao().count() > 0);
            }
        });
    }

    public Observable<Boolean> saveProperty(final Property property) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getPropertyDao().insert(property);
                return true;
            }
        });
    }

    public Observable<Boolean> savePropertyList(final List<Property> propertyList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getPropertyDao().insertInTx(propertyList);
                return true;
            }
        });
    }

    public Observable<List<Property>> getAllPropertys() {
        return Observable.fromCallable(new Callable<List<Property>>() {
            @Override
            public List<Property> call() throws Exception {
                return mDaoSession.getPropertyDao().loadAll();
            }
        });
    }
}
