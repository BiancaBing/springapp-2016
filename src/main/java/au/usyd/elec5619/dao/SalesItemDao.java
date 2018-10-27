package au.usyd.elec5619.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import au.usyd.elec5619.domain.Sales;

@Repository(value = "salesItemDao")
public class SalesItemDao {
	
	@Resource
    private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveItem(Sales sale) {
        sessionFactory.getCurrentSession().save(sale);
    }
    
    public Sales editQuantity(int quantity,int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Sales c = (Sales) currentSession.get(Sales.class, id);
		c.setQuantity(quantity);
		return c;
	}
    
    public Sales getItemById(int id) {
    	Session currentSession = this.sessionFactory.getCurrentSession();
    	Sales order = (Sales) currentSession.get(Sales.class, id);
    	return order;	
    }
    
    public void updateItem(Sales order) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		currentSession.merge(order);
	}
    
    public void deleteItem(int id) {
		Session currentSession = this.sessionFactory.getCurrentSession();
		Sales order = (Sales) currentSession.get(Sales.class, id);
		currentSession.delete(order);
	}
	
	public List<Sales> getSales() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Sales").list();
	}
	

}
