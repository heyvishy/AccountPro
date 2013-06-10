package accountpro.dao;

import java.util.List;

import accountpro.domain.BalanceDue;

public interface BalanceDao{
	
	public List<BalanceDue> getBalances();
}