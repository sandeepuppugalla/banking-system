package com.cg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.ICustomerDao;
import com.cg.entities.Customer;
import com.cg.service.ICustomerService;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}
}
