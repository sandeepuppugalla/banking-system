package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return new ResponseEntity<>("Customer added succesfully",HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomers")
	public ResponseEntity<Object> getAllCustomers()
	{	
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
}
