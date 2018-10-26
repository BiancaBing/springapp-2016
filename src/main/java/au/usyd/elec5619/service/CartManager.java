package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.Cart;

public interface CartManager extends Serializable{
    
    public List<Cart> getCarts();
    
    public void addCart(Cart product);
    
    public Cart getCartById(int id);
    
    public void updateCart(Cart product);
    
    public void deleteCart(int id);
    
}