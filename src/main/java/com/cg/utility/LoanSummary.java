package com.cg.utility;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LoanSummary {
	
	private double monthlyPayment;
	private long numberOfPayments;
	private double totalInterest;
	private double totalCostOfLoan;
	private List<FTable> list;
	

}
