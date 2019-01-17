package com.mapper;

import com.pojo.Order;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {
    /*long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);*/

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> getOrderList(@Param("order") Order order);
    
/*  List<Order> selectByExample(OrderExample example);*/
    
    Order selectByPrimaryKey(Integer orderId);
    
/*	int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);*/

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    void updatesorder(@Param("id") Integer id,@Param("idvalue") Integer idvalue);

}