package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.ShopCart;
import com.pojo.ShopcItem;
import com.service.OrderService;
import com.service.ShopCartService;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ShopCartService shopCartService;
	
	
	@RequestMapping("getOrder")
	public PageInfo<Order> findOrder(
			@RequestParam(value="currentPage",required=false,defaultValue="1")Integer currentPage,@RequestBody Order order
			) {
		return orderService.getOrderList(currentPage, order);
		
	}
	
	@RequestMapping("delOrder/{id}")
	public int delOrder(@PathVariable(value="id",required=false)int id) {
		return orderService.delOrderById(id);

	}
	
	
	@RequestMapping("addOrder")
	public int addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
		
	}
	
	@RequestMapping("updOrder")
	public int updOrder(@RequestBody Order order) {
		return orderService.updOrder(order);
		
	}
	@RequestMapping("updatesorder")
	public int updatesorder(Integer orderId,Integer status) {
		 orderService.updatesorder(orderId, status+1);
		 return 1;
	}

	@PostMapping("createOrderByShopCart")
	public Order createOrder(@RequestParam("shopcId") Integer shopcId) {
			ShopCart shopCart = shopCartService.selectByShopcId(shopcId);
			List<ShopcItem> shopcItemList = shopCart.getShopcItem();
			Order order = new Order();
			order.setUserId(1);
			order.setCountPrice(shopCart.getPriceCount()+"");
			order.setStatus(0);
			int flag = orderService.addOrder(order);
			if (flag>0) {
				int count = 0;
				for (ShopcItem shopcItem : shopcItemList) {
					OrderItem orderItem = new OrderItem();
					orderItem.setOrderId(order.getOrderId());
					orderItem.setGoodId(shopcItem.getGoodId());
					orderItem.setCountPrice(shopcItem.getCount()*shopcItem.getGoods().getPrice()+"");
					orderItem.setGoodNumber(shopcItem.getCount());
					count+= orderService.addOrderItem(orderItem);
				}
				if (count>0) {
					return orderService.getOrder(order.getOrderId());
				}
				return null;
			}
			
		return null;
	}
	
	@PostMapping("createOrderByGoodId")
	public Order createOrderByGoodId(@RequestBody OrderItem orderItem) {
		Order order = new Order();
		order.setUserId(1);
		order.setCountPrice(orderItem.getCountPrice());
		order.setStatus(0);
		int flag = orderService.addOrder(order);
		if (flag>0) {
				orderItem.setOrderId(order.getOrderId());
				int count = orderService.addOrderItem(orderItem);
				if (count>0) {
					return orderService.getOrder(order.getOrderId());
				}
				return null;
			}
		return null;
	}
}
