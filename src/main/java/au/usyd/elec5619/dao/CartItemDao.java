package au.usyd.elec5619.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Cart;

@Repository(value = "marketItemDao")
public class CartItemDao {
	@Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveItem(Cart product) {
        sessionFactory.getCurrentSession().save(product);
    }
    
    public Cart getItemById(int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Cart product = (Cart) currentSession.get(Cart.class, id);
    	return product;	
    }
    
    public void updateItem(Cart product) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(product);
	}
    
    public void deleteItem(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Cart product = (Cart) currentSession.get(Cart.class, id);
		currentSession.delete(product);
	}
	
	public List<Cart> getCarts() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Cart").list();
	}
}
