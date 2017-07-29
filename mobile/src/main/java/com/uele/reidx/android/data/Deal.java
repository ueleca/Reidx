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

import java.util.Date;


public class Deal
        implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Deal> CREATOR = new Parcelable.Creator<Deal>() {
        @Override
        public Deal createFromParcel(Parcel in) {
            return new Deal(in);
        }

        @Override
        public Deal[] newArray(int size) {
            return new Deal[size];
        }
    };
    /*
    public static final Parcelable.Creator<Deal> CREATOR
        = new Parcelable.Creator<Deal>()
    {
    public Deal createFromParcel(Parcel in)
    {
        L.m("create from parcel :Deal");
        return new Deal(in);
    }

    public Deal[] newArray(int size) {
        return new Deal[size];
    }
};*/
    // private long id;
    private String title;
    private Date releaseDateTheater;
    private int audienceScore;
    private String synopsis;
    private String urlThumbnail;
    private String urlSelf;
    private String urlCast;
    private String urlReviews;
    private String urlSimilar;
    private int id;
    private Image posterImage;
    private Image backdropImage;
    private Date releaseDate;
    private boolean adult;
    private Double voteAverage;
    private float voteCount;
    private double popularity;
    private String overview;

    public Deal() {

    }
/*
    public Deal(long id,
                 String title,
                 Date releaseDateTheater,
                 int audienceScore,
                 String synopsis,
                 String urlThumbnail,
                 String urlSelf,
                 String urlCast,
                 String urlReviews,
                 String urlSimilar) {
        this.id = id;
        this.title = title;
        this.releaseDateTheater = releaseDateTheater;
        this.audienceScore = audienceScore;
        this.synopsis = synopsis;
        this.urlThumbnail = urlThumbnail;
        this.urlSelf = urlSelf;
        this.urlCast = urlCast;
        this.urlReviews = urlReviews;
        this.urlSimilar = urlSimilar;
    }
    */

    protected Deal(Parcel in) {
        id = in.readInt();
        title = in.readString();
        posterImage = (Image) in.readValue(Image.class.getClassLoader());
        backdropImage = (Image) in.readValue(Image.class.getClassLoader());
        long tmpReleaseDate = in.readLong();
        releaseDate = tmpReleaseDate != -1 ? new Date(tmpReleaseDate) : null;
        adult = in.readByte() != 0x00;
        voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
        voteCount = in.readFloat();
        popularity = in.readDouble();
        overview = in.readString();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDateTheater() {
        return releaseDateTheater;
    }

    public void setReleaseDateTheater(Date releaseDateTheater) {
        this.releaseDateTheater = releaseDateTheater;
    }

    public int getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(int audienceScore) {
        this.audienceScore = audienceScore;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUrlThumbnail() {
        return urlThumbnail;
    }

    public void setUrlThumbnail(String urlThumbnail) {
        this.urlThumbnail = urlThumbnail;
    }

    public String getUrlSelf() {
        return urlSelf;
    }

    public void setUrlSelf(String urlSelf) {
        this.urlSelf = urlSelf;
    }

    public String getUrlCast() {
        return urlCast;
    }

    public void setUrlCast(String urlCast) {
        this.urlCast = urlCast;
    }

    public String getUrlReviews() {
        return urlReviews;
    }

    public void setUrlReviews(String urlReviews) {
        this.urlReviews = urlReviews;
    }

    public String getUrlSimilar() {
        return urlSimilar;
    }

    public void setUrlSimilar(String urlSimilar) {
        this.urlSimilar = urlSimilar;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nTitle " + title +
                "\nDate " + releaseDateTheater +
                "\nSynopsis " + synopsis +
                "\nScore " + audienceScore +
                "\nurlThumbnail " + urlThumbnail +
                "\nurlSelf " + urlSelf +
                "\nurlCast " + urlCast +
                "\nurlReviews " + urlReviews +
                "\nurlSimilar " + urlSimilar +
                "\n";
    }

    @Override
    public int describeContents() {

        return 0;
    }

    /*
        @Override
        public void writeToParcel(Parcel dest, int flags)
        {
            L.m("writeToParcel Deal");
            dest.writeLong(id);
            dest.writeString(title);
            dest.writeLong(releaseDateTheater == null ? -1 : releaseDateTheater.getTime());
            dest.writeInt(audienceScore);
            dest.writeString(synopsis);
            dest.writeString(urlThumbnail);
            dest.writeString(urlSelf);
            dest.writeString(urlCast);
            dest.writeString(urlReviews);
            dest.writeString(urlSimilar);
        }
       */
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(float voteCount) {
        this.voteCount = voteCount;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Image getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(Image posterImage) {
        this.posterImage = posterImage;
    }

    public Image getBackdropImage() {
        return backdropImage;
    }

    public void setBackdropImage(Image backdropImage) {
        this.backdropImage = backdropImage;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeValue(posterImage);
        dest.writeValue(backdropImage);
        dest.writeLong(releaseDate != null ? releaseDate.getTime() : -1L);
        dest.writeByte((byte) (adult ? 0x01 : 0x00));
        if (voteAverage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(voteAverage);
        }
        dest.writeFloat(voteCount);
        dest.writeDouble(popularity);
        dest.writeString(overview);
    }
}
