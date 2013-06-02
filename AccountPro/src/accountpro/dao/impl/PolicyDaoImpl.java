package accountpro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import accountpro.dao.BaseDao;
import accountpro.dao.PolicyDao;
import accountpro.domain.Policy;
import accountpro.domain.SearchPolicyCriteria;

public class PolicyDaoImpl extends BaseDao implements PolicyDao{
	
	private DataSource dataSource;

	@Override
	public int insertPolicy(Policy policy) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("Insert into Policy ( CustomerID, PolicyType, CardNumber, PolicyNumber, PolicyAmount, StartDate, EndDate) ");
		sql.append("VALUES (?,?,?,?,?,?,?)");
		
		List<Object> args = new ArrayList<Object>();
		
		args.add(policy.getCustomerId());
		args.add(policy.getPolicyType());
		args.add(policy.getCardNumber());
		args.add(policy.getPolicyNumber());
		args.add(policy.getPolicyAmount());
		args.add(policy.getStartDate());
		args.add(policy.getEndDate());
		
		int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("result insertPolicy "+result);
		return result;

	}

	@Override
	public List<Policy> getPolicies() {
		
		List<Policy> policies = new ArrayList<Policy>();
		List<Object> args = new ArrayList<Object>();
		String sql = "select * FROM Policy P INNER JOIN Customer C ON P.CustomerID=C.P_Id";
		SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql,args.toArray());
		
		while(rss.next()){
			Policy pol = new Policy();
			pol.setPolicyID(rss.getInt("Policy_Id"));
			pol.setCustomerId(rss.getInt("CustomerID"));
			pol.setCustomerName(rss.getString("FirstName")+" "+rss.getString("LastName"));
			pol.setPolicyType(rss.getString("PolicyType"));
			pol.setCardNumber(rss.getInt("CardNumber"));
			pol.setPolicyNumber(rss.getInt("PolicyNumber"));
			pol.setPolicyAmount(rss.getDouble("PolicyAmount"));
			pol.setStartDate(rss.getDate("StartDate"));
			pol.setEndDate(rss.getDate("EndDate"));
			policies.add(pol);
		}
		
	return policies;

	}

	@Override
	public List<Policy> searchPolicies(SearchPolicyCriteria searchPolicyCriteria) {
		List<Policy> policies = new ArrayList<Policy>();
		List<Object> args = new ArrayList<Object>();
		
		StringBuffer sql = new StringBuffer("SELECT * FROM Policy P INNER JOIN Customer C ON P.CustomerID=C.P_Id WHERE Policy_Id > 0 ");
		
		if(StringUtils.isNotBlank(searchPolicyCriteria.getPolicyType())){
			sql.append(" and P.PolicyType =  ? ");
			args.add(searchPolicyCriteria.getPolicyType());
		}
		if(StringUtils.isNotBlank(searchPolicyCriteria.getFirstName())){
			sql.append(" and C.FirstName =  ? ");
			args.add(searchPolicyCriteria.getFirstName());
		}
		if(StringUtils.isNotBlank(searchPolicyCriteria.getLastName())){
			sql.append(" and C.LastName =  ? ");
			args.add(searchPolicyCriteria.getLastName());
		}
		
		SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql.toString(),args.toArray());
		
		while(rss.next()){
			Policy pol = new Policy();
			pol.setPolicyID(rss.getInt("Policy_Id"));
			pol.setCustomerName(rss.getString("FirstName")+" "+rss.getString("LastName"));
			pol.setCustomerId(rss.getInt("CustomerID"));
			pol.setCardNumber(rss.getInt("CardNumber"));
			pol.setPolicyType(rss.getString("PolicyType"));
			pol.setPolicyNumber(rss.getInt("PolicyNumber"));
			pol.setPolicyAmount(rss.getDouble("PolicyAmount"));
			pol.setStartDate(rss.getDate("StartDate"));
			pol.setEndDate(rss.getDate("EndDate"));
			policies.add(pol);
		}
		
		return policies;
	}

	@Override
	public Policy openPolicy(String policyId) {
		Policy policy = new Policy();
		List<Object> args = new ArrayList<Object>();
		String sql = "select * from Policy where Policy_Id = ?";
		args.add(policyId);
		SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql,args.toArray());
		while(rss.next()){
			policy.setPolicyID(rss.getInt("Policy_Id"));
			policy.setCustomerId(rss.getInt("CustomerID"));
			policy.setPolicyType(rss.getString("PolicyType"));
			policy.setCardNumber(rss.getInt("CardNumber"));
			policy.setPolicyNumber(rss.getInt("PolicyNumber"));
			policy.setPolicyAmount(rss.getDouble("PolicyAmount"));
			policy.setStartDate(rss.getDate("StartDate"));
			policy.setEndDate(rss.getDate("EndDate"));
			break;
		}
		return policy;
	}

	@Override
	public int deletePolicy(String policyId) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from Policy where Policy_Id = ? ");
		
		List<Object> args = new ArrayList<Object>();
		args.add(policyId);
		
		int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("result delete policy "+result);
		return result;
	}

	@Override
	public List<Policy> getCustomerPolicies(String customerId) {
		List<Policy> policies = new ArrayList<Policy>();
		List<Object> args = new ArrayList<Object>();
		
		String sql = "select * from Policy where customerID = ? ";
		args.add(customerId);
		
		SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql,args.toArray());
		
		while(rss.next()){
			Policy pol = new Policy();
			pol.setPolicyID(rss.getInt("Policy_Id"));
			pol.setCustomerId(rss.getInt("CustomerID"));
			pol.setPolicyType(rss.getString("PolicyType"));
			pol.setCardNumber(rss.getInt("CardNumber"));
			pol.setPolicyNumber(rss.getInt("PolicyNumber"));
			pol.setPolicyAmount(rss.getDouble("PolicyAmount"));
			pol.setStartDate(rss.getDate("StartDate"));
			pol.setEndDate(rss.getDate("EndDate"));
			policies.add(pol);
		}
		
		return policies;
	}

	@Override
	public void updatePolicy(Policy policy) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("Update Policy set PolicyAmount =  ? , CardNumber = ? , PolicyNumber = ?  , StartDate = ? , EndDate =  ?  where Policy_Id = ? ");
		
		List<Object> args = new ArrayList<Object>();
		args.add(policy.getPolicyAmount());
		args.add(policy.getCardNumber());
		args.add(policy.getPolicyNumber());
		args.add(policy.getStartDate());
		args.add(policy.getEndDate());
		args.add(policy.getPolicyID());
		
		int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("result updatePolicy "+result);
	
	} 
	

}
