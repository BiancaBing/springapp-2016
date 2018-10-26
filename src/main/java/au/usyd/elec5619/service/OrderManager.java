package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Orders;

public interface OrderManager extends Serializable{

    public List<Orders> getOrders();
    
    public void addOrder(Orders order);
    
    public Orders getOrderById(int id);
    
    public void updateOrder(Orders order);
    
    public void deleteOrder(int id);
        
}
