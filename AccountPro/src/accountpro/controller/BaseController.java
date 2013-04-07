package accountpro.controller;

import org.springframework.stereotype.Controller;

@Controller
public abstract class BaseController {
	
	private static boolean isUserValidated=false ;
	
	private String viewName;

	public String getViewName() {
		return "redirect:"+viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isUserValidated() {
		return isUserValidated;
	}


	public void setUserValidated(boolean isUserValidated) {
		this.isUserValidated = isUserValidated;
	}
	
	
}
