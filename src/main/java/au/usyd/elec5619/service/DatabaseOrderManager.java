package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.dao.OrderItemDao;
import au.usyd.elec5619.domain.Orders;

@Service(value="orderManager")
@Transactional
public class DatabaseOrderManager implements OrderManager{

	@Autowired
	private OrderItemDao o;
	
	@Override
	public List<Orders> getOrders() {
		
		return o.getOrders();
	}

	@Override
	public void addOrder(Orders order) {
		
		o.saveItem(order);
	}

	@Override
	public Orders getOrderById(int id) {

		return o.getItemById(id);
	}

	@Override
	public void updateOrder(Orders order) {
		
		o.updateItem(order);
		
	}

	@Override
	public void deleteOrder(int id) {
		
		o.deleteItem(id);
	}

	@Override
	public void changeState(String state, int id) {
		Orders orders = o.getItemById(id);
		if(state.equals("Not confirmed")) {
			orders.setStatus("Not completed");
			orders.setReview("Cancel");
		}
		else if(state.equals("Not completed")) {
			orders.setStatus("Delivered");
			orders.setReview("Complete");
		}
		else if(state.equals("Delivered")) {
			orders.setReview("Please enter the review");
		}
		
	}

}
