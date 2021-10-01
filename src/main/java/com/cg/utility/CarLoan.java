package com.cg.utility;

import java.math.BigDecimal;

public class CarLoan implements IInterestRate {

	@Override
	public BigDecimal rateOfInterest() {
		
		return BigDecimal.valueOf(7.5);
	}

	
}


