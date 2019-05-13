package com.abdullah.khan.cblpg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abdullah.khan.cblpg.model.Order;

@Component
public class OrderService {
	
	private static List<Order> orders = new ArrayList<>();
	static {
		
		
		Order order1 = new Order("1", "11122333","Purchese" ,  "11122333", 20000, "bdt","Test Product" ,"http://localhost/cbp/Approved.php","http://localhost/cbp/Cancelled.php","http://localhost/cbp/Declined.php", "" ,"");
		Order order2 = new Order("2", "11122333","Purchese" ,  "11122333", 20000, "bdt","Test Product" ,"http://localhost/cbp/Approved.php","http://localhost/cbp/Cancelled.php","http://localhost/cbp/Declined.php", "" ,"");
		Order order3 = new Order("3", "11122333","Purchese" ,  "11122333", 20000, "bdt","Test Product" ,"http://localhost/cbp/Approved.php","http://localhost/cbp/Cancelled.php","http://localhost/cbp/Declined.php", "" ,"");
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
	}

	public List<Order> retrieveAllOrders() {
		return orders;
	}
	
	public void saveOrder(Order newOrder) {
		orders.add(newOrder);
	}
	
	public Order retrieveOrder(String orderID) {
		
		for (Order ord : orders) {
			if (ord.getOrderID().equals(orderID)) {
				return ord;
			}
		}
		return null;
	}

	public void updateOrder(String orderStatus, String orderID) {
		for (Order ord : orders) {
			if (ord.getOrderID().equals(orderID)) {
				
				ord.setOrderStatus(orderStatus);
				break;
			}
		}
	}
}