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

package com.uele.reidx.android.data;

public interface Keys {

    public interface EndpointDeals {
        public static final String KEY_Tenant = "movies";
        public static final String KEY_ID = "id";
        public static final String KEY_TITLE = "title";
        public static final String KEY_RELEASE_DATES = "release_dates";
        public static final String KEY_THEATER = "theater";
        public static final String KEY_RATINGS = "ratings";
        public static final String KEY_AUDIENCE_SCORE = "audience_score";
        public static final String KEY_SYNOPSIS = "synopsis";
        public static final String KEY_POSTERS = "posters";
        public static final String KEY_THUMBNAIL = "thumbnail";
        public static final String KEY_LINKS = "links";
        public static final String KEY_SELF = "self";
        public static final String KEY_CAST = "cast";
        public static final String KEY_REVIEWS = "reviews";
        public static final String KEY_SIMILAR = "similar";
    }

    public interface EndpointTenants {
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_HOME_PHONE = "home_phone";
        public static final String KEY_CELL_PHONE = "cell_phone";
        public static final String KEY_HOUSEHOLD_INCOME = "household_income";
        public static final String KEY_DEPOSIT = "deposit";
        public static final String KEY_RATINGS = "ratings";
    }

    public interface EndpointBrokers {
        public static final String KEY_ID = "id";
        public static final String KEY_BROKERAGE = "brokerage";
        public static final String KEY_AGENT_NAME = "agent_name";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_OFFICE_PHOME = "office_phone";
        public static final String KEY_CELL_PHONE = "cell_phone";
        public static final String KEY_BROKERAGE_PHONE = "brokerage_phone";
        public static final String KEY_RATINGS = "ratings";
    }

    public interface EndpointInvestors {
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "name";
        public static final String KEY_EMAIL = "email";
        public static final String KEY_OFFICE_PHOME = "office_phone";
        public static final String KEY_CELL_PHONE = "cell_phone";
        public static final String KEY_RATINGS = "ratings";
    }
}

