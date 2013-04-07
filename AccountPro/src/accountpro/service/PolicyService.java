package accountpro.service;

import java.util.List;

import accountpro.domain.Policy;

public interface PolicyService {

	public int insertPolicy(Policy policy);
	public List<Policy> getPolicies();
	public List<Policy> searchPolicies(Policy policy);

}
