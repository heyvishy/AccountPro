package accountpro.dao;

import java.util.List;

import accountpro.domain.BalanceDue;
import accountpro.domain.Customer;

public interface BalanceDao{
	
	public List<BalanceDue> getBalances();
	public BalanceDue getBalance(String policyID);
}