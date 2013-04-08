package accountpro.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import accountpro.dao.BaseDao;
import accountpro.dao.PolicyDao;
import accountpro.domain.Policy;

public class PolicyDaoImpl extends BaseDao implements PolicyDao{
	
	private DataSource dataSource;

	@Override
	public int insertPolicy(Policy policy) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("Insert into Policy ( CustomerID, PolicyType , PolicyNumber , PolicyAmount , StartDate , EndDate) ");
		sql.append("VALUES (?,?,?,?,?,?)");
		
		List<Object> args = new ArrayList<Object>();
		
		args.add(policy.getCustomerId());
		args.add(policy.getPolicyType());
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
		String sql = "select * from Policy";
		SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql,args.toArray());
		
		while(rss.next()){
			Policy pol = new Policy();
			pol.setPolicyID(rss.getInt("Policy_Id"));
			pol.setCustomerId(rss.getInt("CustomerID"));
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
	public List<Policy> searchPolicies(Policy policy) {
		// TODO Auto-generated method stub
		return null;
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
	

}
