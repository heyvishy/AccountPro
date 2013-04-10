package accountpro.dao;

import java.util.List;

import accountpro.domain.Policy;
import accountpro.domain.SearchPolicyCriteria;

public interface PolicyDao {
	
	public int insertPolicy(Policy policy);
	public List<Policy> getPolicies();
	public List<Policy> searchPolicies(SearchPolicyCriteria searchPolicyCriteria);
	public Policy openPolicy(String policyId);
	public int deletePolicy(String policyId);
	public List<Policy> getCustomerPolicies(String customerId);
}
