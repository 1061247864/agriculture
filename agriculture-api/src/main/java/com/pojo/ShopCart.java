package com.pojo;

import java.util.Date;

public class ShopCart {
    private Integer shopcId;

    private Date createdate;

    private Integer userId;

    private String priceCount;

    public Integer getShopcId() {
        return shopcId;
    }

    public void setShopcId(Integer shopcId) {
        this.shopcId = shopcId;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(String priceCount) {
        this.priceCount = priceCount == null ? null : priceCount.trim();
    }
}