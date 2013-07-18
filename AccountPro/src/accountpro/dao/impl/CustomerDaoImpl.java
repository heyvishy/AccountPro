package accountpro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import accountpro.dao.BaseDao;
import accountpro.dao.CustomerDao;
import accountpro.domain.Customer;
import accountpro.domain.SearchCustomerCriteria;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
	
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());

	@Autowired
	public CustomerDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	public int insertCustomer(Customer customer){
		StringBuffer sql = new StringBuffer();
		
		 //KeyHolder keyHolder = new GeneratedKeyHolder();
		
		 //final String INSERT_SQL = "insert into my_test (name) values(?)";
		 //final String name = "Rob";

		sql.append("Insert into Customer ( LastName, FirstName , Address , City, ZipCode)");
		sql.append("VALUES (?,?,?,?,?)");

		 final String INSERT_SQL = sql.toString();
		 
		 final String lastName = customer.getLastName();
		 final String firstName= customer.getFirstName();
		 final String address = customer.getAddress();
		 final String city = customer.getCity();
		 final String zipCode = customer.getZipCode();
		 
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 this.getJdbcTemplate().update(new PreparedStatementCreator() {
		         public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		             PreparedStatement ps =
		                 connection.prepareStatement(INSERT_SQL, new String[] {"id"});
		             ps.setString(1, lastName);
		             ps.setString(2, firstName);
		             ps.setString(3, address);
		             ps.setString(4, city);
		             ps.setString(5, zipCode);
		             return ps;
		         }
		         
		     },
		     keyHolder);
		 
		
/*		List<Object> args = new ArrayList<Object>();
		args.add(customer.getLastName());
		args.add(customer.getFirstName());
		args.add(customer.getAddress());
		args.add(customer.getCity());
		args.add(customer.getZipCode());
*/		
		//int result = this.getJdbcTemplate().update(sql.toString(), args.toArray());
		logger.info("inserted Customer id "+keyHolder.getKey().intValue());
		int result = keyHolder.getKey().intValue();
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

	@Override
	public List<Customer> searchCustomer(SearchCustomerCriteria searchCustomerCriteria) {
		StringBuffer sql = new StringBuffer();
		List<Object> args = new ArrayList<Object>();
		
		sql.append("select * from Customer ");

		if(StringUtils.isBlank(searchCustomerCriteria.getCity()))
			sql.append("WHERE City IS NOT NULL ");
		else
			sql.append("WHERE City = ? ");
		
		if(StringUtils.isNotBlank(searchCustomerCriteria.getFirstName()))
			sql.append(" and FirstName = ? ");
		if(StringUtils.isNotBlank(searchCustomerCriteria.getLastName()))
			sql.append(" and LastName = ? ");
		
		
		if(StringUtils.isNotBlank(searchCustomerCriteria.getCity()))
			args.add(searchCustomerCriteria.getCity());
		if(StringUtils.isNotBlank(searchCustomerCriteria.getFirstName()))
			args.add(searchCustomerCriteria.getFirstName());
		if(StringUtils.isNotBlank(searchCustomerCriteria.getLastName()))
			args.add(searchCustomerCriteria.getLastName());

		
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

	@Override
	public List<Customer> getCustomers() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from Customer");
		SqlRowSet rss  = this.getJdbcTemplate().queryForRowSet(sql.toString());
		
		List<Customer> customers = new ArrayList<Customer>();
		while(rss.next()){
			
			Customer customer =  new Customer();
			customer.setCustomerID(Integer.toString(rss.getInt("P_Id")));
			customer.setLastName(rss.getString("LastName"));
			customer.setFirstName(rss.getString("FirstName"));
			customer.setAddress(rss.getString("Address"));
			customer.setCity(rss.getString("City"));
			customer.setZipCode(rss.getString("ZipCode"));
			customers.add(customer);
		}
		
		return customers;
	
	}



}
