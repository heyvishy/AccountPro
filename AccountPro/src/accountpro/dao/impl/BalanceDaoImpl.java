package accountpro.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import accountpro.dao.BalanceDao;
import accountpro.dao.BaseDao;
import accountpro.domain.BalanceDue;

@Repository("balanceDao")
public class BalanceDaoImpl extends BaseDao implements BalanceDao {
	

	@Autowired
	public BalanceDaoImpl(DataSource dataSource) {
		super(dataSource);
	}
	
	private static final Logger logger = Logger.getLogger(BalanceDaoImpl.class.getName());


	 
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

	
	@Override
	public BalanceDue getBalance(String policyID) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from  Policy P INNER JOIN Customer C on P.CustomerID = C.P_Id where P.Policy_Id= "+Integer.parseInt(policyID));
		
		SqlRowSet rss  = this.getJdbcTemplate().queryForRowSet(sql.toString());
		BalanceDue balanceDue =  new BalanceDue();
		
		while(rss.next()){
			balanceDue.setCustomerId(rss.getInt("CustomerID"));
			balanceDue.setPolicyId(rss.getInt("Policy_Id"));
			balanceDue.setLastUpdated(new Date());
			balanceDue.setPaymentDue(rss.getDouble("PolicyAmount"));
			balanceDue.setCustomerName(rss.getString("FirstName")+" "+rss.getString("LastName"));
			break;
		}
		return balanceDue;
	}


}
