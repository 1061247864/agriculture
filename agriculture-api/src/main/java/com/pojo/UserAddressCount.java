package com.pojo;

import java.io.Serializable;

public class UserAddressCount implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String address; 
 private Integer count;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
 
}
