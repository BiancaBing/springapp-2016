package au.usyd.elec5619.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.usyd.elec5619.dao.CartItemDao;
import au.usyd.elec5619.domain.Cart;

@Service(value="productManager")
@Transactional
public class DatabaseCartManager implements CartManager {
	
	@Resource
	private CartItemDao m;
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
		//m.setSessionFactory(sf);
	}
	
	@Override
	public void addCart(Cart product) {
		this.sessionFactory.getCurrentSession().save(product);
		//m.saveItem(product);
	}
	
	@Override
	public Cart getCartById(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Cart product = (Cart) currentSession.get(Cart.class, id);
		//return m.getItemById(id);
		return product;
	}
	
	@Override
	public void updateCart(Cart product) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(product);
		//m.updateItem(product);
	}
	
	
	@Override
	public void deleteCart(int id) {
		//Session currentSession = this.sessionFactory.getCurrentSession();
		//Product product = (Product) currentSession.get(Product.class, id);
		//currentSession.delete(product);
		m.deleteItem(id);
	}


	@Override
	public List<Cart> getCarts() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Cart").list();
		//return m.getCarts();
	}

}
