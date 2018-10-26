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
@RequestMapping(value="/product/**")
public class CartItemController {
	
	
	@Resource(name="productManager")
	private CartManager productManager;

	@RequestMapping(value="/add")
	public String addCart(Model uiModel) {
		
		return "add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProduct(HttpServletRequest httpServletRequest) {
		
		Cart product = new Cart();
		product.setDescription(httpServletRequest.getParameter("description"));
		product.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		product.setSeller(httpServletRequest.getParameter("seller"));
		this.productManager.addCart(product);
		
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String editCart(@PathVariable("id") int id, Model uiModel) {
		
		Cart product = this.productManager.getCartById(id);
		uiModel.addAttribute("product", product);
		
		return "edit";
	}
	
	@RequestMapping(value="/edit/**", method=RequestMethod.POST)
	public String editCart(@Valid Cart product) {
		
		this.productManager.updateCart(product);
		System.out.println(product.getId());
		
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value="/checkout/{id}", method=RequestMethod.GET)
	public String checkout(@PathVariable("id") int id, Model uiModel) {
		
		Cart product = this.productManager.getCartById(id);
		uiModel.addAttribute("product", product);
		
		return "edit";
	}
	
	@RequestMapping(value="/checkout/**", method=RequestMethod.POST)
	public String checkout(@Valid Cart product) {
		
		this.productManager.updateCart(product);
		System.out.println(product.getId());
		
		return "redirect:/cart.htm";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteCart(@PathVariable("id") int id) {
		
		this.productManager.deleteCart(id);
		
		return "redirect:/cart.htm";
	}
}
