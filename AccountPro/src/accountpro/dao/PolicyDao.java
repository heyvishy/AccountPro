package accountpro.dao;

import java.util.List;

import accountpro.domain.Policy;

public interface PolicyDao {
	
	public int insertPolicy(Policy policy);
	public List<Policy> getPolicies();
	public List<Policy> searchPolicies(Policy policy);
	public Policy openPolicy(String policyId);
	public int deletePolicy(String policyId);
	public List<Policy> getCustomerPolicies(String customerId);
}
