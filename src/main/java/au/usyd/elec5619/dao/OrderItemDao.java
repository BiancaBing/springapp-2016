package au.usyd.elec5619.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Orders;

@Repository(value = "orderItemDao")
public class OrderItemDao {
	@Resource
    private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveItem(Orders order) {
        sessionFactory.getCurrentSession().save(order);
    }
    
    public Orders editQuantity(int quantity,int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Orders c = (Orders) currentSession.get(Orders.class, id);
		c.setQuantity(quantity);
		return c;
	}
    
    public Orders getItemById(int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Orders order = (Orders) currentSession.get(Orders.class, id);
    	return order;	
    }
    
    public void updateItem(Orders order) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(order);
	}
    
    public void deleteItem(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Orders order = (Orders) currentSession.get(Orders.class, id);
		currentSession.delete(order);
	}
	
	public List<Orders> getOrders() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Orders").list();
	}
	
}
