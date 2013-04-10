package accountpro.service;

import java.util.List;

import accountpro.domain.Policy;
import accountpro.domain.SearchPolicyCriteria;
import accountpro.exception.ServiceException;

public interface PolicyService {

	public int insertPolicy(Policy policy);
	public List<Policy> getPolicies();
	public List<Policy> searchPolicies(SearchPolicyCriteria searchPolicyCriteria);
	public Policy openPolicy(String policyId);
	public int deletePolicy(String policyId) throws ServiceException;
	public List<Policy> getCustomerPolicies(String customerId) throws ServiceException;
}
