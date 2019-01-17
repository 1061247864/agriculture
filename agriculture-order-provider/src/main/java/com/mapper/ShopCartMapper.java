package com.mapper;

import com.pojo.ShopCart;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShopCartMapper {
   /* long countByExample(ShopCartExample example);

    int deleteByExample(ShopCartExample example);*/

    int deleteByPrimaryKey(Integer shopcId);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    /*List<ShopCart> selectByExample(ShopCartExample example);*/

    ShopCart selectByPrimaryKey(Integer shopcId);

    /*int updateByExampleSelective(@Param("record") ShopCart record, @Param("example") ShopCartExample example);

    int updateByExample(@Param("record") ShopCart record, @Param("example") ShopCartExample example);*/

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
}