package accountpro.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Login;
import accountpro.domain.MainMenu;
import accountpro.service.LoginService;

@Controller
public class LoginController extends BaseController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private LoginService loginService;
	
	private boolean isValidUser = true; 
	
	@RequestMapping(value="/doLogin.htm", method= RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("login") @Valid Login login,BindingResult result, SessionStatus status)
	{
		LOGGER.info("started logging ..LoginController");
		
		if(result.hasErrors()){
			return new ModelAndView("Login", "login", login);
		}
		else{
			
			isValidUser = true;
			isValidUser = loginService.validateLogin(login.getUserid(), login.getPassword());
			
			
			if(isValidUser){
				super.setUserValidated(true);
				LOGGER.info("value of usr validated in BaseController : "+super.isUserValidated());
				LOGGER.info("Valid user...hurray !! " +login.getUserid()+" "+login.getPassword());
				LOGGER.info("view name :"+getViewName());
				
				MainMenu mainMenu = new MainMenu();
				return new ModelAndView(getViewName(), "mainMenu", mainMenu);
			}
			else{
				LOGGER.info("InValid user...urgghh !!");
				//Errors errors = new Errors();
				//result.rejectValue("exception.credential.Failure", "Invalid User Credentials");
				//result.addAllErrors(errors);
				//return new ModelAndView("Login", "login", login);
				return new ModelAndView("Error", "login", login);
			}
			
		}
	}

/*	@RequestMapping(value="/loginfailed.htm", method = RequestMethod.GET)
	public ModelAndView loginerror() {
		Login loginBean = new Login();
		return new ModelAndView("Error", "login", loginBean);
 
	}
*/	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 		model.addAttribute("error", "true");
		return "login";
 
	}
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout() {
	   	Login loginBean = new Login();
        return new ModelAndView("login", "login", loginBean);
	}
	
    @RequestMapping("/login.htm")
    public ModelAndView showForm() {
    	Login loginBean = new Login();
        return new ModelAndView("login", "login", loginBean);
    }

    @RequestMapping("/support.htm")
    public ModelAndView showSupportForm() {
    	
        return new ModelAndView("ContactSupport","support",null);
    }

 	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
    
}
