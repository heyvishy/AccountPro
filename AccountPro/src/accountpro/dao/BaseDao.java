package accountpro.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDao extends JdbcDaoSupport {

	private DataSource dataSource;

	@Autowired
	public BaseDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

}
