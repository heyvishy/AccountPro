package accountpro.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import accountpro.dao.BaseDao;
import accountpro.dao.CustomerDao;
import accountpro.domain.Customer;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
	
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());
    private DataSource dataSource;

	public int insertCustomer(Customer customer){
		StringBuffer sql = new StringBuffer();
		
		sql.append("Insert into Customer ( LastName, FirstName , Address , City, ZipCode)");
		sql.append("VALUES (?,?,?,?,?)");
		
		List<Object> args = new ArrayList<Object>();
		args.add(customer.getLastName());
		args.add(customer.getFirstName());
		args.add(customer.getAddress());
		args.add(customer.getCity());
		args.add(customer.getZipCode());
		
		int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("result "+result);
		return result;
		
	}
	
	public String getCustomerName()
	{
			String name="";
			List<Object> args = new ArrayList<Object>();
			String sql = "select * from Customer";
			SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql,args.toArray());
			
			while(rss.next()){
				name = rss.getString(2);
				break;
			}
			
		return name;
	}

	
	public List<Customer> searchCustomer(Customer customer) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		
		sql.append("select * from Customer ");

		if(StringUtils.isBlank(customer.getCity()))
			sql.append("WHERE City IS NOT NULL ");
		else
			sql.append("WHERE City = ? ");
		
		if(StringUtils.isNotBlank(customer.getFirstName()))
			sql.append(" and FirstName = ? ");
		if(StringUtils.isNotBlank(customer.getLastName()))
			sql.append(" and LastName = ? ");
		
		
		if(StringUtils.isNotBlank(customer.getCity()))
			args.add(customer.getCity());
		if(StringUtils.isNotBlank(customer.getFirstName()))
			args.add(customer.getFirstName());
		if(StringUtils.isNotBlank(customer.getLastName()))
			args.add(customer.getLastName());

		
		SqlRowSet rss = this.getJdbcTemplate().queryForRowSet(sql.toString(), args.toArray());
		List<Customer> customers = new ArrayList<Customer>();
		while(rss.next()){
			Customer cust = new Customer();
			cust.setCustomerID(Integer.toString(rss.getInt("P_Id")));
			cust.setFirstName(rss.getString("FirstName"));
			cust.setLastName(rss.getString("LastName"));
			cust.setAddress(rss.getString("City"));
			cust.setCity(rss.getString("Address"));
			customers.add(cust);
		}
		return customers;
		
	}

	@Override
	public Customer openCustomer(String customerId) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		
		sql.append("select * from Customer where P_id = ?");
		args.add(customerId);
		SqlRowSet rss  = this.getJdbcTemplate().queryForRowSet(sql.toString(), args.toArray());
		
		Customer customer =  new Customer();
		while(rss.next()){
			customer.setFirstName(rss.getString("FirstName"));
			customer.setLastName(rss.getString("LastName"));
			//customer.setCity(rss.getString("Add));
			//customer.setPhone(rss.getString(arg0));
			customer.setAddress(rss.getString("Address"));
			customer.setCustomerID(customerId);
			customer.setCity(rss.getString("City"));
			//customer.setActive(active);
			customer.setZipCode(rss.getString("ZipCode"));
			//customer.setAmountDue(amountDue);
			break;
		}
		
		return customer;
	}

	@Override
	public int updateCustomer(Customer customer) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("Update Customer set LastName =  ? , FirstName= ?  , Address= ? 	 , City =  ?  , ZipCode =  ?  where P_Id = ? ");
		///sql.append("VALUES (?,?,?,?,?)");
		
		List<Object> args = new ArrayList<Object>();
		args.add(customer.getLastName());
		args.add(customer.getFirstName());
		args.add(customer.getAddress());
		args.add(customer.getCity());
		args.add(customer.getZipCode());
		args.add(customer.getCustomerID());
		
		int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("result updateCustomer "+result);
		return result;
	}

	@Override
	public int deleteCustomer(String customerId) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from Customer where P_Id = ? ");
		
		List<Object> args = new ArrayList<Object>();
		args.add(customerId);
		
		int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("result delete customer "+result);
		return result;
	}	


}
