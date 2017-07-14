/*
 * Copyright 2017 Uele, Inc
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

package com.uele.reidx.android.ui.fragments.dash.dealFeed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.uele.reidx.android.R;
import com.uele.reidx.android.data.network.model.DealsResponse;
import com.uele.reidx.android.ui.base.BaseViewHolder;
import com.uele.reidx.android.utils.ReidxLogger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DealFeedAdapter
        extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<DealsResponse.Deals> mDealsResponseList;

    public DealFeedAdapter(List<DealsResponse.Deals> dealsResponseList) {
        mDealsResponseList = dealsResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(
                                R.layout.item_blog_view, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(
                                R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDealsResponseList != null && mDealsResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mDealsResponseList != null && mDealsResponseList.size() > 0) {
            return mDealsResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<DealsResponse.Deals> dealsList) {
        mDealsResponseList.addAll(dealsList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onDealsEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.cover_image_view)
        ImageView coverImageView;

        @BindView(R.id.title_type_of_deal_text_view)
        TextView titleTypeOfDealTextView;

        @BindView(R.id.title_type_of_property_text_view)
        TextView titleTypeOfPropertyTextView;

        @BindView(R.id.title_city_text_view)
        TextView cityTextView;

        @BindView(R.id.title_province_text_view)
        TextView provinceTextView;

        @BindView(R.id.date_text_view)
        TextView dateTextView;

        @BindView(R.id.content_text_view)
        TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTypeOfDealTextView.setText("");
            titleTypeOfPropertyTextView.setText("");
            cityTextView.setText("");
            provinceTextView.setText("");
            contentTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final DealsResponse.Deals deals =
                    mDealsResponseList.get(position);

            if (deals.getCoverImgUrl() != null) {
                Glide.with(itemView.getContext())
                        .load(deals.getCoverImgUrl())
                        .asBitmap()
                        .centerCrop()
                        .into(coverImageView);
            }

            if (deals.getTitle() != null) {
                titleTypeOfDealTextView.setText(deals.getTitle());
            }

            if (deals.getAuthor() != null) {
                titleTypeOfPropertyTextView.setText(deals.getAuthor());
            }

            if (deals.getDate() != null) {
                dateTextView.setText(deals.getDate());
            }

            if (deals.getDescription() != null) {
                contentTextView.setText(deals.getDescription());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (deals.getDealsUrl() != null) {
                        try {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_VIEW);
                            intent.addCategory(Intent.CATEGORY_BROWSABLE);
                            intent.setData(Uri.parse(deals.getDealsUrl()));
                            itemView.getContext().startActivity(intent);
                        } catch (Exception e) {
                            ReidxLogger.d("url error");
                        }
                    }
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onDealsEmptyViewRetryClick();
        }
    }
}

