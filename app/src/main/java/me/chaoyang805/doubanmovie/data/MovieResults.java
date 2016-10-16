package me.chaoyang805.doubanmovie.data;

import java.util.List;

/**
 * Created by chaoyang805 on 16/10/17.
 */

public class MovieResults {

    private String title;

    private int count;

    private int total;

    private int start;

    private List<DoubanMovie> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<DoubanMovie> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<DoubanMovie> subjects) {
        this.subjects = subjects;
    }
}
