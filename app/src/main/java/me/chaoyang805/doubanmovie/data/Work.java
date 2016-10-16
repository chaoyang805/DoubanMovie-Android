package me.chaoyang805.doubanmovie.data;

import java.sql.Struct;
import java.util.Arrays;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import me.chaoyang805.doubanmovie.utils.StringUtils;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class Work extends RealmObject {

    private String rolesDesc;

    private DoubanMovie subject;

    @Ignore
    private List<String> roles;

    public String getRolesDesc() {
        return rolesDesc;
    }

    public void setRolesDesc(String rolesDesc) {
        this.rolesDesc = rolesDesc;
        this.roles = Arrays.asList(rolesDesc.split("/"));
    }

    public DoubanMovie getSubject() {
        return subject;
    }

    public void setSubject(DoubanMovie subject) {
        this.subject = subject;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
        this.rolesDesc = StringUtils.combinedString(roles, "/");
    }
}
