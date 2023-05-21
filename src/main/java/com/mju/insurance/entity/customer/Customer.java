package com.mju.insurance.entity.customer;

/**
 * 
 * @author bigst
 *
 */

public class Customer {
	private String id;
	private String email;
	private String password;
	private String name;
	private int age;
	private boolean gender; // M: true, W: false
	private String registrationNo;
	private String phoneNo;
	private String accountNo;
	private boolean isMarried;
	private AdditionalInfo additionalInfo;

	public Customer() {
		this.additionalInfo = new AdditionalInfo();
	}

	// getters & setters //
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public boolean getGender() { return gender; }
	public void setGender(boolean gender) { this.gender = gender; }
	public String getRegistrationNo() { return registrationNo; }
	public void setRegistrationNo(String registrationNo) { this.registrationNo = registrationNo; }
	public String getPhoneNo() { return phoneNo; }
	public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
	public String getAccountNo() { return accountNo; }
	public void setAccountNo(String accountNo) { this.accountNo = accountNo; }
	public boolean isMarried() { return this.isMarried; }
	public void setMarried(boolean isMarried) { this.isMarried = isMarried; }
	public AdditionalInfo getAdditionalInfo() { return additionalInfo; }
	public void setAdditionalInfo(AdditionalInfo additionalInfo) { this.additionalInfo = additionalInfo; }
	
}//end Customer