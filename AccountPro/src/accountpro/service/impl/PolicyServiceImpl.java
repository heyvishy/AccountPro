package accountpro.service.impl;

import java.util.List;

import accountpro.dao.PolicyDao;
import accountpro.domain.Policy;
import accountpro.domain.SearchPolicyCriteria;
import accountpro.exception.ServiceException;
import accountpro.service.PolicyService;

public class PolicyServiceImpl implements PolicyService {

	private PolicyDao policyDao;
	
	@Override
	public int insertPolicy(Policy policy) {
		int result = 0;
		result = policyDao.insertPolicy(policy);
		return result;
	}

	@Override
	public List<Policy> getPolicies() {
		List<Policy> policies = policyDao.getPolicies();
		return policies;
	}

	@Override
	public List<Policy> searchPolicies(SearchPolicyCriteria searchPolicyCriteria) {
		List<Policy> policies = policyDao.searchPolicies(searchPolicyCriteria);
		return policies;
	}

	public PolicyDao getPolicyDao() {
		return policyDao;
	}

	public void setPolicyDao(PolicyDao policyDao) {
		this.policyDao = policyDao;
	}

	@Override
	public Policy openPolicy(String policyId) {
		Policy policy = null;
		policy = policyDao.openPolicy(policyId);
	    return policy;
	}

	@Override
	public int deletePolicy(String policyId) {
		int result = 0;
		result = policyDao.deletePolicy(policyId);
	    return result;
	}

	@Override
	public List<Policy> getCustomerPolicies(String customerId)
			throws ServiceException {
		
		List<Policy> policies = policyDao.getCustomerPolicies(customerId);
		return policies;

	}

}
