package accountpro.dao;

import java.util.List;

import accountpro.domain.Customer;

public interface CustomerDao {
		
	public int insertCustomer(Customer customer);
	public String getCustomerName();
	
	public List<Customer> searchCustomer(Customer customer);
		
}
