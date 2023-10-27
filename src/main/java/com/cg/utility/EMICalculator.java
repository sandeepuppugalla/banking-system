package com.cg.utility;

import org.springframework.stereotype.Component;

import com.cg.entities.Loan;

@Component
public class EMICalculator {

	public double getEMIAmount(Loan loan) {

		double rateOfInterest = loan.getRateOfInterest() / 1200;
		return (loan.getLoanAmount() * rateOfInterest
				* (double) Math.pow(1 + rateOfInterest, loan.getTenure()))
				/ (double) (Math.pow(1 + rateOfInterest, loan.getTenure()) - 1);
		 

	}

	public double getInterestAmount(double beginningBalance, double rateOfInterest) {

		double interest = (beginningBalance * (rateOfInterest / 12) / 100);

		return interest;
	}

}