package accountpro.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import accountpro.dao.BaseDao;
import accountpro.dao.PaymentDao;
import accountpro.domain.Payment;

@Repository("paymentDao")
public class PaymentDaoImpl extends BaseDao implements PaymentDao{

	@Autowired
	public PaymentDaoImpl(DataSource dataSource) {
		super(dataSource);
	}

	private static final Logger logger = Logger.getLogger(PaymentDaoImpl.class.getName());
	
	@Override
	public int makePayment(Payment payment) {
		
		logger.info("Trying to make payment");
		int result = 0;
		try{
			StringBuffer sql = new StringBuffer();
			sql.append("Insert into Payment ( PolicyID, PolicyNumber , PaymentAmount , PaymentDate, IsPaymentProcessed)");
			sql.append("VALUES (?,?,?,?,?)");

			 final String INSERT_SQL = sql.toString();
			 
			 final int policyId = payment.getPolicyId();
			 final int policyNumber = payment.getPolicyNumber();
			 final double paymentAmount = payment.getPaymentAmount();
			 final Date sqlPaymentDate = new Date(System.currentTimeMillis());
			 final boolean paymentProccessed = false;
			 
			 KeyHolder keyHolder = new GeneratedKeyHolder();
			 this.getJdbcTemplate().update(new PreparedStatementCreator() {
			         public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			             PreparedStatement ps =
			                 connection.prepareStatement(INSERT_SQL, new String[] {"Payment_Id"});
			             ps.setInt(1, policyId);
			             ps.setInt(2, policyNumber);
			             ps.setDouble(3, paymentAmount);
			             ps.setDate(4,sqlPaymentDate);
			             ps.setBoolean(5, paymentProccessed);
			             return ps;
			         }
			         
			     },
			     keyHolder);
			 
			logger.info("inserted payment id "+keyHolder.getKey().intValue());
			result = keyHolder.getKey().intValue();
		}
		catch (Exception e){
			result = 0;
			logger.info("Exception is e :"+e.getMessage());
			e.printStackTrace();
		}
		return result;
}

}
