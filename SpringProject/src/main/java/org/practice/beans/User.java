package org.practice.beans;

public class User {

	private String firstName;
	private String lastName;
	private Address address;
	private String emailId;
	private String mobileNo;
	
	public User(){
		
	}
	
	public User(String firstName, String lastName, Address address,
			String emailId, String mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}
	
	/*public User(Address address){
		this.address = address;
	}*/
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + "]";
	}
	
}
