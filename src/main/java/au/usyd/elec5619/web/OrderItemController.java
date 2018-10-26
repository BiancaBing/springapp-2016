package au.usyd.elec5619.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.service.CartManager;

@Controller
@RequestMapping(value="/order/**")
public class OrderItemController {

	private CartManager productManager;

	@RequestMapping(value="/checkout/{id}", method=RequestMethod.GET)
	public String Checkout(@PathVariable("id") int id, Model uiModel) {
		
		Cart product = this.productManager.getCartById(id);
		uiModel.addAttribute("product", product);
		
		return "edit";
	}
	
	@RequestMapping(value="/checkout/**", method=RequestMethod.POST)
	public String Checkout(@Valid Cart product) {
		
		this.productManager.updateCart(product);
		System.out.println(product.getId());
		
		return "redirect:/order.htm";
	}
	
	@RequestMapping(value="/review/{id}", method=RequestMethod.GET)
	public String editProduct(@PathVariable("id") int id, Model uiModel) {
		
		Cart product = this.productManager.getCartById(id);
		uiModel.addAttribute("product", product);
		
		return "edit";
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
