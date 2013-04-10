package accountpro.domain;

import java.util.Date;

public class SearchPolicyCriteria {

	public int policyID;
	public String customerName;
	
	public String firstName;
	public String lastName;
	
	public String policyType;
	public int policyNumber;
	public double policyAmount;
	public Date startDate;
	public Date endDate;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCustomerName() {
		//return customerName;
		StringBuffer sb = new StringBuffer("");
		sb.append(firstName+ " "+lastName);
		return sb.toString();
		//return firstName+" "+lastName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	public double getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPolicyID() {
		return policyID;
	}
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

}
