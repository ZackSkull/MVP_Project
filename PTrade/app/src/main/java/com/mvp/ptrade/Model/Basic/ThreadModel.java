package com.mvp.ptrade.Model.Basic;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class ThreadModel {
    private String id;
//    private Product product;
//    private User userowner;
//    private User userbuyer;
    private String status;
    private String trlat;
    private String trlong;
    private String productid;
    private String user;
    private String userbuy;

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
