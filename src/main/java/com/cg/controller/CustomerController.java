package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Customer;
import com.cg.serviceImpl.CustomerServiceImpl;

//@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;
	
	// create customer Rest API
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer){
		return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	//get all customer Rest API
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		System.out.println("In method getAllCustomers ");
		return customerService.getAllCustomers();
	}
	
	//get customer by id Rest API
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId")  int customerId){
		System.out.println("In method getCustomerById");
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	//update  Rest API
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId
													,@RequestBody @Valid Customer customer){
		System.out.println("In method updateCustomer");
		customer.setCustomerId(customerId);
		return new ResponseEntity<>(customerService.updateCustomer(customer),HttpStatus.OK);
	}
	
	// delete Rest API
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") 
			@RequestBody Customer customer){
		
		System.out.println("In method deleteCustomer");
		customerService.deleteCustomer(customer);
		
		return new ResponseEntity<>("customer deleted sucesssfully!.", HttpStatus.OK);
		
	}

}
