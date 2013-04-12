package accountpro.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Customer;
import accountpro.domain.Policy;
import accountpro.domain.SearchCustomerCriteria;
import accountpro.domain.SearchPolicyCriteria;
import accountpro.exception.ServiceException;
import accountpro.service.CustomerService;
import accountpro.service.PolicyService;

@Controller
public class PolicyController {

	private static final Logger LOGGER = Logger.getLogger(PolicyController.class.getName());
	
	//public static List<String> customerList = new ArrayList<String>(Arrays.asList("Vishal", "Abha", "Dad"));
	
	private PolicyService policyService;
	private CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public PolicyService getPolicyService() {
		return policyService;
	}

	public void setPolicyService(PolicyService policyService) {
		this.policyService = policyService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
 	}
	
	
	@RequestMapping(value="/pickerDate.htm")
	public ModelAndView showPickerCustomerForm(Model model) {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("PickerDate");
	    return mav;
	}

	@RequestMapping(value="/addPolicyForCustomer.htm")	
	public ModelAndView addPolicyForCustomer(@RequestParam("id") String customerId){
		Policy policy = new Policy();
		
		LOGGER.info("addPolicy for customerID "+customerId);
	    ModelAndView mav = new ModelAndView();
	    policy.setCustomerId(Integer.parseInt(customerId));
	    
	    Customer customer = customerService.openCustomer(customerId);
	    String customerName = customer.getFirstName().concat(" ").concat(customer.getLastName());
	    
	    mav.setViewName("AddPolicy");
	    mav.addObject("customerName",customerName);
	    mav.addObject("policy", policy);
	    //mav.addObject("customerList", customerList);
	    return mav;
	}

	@RequestMapping(value="/addPolicy.htm")	
	public ModelAndView addPolicyForCustomer(){
		Policy policy = new Policy();
	    ModelAndView mav = new ModelAndView();
	    List<Customer> customerList = customerService.getCustomers();
	    mav.setViewName("AddPolicy");
	    mav.addObject("policy", policy);
	    mav.addObject("customerList", customerList);
	    return mav;
	}

/*	@RequestMapping(value="/deletePolicy.htm",method=RequestMethod.POST)
	public ModelAndView deletePolicy(@ModelAttribute("searchPolicyCriteria")  SearchPolicyCriteria searchPolicyCriteria,BindingResult result, SessionStatus status) {
*/	
	@RequestMapping(value="/searchPolicy.htm",method=RequestMethod.POST)
	public ModelAndView searchPolicyForm(@ModelAttribute("searchPolicyCriteria")  SearchPolicyCriteria searchPolicyCriteria,BindingResult result, SessionStatus status){
		LOGGER.info("inside searchPolicyForm");
		LOGGER.info("values searchPolicyCriteria "+searchPolicyCriteria.getCustomerName()+" "+searchPolicyCriteria.getPolicyType());
		List<Policy> policies = policyService.searchPolicies(searchPolicyCriteria);
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("SearchPolicy");
	    mav.addObject("SearchPolicyCriteria", searchPolicyCriteria);
	    mav.addObject("policies", policies);
	    return mav;
	}

	@RequestMapping(value="/searchPolicy.htm")
	public ModelAndView showAllPolicyForm(ModelMap model){
		SearchPolicyCriteria searchPolicyCriteria = new SearchPolicyCriteria();
		List<Policy> policies = policyService.getPolicies();
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("SearchPolicy");
	    mav.addObject("SearchPolicyCriteria", searchPolicyCriteria);
	    mav.addObject("policies", policies);
	    return mav;
	}

	@RequestMapping(value="/openPolicy.htm")
	public ModelAndView openPolicy(@RequestParam("id") String id)
	{
		ModelAndView mav = new ModelAndView();
		LOGGER.info("Policy id: "+id);
		Policy policy = policyService.openPolicy(id);
		
	    Customer customer = customerService.openCustomer(Integer.toString(policy.getCustomerId()));
	    String customerName = customer.getFirstName().concat(" ").concat(customer.getLastName());
	    
	    mav.addObject("customerName",customerName);
		mav.setViewName("AddPolicy");
		mav.addObject("policy", policy);
		return mav;
	}

	@RequestMapping(value="/deletePolicy.htm",method=RequestMethod.POST)
	public ModelAndView deletePolicy(@ModelAttribute("searchPolicyCriteria")  SearchPolicyCriteria searchPolicyCriteria,BindingResult result, SessionStatus status) {
	
		ModelAndView mav = new ModelAndView();

		try{
			if(result.hasErrors() ){
				LOGGER.info("Error occurred in delete customer");
			    mav.setViewName("SearchPolicy");
			    mav.addObject("policies", null);
			    return mav;
			}
			else{
				int resultValue = 0;
				resultValue = policyService.deletePolicy(Integer.toString(searchPolicyCriteria.getPolicyID()));
				LOGGER.info("Policy deleted !! \n resultValue ="+resultValue);
				List<Policy> policies = policyService.getPolicies();
				
			    mav.setViewName("SearchPolicy");
			    mav.addObject("SearchPolicyCriteria", searchPolicyCriteria);
			    mav.addObject("policies", policies);
			    return mav;
			}
		}
		
		catch(ServiceException e){
			LOGGER.info("Exception in delete customer is :"+e.getMessage());
		    mav.setViewName("SearchPolicy");
		    mav.addObject("policies", null);
		    return mav;
		}
	}

	@RequestMapping(value="/addPolicy.htm",method=RequestMethod.POST)	
	public ModelAndView addPolicy(@ModelAttribute("policy") @Valid Policy policy,BindingResult result,SessionStatus status){
		LOGGER.info("addPolicy (POST) for customerID " +policy.getCustomerId());
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			LOGGER.info("Error happend in loading AddPolicy");
			 //Policy policyObject = new Policy();
			 //mav.addObject("policy", policyObject);
			 mav.setViewName("AddPolicy");
			 return mav;
		} else{	
			int resultValue = 0;
			resultValue = policyService.insertPolicy(policy);
			LOGGER.info(" resultValue being set model = "+resultValue);
			if(resultValue > 0)
				LOGGER.info("Policy Added !! ");
			
			 policy.setPolicyID(policy.getCustomerId());
			 
		     if(StringUtils.isNotBlank(Integer.toString(policy.getCustomerId()))){
				 Customer customer = customerService.openCustomer(Integer.toString(policy.getCustomerId()));
			     String customerName = customer.getFirstName().concat(" ").concat(customer.getLastName());
			     mav.addObject("customerName",customerName);
		     }

		     mav.addObject("policy", policy);
			 mav.setViewName("AddPolicy");
			 return mav;
		}

	}


}
