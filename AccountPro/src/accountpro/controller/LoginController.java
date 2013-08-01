package accountpro.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import accountpro.domain.Login;
import accountpro.service.LoginService;

@Controller
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private LoginService loginService;
	
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
    	
        //return new ModelAndView("ContactSupport","support",null);
    	return new ModelAndView("ContactSupport");
    }

 	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
    
}
