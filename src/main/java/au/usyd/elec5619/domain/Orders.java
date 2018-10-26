package au.usyd.elec5619.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="description")
    private String description;
	
	@Column(name="name")
    private String name;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="price")
    private Double price;
	
	@Column(name="status")
	private String status;
	
	@Column(name="location")
	private String location;
	
	@Column(name="time")
	private String time;
	
	@Column(name="contact")
	private String contact;
	
    public int getId() {
		return order_id;
	}

	public void setId(int order_id) {
		this.order_id = order_id;
	}

	public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getTime() {
        return time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getContact() {
        return contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Quantity: " + quantity);
        buffer.append("Price: " + price);
        buffer.append("Status: " + status);
        buffer.append("Location: " + location);
        buffer.append("Time: " + time);
        buffer.append("Contact: " + contact);
        buffer.append("Name: " + name);
        return buffer.toString();
    }
}
