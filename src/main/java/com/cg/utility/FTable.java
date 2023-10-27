package com.cg.utility;



import java.time.LocalDate;

import org.springframework.stereotype.Component;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FTable {
	private long pmt_no;
	private LocalDate emiDate;
	private double beginingBalance;
	private double payment;
	private double principle;
	private double intrest;
	private double endingBalance;
	
}
