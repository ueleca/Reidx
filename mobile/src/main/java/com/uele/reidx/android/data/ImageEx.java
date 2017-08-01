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

import android.os.Parcel;
import android.os.Parcelable;

public class ImageEx
        implements Parcelable {

    private String lowResolutionImgUrl;
    private String mediumResolutionImgUrl;
    private String highResolutionImgUrl;

    public ImageEx() {
        // Empty constructor
    }

    protected ImageEx(Parcel in) {
        lowResolutionImgUrl = in.readString();
        mediumResolutionImgUrl = in.readString();
        highResolutionImgUrl = in.readString();
    }

    public String getLowResolutionImgUrl() {
        return lowResolutionImgUrl;
    }

    public void setLowResolutionImgUrl(String lowResolutionImgUrl) {
        this.lowResolutionImgUrl = lowResolutionImgUrl;
    }

    public String getMediumResolutionImgUrl() {
        return mediumResolutionImgUrl;
    }

    public void setMediumResolutionImgUrl(String mediumResolutionImgUrl) {
        this.mediumResolutionImgUrl = mediumResolutionImgUrl;
    }

    public String getHighResolutionImgUrl() {
        return highResolutionImgUrl;
    }

    public void setHighResolutionImgUrl(String highResolutionImgUrl) {
        this.highResolutionImgUrl = highResolutionImgUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(lowResolutionImgUrl);
        dest.writeString(mediumResolutionImgUrl);
        dest.writeString(highResolutionImgUrl);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ImageEx> CREATOR = new Parcelable.Creator<ImageEx>() {
        @Override
        public ImageEx createFromParcel(Parcel in) {
            return new ImageEx(in);
        }

        @Override
        public ImageEx[] newArray(int size) {
            return new ImageEx[size];
        }
    };
}
