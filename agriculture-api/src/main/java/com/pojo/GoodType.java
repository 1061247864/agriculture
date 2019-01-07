package com.pojo;

import java.util.List;

public class GoodType {
    private Integer typeId;

    private String typeName;

    private Integer parentId;

    private Integer type;
    
    private List<GoodType> goodTypeList;
    
    

    public List<GoodType> getGoodTypeList() {
		return goodTypeList;
	}

	public void setGoodTypeList(List<GoodType> goodTypeList) {
		this.goodTypeList = goodTypeList;
	}

	public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}