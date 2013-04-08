package accountpro.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Policy;
import accountpro.service.PolicyService;

@Controller
public class PolicyController {

	private static final Logger LOGGER = Logger.getLogger(PolicyController.class.getName());
	
	public static List<String> customerList = new ArrayList<String>(Arrays.asList("Vishal", "Abha", "Dad"));
	
	private PolicyService policyService;
	
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
	
	@RequestMapping(value="/addPolicy.htm")	
	public ModelAndView showForm(ModelMap model){
		Policy policy = new Policy();
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("AddPolicy");
	    mav.addObject("policy", policy);
	    mav.addObject("customerList", customerList);
	    return mav;
	}
	
	@RequestMapping(value="/searchPolicy.htm")
	public ModelAndView showListPolicyForm(ModelMap model){
		Policy policy = new Policy();
		List<Policy> policies = policyService.getPolicies();
		ModelAndView mav = new ModelAndView();
	    mav.setViewName("SearchPolicy");
	    mav.addObject("policy", policy);
	    mav.addObject("policies", policies);
	    return mav;
	}

	@RequestMapping(value="/addPolicy.htm",method=RequestMethod.POST)	
	public ModelAndView addPolicy(@ModelAttribute("policy") @Valid Policy policy,BindingResult result,SessionStatus status){
		LOGGER.info("policy is here");
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
						
			 mav.addObject("policy", policy);
			 mav.addObject("resultValue", resultValue);
			 mav.setViewName("AddPolicy");
			 return mav;
		}

	}

}
