package accountpro.controller;

import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.MainMenu;

@Controller
public class MainMenuController extends BaseController{

	private static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());
	
	@RequestMapping(value="/mainMenu.htm", method= RequestMethod.POST)
	public String processMenuSubmit(@ModelAttribute("mainMenu") MainMenu mainMenu,BindingResult result, SessionStatus status)
	{
		LOGGER.info("started MainMenuController logging with choice "+mainMenu.getChoice());
		if(StringUtils.equals(mainMenu.getChoice(),"searchCustomer"))
			return getViewName();
		else if(StringUtils.equals(mainMenu.getChoice(),"addCustomer"))
			return "redirect:/addCustomer.htm";
		else if(StringUtils.equals(mainMenu.getChoice(),"addPolicy"))
			return "redirect:/addPolicy.htm";
		else
			return "MainMenu";
	}

	@RequestMapping(value="/mainMenu.htm")
	public ModelAndView showForm(){
		MainMenu mainMenu = new MainMenu();
		return new ModelAndView("MainMenu","mainMenu",mainMenu);
	}

}
