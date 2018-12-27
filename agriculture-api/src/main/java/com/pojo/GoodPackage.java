package com.pojo;

import java.util.Date;

public class GoodPackage {
    private Integer goodpackageId;

    private String name;

    private String price;

    private Date createdate;

    private Date lastupdatetime;

    public Integer getGoodpackageId() {
        return goodpackageId;
    }

    public void setGoodpackageId(Integer goodpackageId) {
        this.goodpackageId = goodpackageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }
}