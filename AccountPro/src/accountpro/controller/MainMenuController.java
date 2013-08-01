package accountpro.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainMenuController {

	private static final Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

	@RequestMapping(value="/mainMenu.htm")
	public ModelAndView showForm(){
		return new ModelAndView("MainMenu");
	}

}