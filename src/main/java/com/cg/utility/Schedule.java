package com.cg.utility;



import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Schedule {
	private Long pmt_no;
	private LocalDate emiDate;
	private BigDecimal beginingBalance;
	private BigDecimal payment;
	private BigDecimal principle;
	private BigDecimal intrest;
	private BigDecimal endingBalance;
	
}
