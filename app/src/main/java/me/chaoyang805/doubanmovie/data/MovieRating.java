package me.chaoyang805.doubanmovie.data;

import io.realm.RealmObject;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class MovieRating extends RealmObject {

    private float max;

    private float average;

    private String stars;

    private String min;

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
