package accountpro.dao;

import java.util.List;

import accountpro.domain.Customer;
import accountpro.domain.SearchCustomerCriteria;

public interface CustomerDao {
		
	public int insertCustomer(Customer customer);
	public int updateCustomer(Customer customer);
	
	public String getCustomerName();
	
	public List<Customer> searchCustomer(SearchCustomerCriteria searchCustomerCriteria);
	
	public Customer openCustomer(String customerId);
	
	public int deleteCustomer(String customerId);
		
}
