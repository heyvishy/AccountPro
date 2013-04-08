package accountpro.service;

import java.util.List;

import accountpro.domain.Customer;
import accountpro.domain.SearchCustomerCriteria;

public interface CustomerService {

	public List<Customer> getCustomers ();
	public List<Customer> searchCustomers(SearchCustomerCriteria searchCustomerCriteria);
	public int addCustomer(Customer customer);
	public int updateCustomer(Customer customer);	
	public Customer openCustomer(String customerId);
	public int deleteCustomer(String customerId);
}
