package accountpro.service.impl;

import java.util.ArrayList;
import java.util.List;

import accountpro.dao.CustomerDao;
import accountpro.domain.Customer;
import accountpro.domain.SearchCustomerCriteria;
import accountpro.exception.ServiceException;
import accountpro.service.CustomerService;
import accountpro.util.MessageLoader;

public class CustomerServiceImpl implements CustomerService{

	private CustomerDao customerDao;
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
		
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		
		customer1.setFirstName("Ram");customer1.setLastName("pandey");
		customer1.setPhone("999999999");customer1.setPaymentDueDate("01/01/2013");
		customer1.setAmountDue("5000");customer1.setActive("Yes");

		customer2.setFirstName("Sita");customer2.setLastName("pandey");
		customer2.setPhone("777777777");customer2.setPaymentDueDate("02/02/2013");
		customer2.setAmountDue("1000");customer2.setActive("No");

		customers.add(customer1);
		customers.add(customer2);
		
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
