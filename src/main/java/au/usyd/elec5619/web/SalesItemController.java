package au.usyd.elec5619.web;

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

import au.usyd.elec5619.domain.Cart;
import au.usyd.elec5619.domain.Orders;
import au.usyd.elec5619.domain.Sales;
import au.usyd.elec5619.service.CartManager;
import au.usyd.elec5619.service.OrderManager;
import au.usyd.elec5619.service.SaleManager;

@Controller
@RequestMapping(value="/sale/**")
public class SalesItemController {

	@Resource(name="saleManager")
	private SaleManager saleManager;
	
	@RequestMapping(value="/change/{id}/**", method=RequestMethod.GET)
	public String ChangeState(@PathVariable("id") int id,Model uiModel) {
		
		Sales s = this.saleManager.getSaleById(id);
		String state = s.getStatus();
		if(state.equals("Delivered")) {
			this.saleManager.changeState(state, id);
			System.out.println("sssss");
			return "review_customer";
		}
		else if(state.equals("Not confirmed")) {
			this.saleManager.changeState(state, id);
			System.out.println("sssss");
			this.saleManager.deleteSale(id);
		}
		else if(state.equals("Not completed")) {
			this.saleManager.changeState(state, id);
			System.out.println("sssss");
		}
		System.out.println(id);
		System.out.println(state);
		return "redirect:/order.htm";
		
	}
	
}
