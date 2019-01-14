package com.pojo;

import java.util.Date;
import java.util.List;

public class ShopCart {
    private Integer shopcId;

    private Date createdate;

    private Integer userId;

    private String priceCount;
    
    private List<ShopcItem> shopcItem;
    
    


	public List<ShopcItem> getShopcItem() {
		return shopcItem;
	}

	public void setShopcItem(List<ShopcItem> shopcItem) {
		this.shopcItem = shopcItem;
	}

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