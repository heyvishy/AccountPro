package accountpro.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.BalanceDue;
import accountpro.service.BalanceService;

@Controller
public class BalanceController {

	@Autowired
	private BalanceService balanceService;
	
	private static final Logger logger = Logger.getLogger(BalanceController.class.getName());

	@RequestMapping(value="/balance.htm")	
	public ModelAndView geBalances(){
	    ModelAndView mav = new ModelAndView();
	    List<BalanceDue> balanceDues  = balanceService.getBalances();
	    
	    mav.addObject("balanceDues",balanceDues);
	    mav.setViewName("PolicyBalances");
	    return mav;
	}

	public BalanceService getBalanceService() {
		return balanceService;
	}

	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}

	public static Logger getLogger() {
		return logger;
	}

}
