package au.usyd.elec5619.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.dao.OrderItemDao;
import au.usyd.elec5619.dao.SalesItemDao;
import au.usyd.elec5619.domain.Sales;

@Service(value="saleManager")
@Transactional
public class DatabaseSaleManager implements SaleManager{

	@Autowired
	private SalesItemDao o;
	
	@Override
	public List<Sales> getSales() {
		
		return o.getSales();
	}

	@Override
	public void addSale(Sales order) {
		
		o.saveItem(order);
	}

	@Override
	public Sales getSaleById(int id) {

		return o.getItemById(id);
	}

	@Override
	public void updateSale(Sales order) {
		
		o.updateItem(order);
		
	}

	@Override
	public void deleteSale(int id) {
		
		o.deleteItem(id);
	}

	@Override
	public void changeState(String state, int id) {
		Sales orders = o.getItemById(id);
		if(state.equals("Not confirmed")) {
			orders.setStatus("Not completed");
			orders.setReview("View the order details");
		}
		else if(state.equals("Not completed")) {
			orders.setStatus("Delivered");
			orders.setReview(null);
		}
		else if(state.equals("Delivered")) {
			orders.setReview("View the product review");
		}
		
	}

	
}
