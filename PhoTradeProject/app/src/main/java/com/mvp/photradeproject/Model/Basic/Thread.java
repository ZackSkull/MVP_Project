package com.mvp.photradeproject.Model.Basic;

/**
 * Created by Zackzack on 04/12/2016.
 */

public class Thread {
    private String id;
    private String productid;
    private String user;
    private String userbuy;
    private String status;
    private String trlat;
    private String trlong;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserbuy() {
        return userbuy;
    }

    public void setUserbuy(String userbuy) {
        this.userbuy = userbuy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrlat() {
        return trlat;
    }

    public void setTrlat(String trlat) {
        this.trlat = trlat;
    }

    public String getTrlong() {
        return trlong;
    }

    public void setTrlong(String trlong) {
        this.trlong = trlong;
    }
}
