package accountpro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Customer;
import accountpro.service.CustomerService;

@Controller
public class CustomerController {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

	private static final String USER_ID = null;

	private static final String PASSWORD = null;
	
	private CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="/listCustomers.htm")
	public ModelAndView showListCustomerForm(ModelMap model){
		
		List<Customer> customerList  = new ArrayList<Customer>();
		customerList = customerService.getCustomers();
		
		LOGGER.info("customerList size :"+customerList.size()+ " "+customerList.toString() );	
		return new ModelAndView("ListCustomer","customerList",customerList);
	}


	@RequestMapping(value="/addCustomer.htm")
	public ModelAndView showAddCustomerForm(Model model) {
	    Customer customer = new Customer(); 
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("AddCustomer");
	    mav.addObject("customer", customer);
	    return mav;
	}

	@RequestMapping(value="/searchCustomer.htm")
	public ModelAndView showSearchCustomerForm(Model model) {
	    Customer customer = new Customer(); 
	    ModelAndView mav = new ModelAndView();
	    
	    List<Customer> customers = customerService.searchCustomers(customer);
	    mav.addObject("customerList", customers);
	    mav.setViewName("SearchCustomer");
	    mav.addObject("customer", customer);
	    return mav;
	}

	@RequestMapping(value="/searchCustomer.htm",method=RequestMethod.POST)
	public ModelAndView searchCustomer(@ModelAttribute("customer")  @Valid Customer customer,BindingResult result, SessionStatus status) {
	    ModelAndView mav = new ModelAndView();
	    List<Customer> customers = customerService.searchCustomers(customer);
	    mav.setViewName("SearchCustomer");
	    mav.addObject("customerList", customers);
	    return mav;
	}

	
	@RequestMapping(value="/openCustomer.htm")
	public ModelAndView openCustomer(@RequestParam("id") String id)
	{
		//LOGGER.info("id "+id);
		ModelAndView mav = new ModelAndView();
		LOGGER.info("id: "+id);
		Customer cust = customerService.openCustomer(id);
		 mav.setViewName("AddCustomer");
		 mav.addObject("customer", cust);
		return mav;
		
	}
	
	
	@RequestMapping(value="/addCustomer.htm",method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("customer")  @Valid Customer customer,BindingResult result, SessionStatus status) {
	
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors() ){
			LOGGER.info("Error occurred in AddCustomer form ");
		    mav.setViewName("AddCustomer");
		    mav.addObject("customer", customer);
		    return mav;
		}
		else{
			int resultValue = 0;
			resultValue = customerService.addCustomer(customer);
			LOGGER.info("Customer added !! ");
		    mav.setViewName("AddCustomer");
		    mav.addObject("resultValue", resultValue);
		    mav.addObject("customer", customer);
		    return mav;
		}
	}

	@RequestMapping(value="/updateCustomer.htm",method=RequestMethod.POST)
	public ModelAndView updateCustomer(@ModelAttribute("customer")  @Valid Customer customer,BindingResult result, SessionStatus status) {
	
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors() ){
			LOGGER.info("Error occurred in AddCustomer form ");
		    mav.setViewName("AddCustomer");
		    mav.addObject("customer", customer);
		    return mav;
		}
		else{
			int resultValue = 0;
			resultValue = customerService.updateCustomer(customer);
			LOGGER.info("Customer updated !! ");
		    mav.setViewName("AddCustomer");
		    mav.addObject("resultValue", resultValue);
		    mav.addObject("customer", customer);
		    return mav;
		}
	}

	@RequestMapping(value="/deleteCustomer.htm",method=RequestMethod.POST)
	public ModelAndView deleteCustomer(@ModelAttribute("customer")  Customer customer,BindingResult result, SessionStatus status) {
	
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors() ){
			LOGGER.info("Error occurred in delete customer");
		    mav.setViewName("SearchCustomer");
		    mav.addObject("customerList", null);
		    return mav;
		}
		else{
			int resultValue = 0;
			resultValue = customerService.deleteCustomer(customer.getCustomerID());
			LOGGER.info("Customer deleted !! ");
		    mav.setViewName("SearchCustomer");
		    mav.addObject("resultValue", resultValue);
		    mav.addObject("customer", customer);
		    return mav;
		}
	}
	
}
