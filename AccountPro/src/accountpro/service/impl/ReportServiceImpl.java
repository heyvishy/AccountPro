package accountpro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accountpro.dao.CustomerDao;
import accountpro.domain.Customer;
import accountpro.service.ReportService;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CustomerDao customerDao;
	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getReport() {
		
		List<Customer> customers =  customerDao.getCustomers();
		return customers;
		
	}

}
