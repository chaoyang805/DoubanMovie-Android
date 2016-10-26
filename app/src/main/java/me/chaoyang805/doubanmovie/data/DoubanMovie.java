package me.chaoyang805.doubanmovie.data;

import org.abego.treelayout.internal.util.java.lang.string.StringUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import me.chaoyang805.doubanmovie.utils.StringUtils;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class DoubanMovie extends RealmObject {

    @PrimaryKey
    private String id;

    @Index
    private String title;
    @Index
    private String originalTitle;

    private String subtype;
    @Index
    private String year;

    private int collectCount;

    private int wishCount;

    private int commentCount;

    private int ratingsCount;

    private String summary;

    private DoubanImage images;

    private MovieRating rating;

    private String alt;

    private String genresDesc;

    private String contriesDesc;

    private Date collectDate = new Date();

    // One to many properties

    private RealmList<DoubanCelebrity> casts;

    private RealmList<DoubanCelebrity> directors;

    // Ignored properties

    @Ignore
    private String castsDesc;

    @Ignore
    private String directorsDesc;

    @Ignore
    private List<String> genres;

    @Ignore
    private List<String> contries;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public int getWishCount() {
        return wishCount;
    }

    public void setWishCount(int wishCount) {
        this.wishCount = wishCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(int ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public DoubanImage getImages() {
        return images;
    }

    public void setImages(DoubanImage images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getGenresDesc() {
        if (this.genres.isEmpty()) {
            this.genresDesc = "";
        } else {
            this.genresDesc = StringUtils.combinedString(this.genres, "/");
        }
        return genresDesc;
    }

    public void setGenresDesc(String genresDesc) {
        this.genresDesc = genresDesc;
        if (genresDesc.contains("/")) {
            this.genres = Arrays.asList(genresDesc.split("/"));
        }
    }

    public String getContriesDesc() {
        if (this.contries.isEmpty()) {
            this.contriesDesc = "";
        } else {
            this.contriesDesc = StringUtils.combinedString(this.contries, "/");
        }
        return contriesDesc;
    }

    public void setContriesDesc(String contriesDesc) {
        this.contriesDesc = contriesDesc;
        if (contriesDesc.contains("/")) {
            this.contries = Arrays.asList(contriesDesc.split("/"));
        }
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public RealmList<DoubanCelebrity> getCasts() {
        return casts;
    }

    public void setCasts(RealmList<DoubanCelebrity> casts) {
        this.casts = casts;
    }

    public RealmList<DoubanCelebrity> getDirectors() {
        return directors;
    }

    public void setDirectors(RealmList<DoubanCelebrity> directors) {
        this.directors = directors;
    }

    public String getCastsDesc() {
        return StringUtils.combinedString(this.getCasts(), "/");
    }

    public String getDirectorsDesc() {
        return StringUtils.combinedString(this.getDirectors(), "/");
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getContries() {
        return contries;
    }

    public void setContries(List<String> contries) {
        this.contries = contries;
        this.contriesDesc = StringUtils.combinedString(contries, "/");
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }
}
