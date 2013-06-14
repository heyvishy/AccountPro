package accountpro.service.impl;

import accountpro.dao.PaymentDao;
import accountpro.domain.Payment;
import accountpro.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	PaymentDao paymentDao;
	
	@Override
	public int makePayment(Payment payment) {
		
		return paymentDao.makePayment(payment);
	}

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
}
