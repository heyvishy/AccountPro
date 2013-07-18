package accountpro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accountpro.dao.PaymentDao;
import accountpro.domain.Payment;
import accountpro.service.PaymentService;

@Service("paymentService")
public class PaymentServiceImpl implements PaymentService{

	@Autowired
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
