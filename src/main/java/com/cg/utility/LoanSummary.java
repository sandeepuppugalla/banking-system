package com.cg.utility;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
public class LoanSummary {
	
	private BigDecimal monthlyPayment;
	private long numberOfPayments;
	private BigDecimal totalInterest;
	private BigDecimal totalCostOfLoan;
	private List<Schedule> list;
	

}
