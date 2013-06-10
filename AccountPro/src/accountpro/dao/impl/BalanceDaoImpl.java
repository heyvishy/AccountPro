package accountpro.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import accountpro.dao.BalanceDao;
import accountpro.dao.BaseDao;
import accountpro.domain.BalanceDue;

public class BalanceDaoImpl extends BaseDao implements BalanceDao {

	private static final Logger logger = Logger.getLogger(BalanceDaoImpl.class.getName());
   // private DataSource dataSource;

	//Eventually this query will change , to get data from Balance Table
	@Override
	public List<BalanceDue> getBalances() {

		StringBuffer sql = new StringBuffer();
		sql.append("select * from  Policy P INNER JOIN Customer C on P.CustomerID = C.P_Id");
		SqlRowSet rss  = this.getJdbcTemplate().queryForRowSet(sql.toString());
		
		List<BalanceDue> balanceDues = new ArrayList<BalanceDue>();
		while(rss.next()){
			
			BalanceDue balanceDue =  new BalanceDue();
			balanceDue.setCustomerId(rss.getInt("CustomerID"));
			balanceDue.setPolicyId(rss.getInt("Policy_Id"));
			balanceDue.setLastUpdated(new Date());
			balanceDue.setPaymentDue(rss.getDouble("PolicyAmount"));
			balanceDue.setCustomerName(rss.getString("FirstName")+" "+rss.getString("LastName"));
			
			balanceDues.add(balanceDue);
		}
		
		System.out.println("size = "+balanceDues.size());
		return balanceDues;
	}

}
