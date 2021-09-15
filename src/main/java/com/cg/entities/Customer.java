package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	int customerId;
	String customerName;
	String customerAddress;
	long phoneNo;
	long lamdlineNo;
	long pinCode;	
	
	public Customer(int customerId, String customerName, String customerAddress, long phoneNo, long lamdlineNo,
			long pinCode) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.phoneNo = phoneNo;
		this.lamdlineNo = lamdlineNo;
		this.pinCode = pinCode;
	
	}
	
	@Enumerated(EnumType.STRING)
	private AccountType AccountType;
	

	

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getLamdlineNo() {
		return lamdlineNo;
	}

	public void setLamdlineNo(long lamdlineNo) {
		this.lamdlineNo = lamdlineNo;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", phoneNo=" + phoneNo + ", lamdlineNo=" + lamdlineNo + ", pinCode=" + pinCode
				+ ", AccountType=" + AccountType + ", getCustomerId()=" + getCustomerId() + ", getCustomerName()="
				+ getCustomerName() + ", getCustomerAddress()=" + getCustomerAddress() + ", getPhoneNo()="
				+ getPhoneNo() + ", getLamdlineNo()=" + getLamdlineNo() + ", getPinCode()=" + getPinCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	

	
	
	
	
	
}
