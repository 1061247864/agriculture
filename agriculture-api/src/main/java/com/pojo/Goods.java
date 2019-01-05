package com.pojo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "goods")
public class Goods {
	@Field("goodId")
	private String goodId;
	@Field("goodName")
	private String goodName;
	@Field("status")
	private Integer status;
	@Field("price")
	private String price;
	@Field("company")
	private String company;
	@Field("context")
	private String context;
	@Field("sum")
	private Integer sum;
	@Field("sumBack")
	private Integer sumBack;
	@Field("shopId")
	private Integer shopId;
	@Field("categorylevel1id")
	private Integer categorylevel1id;
	@Field("categorylevel2id")
	private Integer categorylevel2id;
	@Field("categorylevel3id")
	private Integer categorylevel3id;

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName == null ? null : goodName.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price == null ? null : price.trim();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context == null ? null : context.trim();
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getSumBack() {
		return sumBack;
	}

	public void setSumBack(Integer sumBack) {
		this.sumBack = sumBack;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getCategorylevel1id() {
		return categorylevel1id;
	}

	public void setCategorylevel1id(Integer categorylevel1id) {
		this.categorylevel1id = categorylevel1id;
	}

	public Integer getCategorylevel2id() {
		return categorylevel2id;
	}

	public void setCategorylevel2id(Integer categorylevel2id) {
		this.categorylevel2id = categorylevel2id;
	}

	public Integer getCategorylevel3id() {
		return categorylevel3id;
	}

	public void setCategorylevel3id(Integer categorylevel3id) {
		this.categorylevel3id = categorylevel3id;
	}
}