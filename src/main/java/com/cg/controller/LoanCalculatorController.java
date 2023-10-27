package com.cg.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Loan;
import com.cg.serviceImpl.LoanService;


@RestController
@RequestMapping("/LoanCalculator")
public class LoanCalculatorController {

	
	@Autowired
	private LoanService loanService;
	

	
	@GetMapping("/emi")
	public ResponseEntity<Object> schedule(@RequestBody Loan loan){
		return new ResponseEntity<>(loanService.Schedule(loan),HttpStatus.OK);
	
	}
	
}
