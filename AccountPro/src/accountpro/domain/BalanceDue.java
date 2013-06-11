package accountpro.domain;

import java.util.Date;

public class BalanceDue {

	public int customerId;
	
	public String customerName;
	
	public int policyId;
	
	public double paymentDue;
	
	public Date lastUpdated;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public double getPaymentDue() {
		return paymentDue;
	}
	public void setPaymentDue(double paymentDue) {
		this.paymentDue = paymentDue;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
