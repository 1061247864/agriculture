package com.mapper;

import com.pojo.ShopcItem;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShopcItemMapper {
    /*long countByExample(ShopcItemExample example);

    int deleteByExample(ShopcItemExample example);*/

    int deleteByPrimaryKey(Integer shopcitemId);

    int insert(ShopcItem record);

    int insertSelective(ShopcItem record);

    List<ShopcItem> selectByExample(ShopcItem example);

    ShopcItem selectByPrimaryKey(Integer shopcitemId);

   /* int updateByExampleSelective(@Param("record") ShopcItem record, @Param("example") ShopcItemExample example);

    int updateByExample(@Param("record") ShopcItem record, @Param("example") ShopcItemExample example);*/

    int updateByPrimaryKeySelective(ShopcItem record);

    int updateByPrimaryKey(ShopcItem record);
    
    List<ShopcItem> selectByshopcId(Integer shopcId);
    
    int delShopCartItem(@Param("items")List<Integer>  items);
}