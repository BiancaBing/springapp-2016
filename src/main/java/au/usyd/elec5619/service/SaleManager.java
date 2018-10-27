package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Sales;

public interface SaleManager extends Serializable{

    public List<Sales> getSales();
    
    public void addSale(Sales order);
    
    public Sales getSaleById(int id);
    
    public void updateSale(Sales order);
    
    public void deleteSale(int id);
    
    public void changeState(String state, int id);
        
}
