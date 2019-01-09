package com.pojo;

import java.io.Serializable;
import java.util.Date;

public class Permission implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer perId;

    private String perName;

    private String preMenuName;

    private String preMenuUrl;

    private Date createDate;

    private String component;
    
    private String perType;
    
    

    public String getPerType() {
		return perType;
	}

	public void setPerType(String perType) {
		this.perType = perType;
	}

	public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    public String getPreMenuName() {
        return preMenuName;
    }

    public void setPreMenuName(String preMenuName) {
        this.preMenuName = preMenuName == null ? null : preMenuName.trim();
    }

    public String getPreMenuUrl() {
        return preMenuUrl;
    }

    public void setPreMenuUrl(String preMenuUrl) {
        this.preMenuUrl = preMenuUrl == null ? null : preMenuUrl.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }
}