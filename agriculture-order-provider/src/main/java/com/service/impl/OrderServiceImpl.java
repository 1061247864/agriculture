package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.OrderMapper;
import com.pojo.Order;
import com.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	
	@Override
	public PageInfo<Order> getOrderList(Integer currentPage,Order order) {
		PageHelper.startPage(currentPage, 2);
		List<Order> orderList = orderMapper.getOrderList(order);
		PageInfo<Order> pageInfo = new PageInfo<>(orderList);
		return pageInfo;
	}

	@Override
	public int delOrderById(Integer id) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.insertSelective(order);
	}

	@Override
	public int updOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKeySelective(order);
	}
	@Override
	public void updatesorder(Integer id, Integer idvalue) {
		orderMapper.updatesorder( id,  idvalue);
	}


}
