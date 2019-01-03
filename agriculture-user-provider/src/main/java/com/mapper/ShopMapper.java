package com.mapper;

import com.pojo.Shop;

public interface ShopMapper {


    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);


    Shop selectByPrimaryKey(Integer shopId);



    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}