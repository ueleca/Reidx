/*
 * Copyright 2016 Brian Donaldson
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

package com.uele.reidx.android.ui.fragments.liveFeed;

import com.uele.reidx.android.data.network.model.FeedResponse;
import com.uele.reidx.android.ui.base.ReidxView;

import java.util.List;

public interface LiveFeedReidxView extends ReidxView {

    void updateBlog(List<FeedResponse.Blog> blogList);
/*
        void renderBrokers(final List<Broker> brokers);
        void renderInvestors(final List<Investor> investors);
        void renderTenants(final List<Tenant> tenants);
*/
}
