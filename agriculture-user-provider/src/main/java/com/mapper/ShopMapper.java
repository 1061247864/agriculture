package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Shop;

public interface ShopMapper {
	public List<Shop> findShops (@Param("shopName")String shopName);

    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);


    Shop selectByPrimaryKey(Integer shopId);



    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}