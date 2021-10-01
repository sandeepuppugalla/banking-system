package com.cg.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.cg.utility.IInterestRate;
import com.cg.utility.InterestRateFactory;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	
	
	private BigDecimal loanAmount;
	private Integer tenure;
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	@Enumerated(EnumType.STRING)
	private  LoanType loanType;
	

	public BigDecimal getRateOfInterest() {
		InterestRateFactory interestRateFactory=new InterestRateFactory();
		IInterestRate interestRate=interestRateFactory.getInterestRate(getLoanType());
		
	    BigDecimal rateOfInterest=interestRate.rateOfInterest();
		return rateOfInterest;
	}
	
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}


	public Integer getTenure() {
		return tenure*12;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
}
