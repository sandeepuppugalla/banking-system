package com.cg;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entities.AccountType;
import com.cg.entities.Customer;
import com.cg.service.ICustomerService;
import com.cg.serviceImpl.CustomerServiceImpl;

@DataJpaTest
@ExtendWith({ SpringExtension.class })
@Import(CustomerServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerTest{
	
	@Autowired
	private ICustomerService service;
	
	@Test
	public void testSaveCustomer() {
		Customer customer = new Customer(1, "sandeep", "jn", "9502984810",12345L, 67890L,AccountType.SavingsAccount);
		Customer exCustomer = service.saveCustomer(customer);
		Assertions.assertEquals(exCustomer.getCustomerName(), customer.getCustomerName());
	
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer=service.saveCustomer(new Customer(2, "anand", "Hyderabad", "9553677503", 678909L, 502287L, AccountType.LoanAccount));
		customer.setCustomerAddress("Hyderabad");
		customer.setType(AccountType.CurrentAccount);
		Customer exCustomer = service.updateCustomer(customer);
		Assertions.assertEquals(exCustomer.getCustomerAddress(),customer.getCustomerAddress());
	}

	@Test
	public void testViewAllCustomer() {
		Customer customer1= service.saveCustomer(new Customer(0, "swee", "banglore", "7867565768", 678909L, 502287L, AccountType.LoanAccount));
		Customer customer2= service.saveCustomer(new Customer(3, "sam", "chennai", "8756453456", 6787886L, 502288L, AccountType.SavingsAccount));
		Customer customer3= service.saveCustomer(new Customer(4, "froo", "pune", "9867895678", 890980L, 502289L, AccountType.CurrentAccount));

		List<Customer> cList=service.getAllCustomers();

		Assertions.assertTrue(cList.contains(customer3));
	}
	
}
	


