package accountpro.service.impl;

import accountpro.dao.LoginDao;
import accountpro.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;
	
	public boolean validateLogin(String userid, String password) {
		
		return loginDao.validateLogin(userid, password);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


}
