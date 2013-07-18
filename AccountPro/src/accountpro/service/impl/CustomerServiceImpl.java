package accountpro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accountpro.dao.CustomerDao;
import accountpro.domain.Customer;
import accountpro.domain.SearchCustomerCriteria;
import accountpro.exception.ServiceException;
import accountpro.service.CustomerService;
import accountpro.util.MessageLoader;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private MessageLoader messages;

	public MessageLoader getMessages() {
		return messages;
	}

	public void setMessages(MessageLoader messages) {
		this.messages = messages;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> searchCustomers(SearchCustomerCriteria searchCustomerCriteria) {
		List<Customer> customers = new ArrayList<Customer>();
		
		customers = customerDao.searchCustomer(searchCustomerCriteria);
		return customers;
	}
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerDao.getCustomers();
		return customers;
	}

	@Override
	/**
	 * @return id of customer added
	 */
	public int addCustomer(Customer customer) {
		int result = 0;
		//result is the ID of customer inserted
		result = customerDao.insertCustomer(customer);
		return result;
	}

	
	@Override
	public Customer openCustomer(String customerId) {
		Customer customer = new Customer();
		customer = customerDao.openCustomer(customerId);
		return customer;

	}

	@Override
	public int updateCustomer(Customer customer) {
		int result = 0;
		result = customerDao.updateCustomer(customer);
		return result;
	}

	@Override
	public void deleteCustomer(String customerId) throws ServiceException {
		int result = 0;
		try{
			result = customerDao.deleteCustomer(customerId);
		}
		catch(Exception e){
				throw new ServiceException(messages.getMessage("error.delete.customer"));
		}
	}


}
