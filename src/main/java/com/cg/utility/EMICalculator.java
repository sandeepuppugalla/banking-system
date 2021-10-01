package com.cg.utility;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.cg.entities.Loan;

@Component
public class EMICalculator {
	
	public BigDecimal getEMIAmount(Loan loan) {
		
		BigDecimal rateOfInterest = loan.getRateOfInterest().divide(BigDecimal.valueOf(1200),MathContext.DECIMAL128);
		BigDecimal emiAmount=(loan.getLoanAmount().multiply(rateOfInterest)
				.multiply(BigDecimal.ONE.add(rateOfInterest).pow(loan.getTenure())))
				.divide(BigDecimal.ONE.add(rateOfInterest).pow(loan.getTenure()).subtract(BigDecimal.ONE),MathContext.DECIMAL128);
		
		return emiAmount;				
		
		
	/*	BigDecimal emiAmount = (loan.getLoanAmount() 
								* rateOfInterest 
								* (double)Math.pow(1 + rateOfInterest, loan.getTenure()))
								/ (double)(Math.pow(1 + rateOfInterest, loan.getTenure()) - 1);
		return emiAmount;*/

	}
	
	public BigDecimal getInterestAmount(BigDecimal beginningBalance, BigDecimal rateOfInterest) {
		
		BigDecimal interest=beginningBalance.multiply(rateOfInterest.divide(BigDecimal.valueOf(1200),MathContext.DECIMAL128));
		//BigDecimal interest = (beginningBalance * (rateOfInterest/12)/100);
		
		return interest;
	}
	
	
}