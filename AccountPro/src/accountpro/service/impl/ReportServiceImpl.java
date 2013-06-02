package accountpro.service.impl;

import java.util.List;

import accountpro.dao.CustomerDao;
import accountpro.domain.Customer;
import accountpro.service.ReportService;

public class ReportServiceImpl implements ReportService {

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
