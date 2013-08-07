package accountpro.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import accountpro.domain.Customer;
import accountpro.domain.SearchCustomerCriteria;
import accountpro.exception.ServiceException;

public interface CustomerService {

	public List<Customer> getCustomers ();
	
	@Secured("ROLE_TELLER")
	public List<Customer> searchCustomers(SearchCustomerCriteria searchCustomerCriteria);
	
	public int addCustomer(Customer customer);
	public int updateCustomer(Customer customer);	
	public Customer openCustomer(String customerId);
	public void deleteCustomer(String customerId) throws ServiceException;
}
