package com.pojo;

import java.util.Date;
import java.util.List;


public class Order {
    private Integer orderId;

    private Integer userId;

    private String countPrice;

    //@DateTimeFormat(pattern="")
    private Date createdate;

    private Integer status;
    
    private User user;
    
    private List<OrderItem> orderItemList;
    
    private String address;
    
    

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public Order() {
		super();
	}

	public Order(Integer orderId, Integer userId, String countPrice, Date createdate, Integer status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.countPrice = countPrice;
		this.createdate = createdate;
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(String countPrice) {
        this.countPrice = countPrice == null ? null : countPrice.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}