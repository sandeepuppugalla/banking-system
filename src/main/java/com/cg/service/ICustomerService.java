package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entities.Customer;

@Service
public interface ICustomerService {

	public void addCustomer(Customer customer);
	List<Customer> getAllCustomers();
	
}
