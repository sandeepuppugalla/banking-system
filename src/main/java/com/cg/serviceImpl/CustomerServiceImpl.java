package com.cg.serviceImpl;


import java.util.List;
//import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Customer;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.ICustomerDao;
import com.cg.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {
//		if(customer.getCustomerAddress()== null) {
//			throw new ResourceNotFoundException("Address not found");
//		}
		return customerDao.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.findAll();
	}



	@Override
	public Customer getCustomerById(int customerId) {
//		Optional<Customer> customer=customerDao.findById(customerId);
//		
//		if(customer.isPresent()) {
//			return customer.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Customer record not found with id",customerId);
//		}

	return customerDao.findById(customerId).orElseThrow(()  ->
	new ResourceNotFoundException("Customer record not found with id",customerId));

}


	@Override
	public Customer updateCustomer(Customer customer) {
		
		//check whether customer with given id is exist in db or not
		Customer existingCustomer = customerDao.findById(customer.getCustomerId()).orElseThrow(() -> 
		new ResourceNotFoundException("Customer record not found with id",customer.getCustomerId()) );
		
		existingCustomer.setCustomerName(customer.getCustomerName());
		existingCustomer.setCustomerAddress(customer.getCustomerAddress());
		existingCustomer.setPhoneNo(customer.getPhoneNo());
		existingCustomer.setLandlineNo(customer.getLandlineNo());
		existingCustomer.setPinCode(customer.getPinCode());
		existingCustomer.setType(customer.getType());
		
		customerDao.save(existingCustomer);
		return existingCustomer;
		
	}



	@Override
	public void deleteCustomer(Customer customer) {
		
		//check whether employee exist in db or not
		customerDao.findById(customer.getCustomerId()).orElseThrow(() -> 
		new ResourceNotFoundException("Customer record not found with id",customer.getCustomerId()) );
		
		customerDao.deleteById(customer.getCustomerId());
		
	}
	
	
	

}
