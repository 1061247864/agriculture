package com.pojo;

public class ShopcItem {
    private Integer shopcitemId;

    private Integer shopcId;

    private Integer goodId;
    
    private Integer count;
    
    
    private Goods goods;
    
    


	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getShopcitemId() {
        return shopcitemId;
    }

    public void setShopcitemId(Integer shopcitemId) {
        this.shopcitemId = shopcitemId;
    }

    public Integer getShopcId() {
        return shopcId;
    }

    public void setShopcId(Integer shopcId) {
        this.shopcId = shopcId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }
}