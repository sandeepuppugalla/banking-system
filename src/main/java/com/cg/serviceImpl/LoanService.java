package com.cg.serviceImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Loan;
import com.cg.utility.EMICalculator;
import com.cg.utility.Schedule;
import com.cg.utility.LoanSummary;

@Service
public class LoanService {
	
@Autowired
EMICalculator emiCal;
	
public  LoanSummary  loanSummaryDetails(Loan loan){
	BigDecimal endingBalance;
	BigDecimal beginningBalance=loan.getLoanAmount();
	BigDecimal interest;
	BigDecimal principle;
	BigDecimal totalInterest=new BigDecimal("0");
	BigDecimal payment=emiCal.getEMIAmount(loan).setScale(2, RoundingMode.HALF_UP);
	long tenure=loan.getTenure();
	LocalDate emiDate;

	List<Schedule> list=new ArrayList<Schedule>();

	for(long i=1;i<=tenure;i++)
		{	
		emiDate=loan.getStartDate().plusMonths(i);
		interest=emiCal.getInterestAmount(beginningBalance,loan.getRateOfInterest()).setScale(2, RoundingMode.HALF_UP);
		principle=payment.subtract(interest);
		endingBalance=beginningBalance.subtract(principle);
		//Table table= new Table(i,emiDate,beginningBalance,payment,principle,interest,endingBalance);
		totalInterest=totalInterest.add(interest);
		list.add(Schedule.builder().pmt_no(i).emiDate(emiDate).beginingBalance(beginningBalance).payment(payment).principle(principle).intrest(interest).endingBalance(endingBalance).build());
		beginningBalance=endingBalance;
			
		}
		return LoanSummary.builder().list(list).monthlyPayment(payment).numberOfPayments(tenure).totalInterest(totalInterest).totalCostOfLoan(payment.multiply(BigDecimal.valueOf(tenure))).build();
		
	}
}