package com.cg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cg.Exception.ResourceNotFoundException;
import com.cg.dao.ICustomerDao;
import com.cg.entities.Customer;
import com.cg.service.ICustomerService;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {

		return customerDao.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.findAll();
	}



	@Override
	public Customer getCustomerById(int customerId) {


	return customerDao.findById(customerId).orElseThrow(()  ->
	new ResourceNotFoundException("Customer record not found with id",customerId));

}


	@Override
	public Customer updateCustomer(Customer customer) {
		
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
		
		customerDao.findById(customer.getCustomerId()).orElseThrow(() -> 
		new ResourceNotFoundException("Customer record not found with id",customer.getCustomerId()) );
		
		customerDao.deleteById(customer.getCustomerId());
		
	}
	
	
}
