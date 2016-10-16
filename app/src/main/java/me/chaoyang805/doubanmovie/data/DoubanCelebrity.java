package me.chaoyang805.doubanmovie.data;

import java.util.Arrays;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import me.chaoyang805.doubanmovie.utils.StringUtils;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class DoubanCelebrity extends RealmObject {

    @PrimaryKey
    private String id;

    @Index
    private String name;

    @Index
    private String nameEn;

    private String alt;

    private String mobileUrl;

    private DoubanImage avatars;

    private String gender;

    private String bornPlace;

    private RealmList<Work> works;

    private String akaDesc;

    private String akaEnDesc;

    @Ignore
    private List<String> aka;

    @Ignore
    private List<String> akaEn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public DoubanImage getAvatars() {
        return avatars;
    }

    public void setAvatars(DoubanImage avatars) {
        this.avatars = avatars;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public RealmList<Work> getWorks() {
        return works;
    }

    public void setWorks(RealmList<Work> works) {
        this.works = works;
    }

    public String getAkaDesc() {
        return akaDesc;
    }

    public void setAkaDesc(String akaDesc) {
        this.akaDesc = akaDesc;
        if (akaDesc.contains("/")) {
            this.aka = Arrays.asList(akaDesc.split("/"));
        }
    }

    public String getAkaEnDesc() {
        return akaEnDesc;
    }

    public void setAkaEnDesc(String akaEnDesc) {
        this.akaEnDesc = akaEnDesc;
        if (akaEnDesc.contains("/")) {
            this.akaEn = Arrays.asList(akaEnDesc.split("/"));
        }
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
        this.akaDesc = StringUtils.combinedString(aka, "/");
    }

    public List<String> getAkaEn() {
        return akaEn;
    }

    public void setAkaEn(List<String> akaEn) {
        this.akaEn = akaEn;
        this.akaEnDesc = StringUtils.combinedString(akaEn, "/");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
