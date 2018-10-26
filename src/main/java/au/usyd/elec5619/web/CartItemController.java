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

import au.usyd.elec5619.dao.CartItemDao;
import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.domain.Orders;
import au.usyd.elec5619.service.CartManager;
import au.usyd.elec5619.service.OrderManager;


@Controller
@RequestMapping(value="/cart/**")
public class CartItemController {
	
	
	@Resource(name="cartManager")
	private CartManager cartManager;
	@Resource(name="orderManager")
	private OrderManager orderManager;
	private int ids = 0;
	
	@RequestMapping(value="/checkout/{id}")
	public String checkout(@PathVariable("id") int id, Model uiModel) {
		ids=id;
		return "checkout";
	}
	
	
	@RequestMapping(value="/checkout/**", method=RequestMethod.POST)
	public String checkout(HttpServletRequest httpServletRequest) {	
		if(ids != 0) {
				Orders order = new Orders();
				order.setDescription(this.cartManager.getCartById(ids).getDescription());
				order.setQuantity(this.cartManager.getCartById(ids).getQuantity());
				order.setPrice(this.cartManager.getCartById(ids).getPrice());
				order.setName(this.cartManager.getCartById(ids).getName());
				order.setStatus("Not confirmed");
				order.setLocation(httpServletRequest.getParameter("location"));
				order.setTime(httpServletRequest.getParameter("time"));
				order.setContact(httpServletRequest.getParameter("contact"));
				this.orderManager.addOrder(order);
        }
		return "order.htm";
	}

	@RequestMapping(value="/add")
	public String addCart(Model uiModel) {
		
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCart(HttpServletRequest httpServletRequest) {
		
		Cart cart = new Cart();
		cart.setDescription(httpServletRequest.getParameter("description"));
		cart.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		cart.setSeller(httpServletRequest.getParameter("seller"));
		this.cartManager.addCart(cart);
		
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editCart(@PathVariable("id") int id, Model uiModel) {
		
		Cart cart = this.cartManager.getCartById(id);
		uiModel.addAttribute("cart", cart);
		
		return "edit";
	}
	/*@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editCart(@PathVariable("id") int id, @PathVariable("quantity") int quantity) {
		
		Cart cart = this.cartManager.editQuantity(quantity, id);
		this.cartManager.updateCart(cart);
		System.out.println(cart.getId());
		
		return "redirect:/cart.htm";
	}*/
	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editCart(@Valid int quantity, @ModelAttribute("cart") Cart cart) {
		
		int id = cart.getId();
		cart = this.cartManager.editQuantity(quantity, id);
		this.cartManager.updateCart(cart);
		System.out.println(cart.getId());
		
		return "redirect:/cart.htm";
	}
	

	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteCart(@PathVariable("id") int id) {
		
		this.cartManager.deleteCart(id);
		
		return "redirect:/cart.htm";
	}
	
	public String msg(String msg) {
		return "<script>alert('" + msg + "')</script>";
	    }
	
}
