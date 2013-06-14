package accountpro.service.impl;

import java.util.List;

import accountpro.dao.BalanceDao;
import accountpro.domain.BalanceDue;
import accountpro.service.BalanceService;

public class BalanceServiceImpl implements BalanceService {

	private BalanceDao balanceDao;
	
	@Override
	public List getBalances() {
		return balanceDao.getBalances();
	}

	@Override
	public BalanceDue getBalance(String policyID) {
		return balanceDao.getBalance(policyID);
	}

	public BalanceDao getBalanceDao() {
		return balanceDao;
	}

	public void setBalanceDao(BalanceDao balanceDao) {
		this.balanceDao = balanceDao;
	}



}
