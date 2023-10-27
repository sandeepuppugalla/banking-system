package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.entities.Customer;


public interface ICustomerDao extends JpaRepository<Customer, Integer>{
	
}
