package au.usyd.elec5619.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import au.usyd.elec5619.domain.Orders;
import au.usyd.elec5619.service.OrderManager;

@Controller
@RequestMapping(value="/order/**")
public class OrderItemController {

	@Resource(name="orderManager")
	private OrderManager orderManager;
	
	@RequestMapping(value="/change/{id}/**", method=RequestMethod.GET)
	public String ChangeState(@PathVariable("id") int id,Model uiModel) {
		
		Orders o = this.orderManager.getOrderById(id);
		String state = o.getStatus();
		if(state.equals("Delivered")) {
			this.orderManager.changeState(state, id);
			System.out.println("sssss");
			return "review_customer";
		}
		else if(state.equals("Not confirmed")) {
			this.orderManager.changeState(state, id);
			System.out.println("sssss");
			this.orderManager.deleteOrder(id);
		}
		else if(state.equals("Not completed")) {
			this.orderManager.changeState(state, id);
			System.out.println("sssss");
		}
		System.out.println(id);
		System.out.println(state);
		return "redirect:/order.htm";
		
	}
	
/*	@RequestMapping(value="/change/{id}/{status}", method=RequestMethod.GET)
	public String ChangeState(@PathVariable("id") int id, @PathVariable("status") String state,Model uiModel) {
		
		Orders o = this.orderManager.getOrderById(id);
		if(state=="Delivered") {
			this.orderManager.changeState(state, id);
			System.out.println("sssss");
			return "review_customer";
		}
		else if(state=="Not confirmed") {
			this.orderManager.changeState(state, id);
			System.out.println("sssss");
			this.orderManager.deleteOrder(id);
			return "redirect:/order";
		}
		else if(state=="Not completed") {
			this.orderManager.changeState(state, id);
			System.out.println("sssss");
			return "redirect:/order.htm";
		}
		this.orderManager.changeState(state, id);
		return "redirect:/order.htm";
		
	}*/
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteCart(@PathVariable("id") int id) {
		
		this.orderManager.deleteOrder(id);
		
		return "redirect:/order.htm";
	}
	
	/*@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editProduct(@Valid Product product) {
		
		this.productManager.updateProduct(product);
		System.out.println(product.getId());
		
		return "redirect:/order.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") int id) {
		
		this.productManager.deleteProduct(id);
		
		return "redirect:/cart.htm";
	}*/
	
}
