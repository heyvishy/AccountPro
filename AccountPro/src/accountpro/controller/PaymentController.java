package accountpro.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.BalanceDue;
import accountpro.domain.Customer;
import accountpro.domain.Payment;
import accountpro.domain.Policy;
import accountpro.service.BalanceService;
import accountpro.service.PaymentService;

@Controller
public class PaymentController {

	public BalanceService getBalanceService() {
		return balanceService;
	}


	public void setBalanceService(BalanceService balanceService) {
		this.balanceService = balanceService;
	}

	private PaymentService paymentService;
	private BalanceService balanceService;
	
	private static final Logger logger = Logger.getLogger(PaymentController.class.getName());

	@RequestMapping(value="/paymentpopup.htm",method=RequestMethod.GET)
	public ModelAndView showPaymentPopUpForm(@RequestParam("policyID") String policyID,Model model) {
		Payment payment = new Payment();
	    ModelAndView mav = new ModelAndView();
	    
	    logger.info("policyID :"+policyID);
	    
	    BalanceDue balanceDue = balanceService.getBalance(policyID);
	    
	    payment.setPolicyId(balanceDue.getPolicyId());
	    //payment.setPolicyNumber(balanceDue.get);
	    payment.setPaymentAmount(balanceDue.getPaymentDue());
	    
	    mav.setViewName("PaymentPopup");
	    mav.addObject("payment", payment);
	    return mav;
	}

	
	@RequestMapping(value="/paymentpopup.htm",method=RequestMethod.POST)	
	public ModelAndView makePayment(@ModelAttribute("payment") @Valid Payment payment,BindingResult result,SessionStatus status){
		logger.info("payment for policyID: " +payment.getPolicyId());
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			logger.info("Error happend in making payment for policy "+payment.getPolicyId());
			 mav.setViewName("PaymentPopup");
			 return mav;
		} else{	
			int resultValue = 0;
			resultValue = paymentService.makePayment(payment);
			logger.info(" resultValue being set model = "+resultValue);
			if(resultValue > 0)
				logger.info("payment done !! ");
			
		     mav.addObject("payment", payment);
			 mav.setViewName("PaymentPopup");
			 return mav;
		}

	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public static Logger getLogger() {
		return logger;
	}

}

