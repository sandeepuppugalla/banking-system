package com.cg.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Loan;
import com.cg.utility.EMICalculator;
import com.cg.utility.FTable;
import com.cg.utility.LoanSummary;

@Service
public class LoanService {
	
@Autowired
EMICalculator emiCal;
	
public  LoanSummary  Schedule(Loan loan){
	double endingBalance;
	double beginningBalance=loan.getLoanAmount();
	double interest;
	double principle;
	double totalInterest=0;
	double payment=emiCal.getEMIAmount(loan);
	long b=loan.getTenure();
	LocalDate emiDate;

	List<FTable> list=new ArrayList<FTable>();

	for(long i=0;i<b;i++)
		{	
		emiDate=loan.getStartDate().plusMonths(i);
		interest=emiCal.getInterestAmount(beginningBalance,loan.getRateOfInterest());
		principle=payment-interest;
		endingBalance=beginningBalance-principle;
		FTable table= new FTable(i,emiDate,beginningBalance,payment,principle,interest,endingBalance);
		totalInterest=totalInterest+interest;
		list.add(table);
		beginningBalance=endingBalance;
			
		}
		return LoanSummary.builder().list(list).monthlyPayment(payment).numberOfPayments(b).totalInterest(totalInterest).totalCostOfLoan(payment*b).build();
		
	}
}