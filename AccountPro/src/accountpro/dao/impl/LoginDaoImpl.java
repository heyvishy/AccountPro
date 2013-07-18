package accountpro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import accountpro.dao.BaseDao;
import accountpro.dao.LoginDao;

@Repository("loginDao")
public class LoginDaoImpl extends BaseDao implements LoginDao{
	
	@Autowired
	public LoginDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public boolean validateLogin(String userid, String password) {
		
		List<Object> args = new ArrayList<Object>();

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) from Users where userid = ? and password = ?");
		args.add(userid);
		args.add(password);
		
		int count =  this.getJdbcTemplate().queryForInt(sql.toString(), args.toArray());
		if(count>0)
			return true;
		else 
			return false;
	}

}
