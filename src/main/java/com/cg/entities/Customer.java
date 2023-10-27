package com.cg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // Instead of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_Id")
	private int customerId;
	
	@Column(name="cust_name",nullable = false)
	@Size(min=2, message ="customer name should have atleast 2 characters")
	@NotEmpty
	private String customerName;
	
	@NotEmpty
	@Column(name="cust_add",nullable = false)
	private String customerAddress;
	
	@NotEmpty
	@Size(max=10,message ="customer phone number should have  10 characters")
	@Column(name="cust_phoneNo",nullable = false)
	private String phoneNo;
	
	@NotNull
	@Column(name="cust_landLine",nullable = false)
	private Long landlineNo;
	
	@NotNull
	@Column(name="cust_pinCode")
	private Long pinCode;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private  AccountType type;
	
	
	//public Customer toReservation() { return new Customer().setCustomerAddress(customerAddress);}
}
