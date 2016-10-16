package me.chaoyang805.doubanmovie.data;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class DoubanImage extends RealmObject {
    @SerializedName("small")
    private String smallImageUrl;
    @SerializedName("medium")
    private String mediumImageUrl;
    @SerializedName("large")
    private String largeImageUrl;

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public String getMediumImageUrl() {
        return mediumImageUrl;
    }

    public void setMediumImageUrl(String mediumImageUrl) {
        this.mediumImageUrl = mediumImageUrl;
    }

    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    public void setLargeImageUrl(String largeImageUrl) {
        this.largeImageUrl = largeImageUrl;
    }
}
