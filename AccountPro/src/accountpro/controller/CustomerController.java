package accountpro.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Customer;
import accountpro.domain.Policy;
import accountpro.domain.SearchCustomerCriteria;
import accountpro.exception.ServiceException;
import accountpro.service.CustomerService;
import accountpro.service.PolicyService;

@Controller
public class CustomerController {
	
	private static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	private CustomerService customerService;
	@Autowired
	private PolicyService policyService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="/addCustomer.htm")
	public ModelAndView showAddCustomerForm(Model model) {
	    Customer customer = new Customer(); 
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("AddCustomer");
	    mav.addObject("customer", customer);
	    return mav;
	}

	@RequestMapping(value="/pickerCustomer.htm")
	public ModelAndView showPickerCustomerForm(Model model) {
		SearchCustomerCriteria searchCustomerCriteria = new SearchCustomerCriteria();
	    ModelAndView mav = new ModelAndView();
	    
	    List<Customer> customers = customerService.searchCustomers(searchCustomerCriteria);
	    mav.addObject("customerList", customers);
	    mav.setViewName("PickerCustomer");
	    mav.addObject("searchCustomerCriteria", searchCustomerCriteria);
	    return mav;
	}

	@RequestMapping(value="/pickerCustomer.htm",method=RequestMethod.POST)
	public ModelAndView selectPickerCustomerForm(@ModelAttribute("searchCustomerCriteria") @Valid SearchCustomerCriteria searchCustomerCriteria,BindingResult result, SessionStatus status) {
	    ModelAndView mav = new ModelAndView();
	    List<Customer> customers = customerService.searchCustomers(searchCustomerCriteria);
	    mav.addObject("customerList", customers);
	    mav.setViewName("PickerCustomer");
	    mav.addObject("searchCustomerCriteria", searchCustomerCriteria);
	    return mav;
	}

	@RequestMapping(value="/searchCustomer.htm")
	public ModelAndView showSearchCustomerForm(Model model) {
		SearchCustomerCriteria searchCustomerCriteria = new SearchCustomerCriteria();
	    ModelAndView mav = new ModelAndView();
	    
	    List<Customer> customers = customerService.searchCustomers(searchCustomerCriteria);
	    mav.addObject("customerList", customers);
	    mav.setViewName("SearchCustomer");
	    mav.addObject("searchCustomerCriteria", searchCustomerCriteria);
	    return mav;
	}

	@RequestMapping(value="/searchCustomer.htm",method=RequestMethod.POST)
	public ModelAndView searchCustomer(@ModelAttribute("searchCustomerCriteria")  @Valid SearchCustomerCriteria searchCustomerCriteria,BindingResult result, SessionStatus status) {
	    ModelAndView mav = new ModelAndView();
	    List<Customer> customers = customerService.searchCustomers(searchCustomerCriteria);
	    mav.setViewName("SearchCustomer");
	    mav.addObject("customerList", customers);
	    return mav;
	}

	
	@RequestMapping(value="/openCustomer.htm")
	public ModelAndView openCustomer(@RequestParam("id") String cutomerId) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		LOGGER.info("cutomerId: "+cutomerId);
		try{
			Customer cust = customerService.openCustomer(cutomerId);
			List<Policy> policies = policyService.getCustomerPolicies(cutomerId);
			mav.setViewName("AddCustomer");
			mav.addObject("policies", policies);
			mav.addObject("customer", cust);
			return mav;
		}
		catch(Exception e){
			mav.setViewName("Exception");
		    mav.addObject("exceptionReason", e.getMessage());
		    return mav;
		}
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
			if(StringUtils.isBlank(customer.getCustomerID()))
				customer.setCustomerID(Integer.toString(resultValue));
			
			LOGGER.info("Customer added !! ");
		    mav.setViewName("AddCustomer");
		    //mav.addObject("resultValue", resultValue);
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
	public ModelAndView deleteCustomer(@ModelAttribute("searchCustomerCriteria")  SearchCustomerCriteria searchCustomerCriteria,BindingResult result, SessionStatus status) throws Exception {
	
		ModelAndView mav = new ModelAndView();
		
		try{
			if(result.hasErrors() ){
				LOGGER.info("Error occurred in delete customer");
			    mav.setViewName("SearchCustomer");
			    mav.addObject("customerList", null);
			    return mav;
			}
			else{
				//int resultValue = 0;
				LOGGER.info("customer ID RECEIVED :" +searchCustomerCriteria.getCustomerID());
				//resultValue = customerService.deleteCustomer(searchCustomerCriteria.getCustomerID());
				customerService.deleteCustomer(searchCustomerCriteria.getCustomerID());
				
				LOGGER.info("Customer deleted !! ");
			    List<Customer> customers = customerService.searchCustomers(searchCustomerCriteria);
			    mav.setViewName("SearchCustomer");
			    mav.addObject("customerList", customers);
			    return mav;
			}
		}
		catch(ServiceException e){
			LOGGER.info("ServiceException in delete customer :"+e.getMessage());
			
			//ExceptionMessage exceptionMessage = new ExceptionMessage();
			//exceptionMessage.setExceptionReason(e.getMessage());

			mav.setViewName("Exception");
			mav.addObject("exceptionReason", e.getMessage());
		    return mav;
		}
		catch(Exception e){
			LOGGER.info("Exception in delete customer :"+e.getMessage());
/*			ExceptionMessage exceptionMessage = new ExceptionMessage();
			exceptionMessage.setExceptionReason(e.getMessage());
*/
			mav.setViewName("Exception");
		    mav.addObject("exceptionReason", e.getMessage());
		    return mav;
			
		}
	}

	public PolicyService getPolicyService() {
		return policyService;
	}

	public void setPolicyService(PolicyService policyService) {
		this.policyService = policyService;
	}
	
}
