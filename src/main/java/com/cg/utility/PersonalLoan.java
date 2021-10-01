package com.cg.utility;

import java.math.BigDecimal;

public class PersonalLoan implements IInterestRate {

	@Override
	public BigDecimal rateOfInterest() {
		
		return BigDecimal.valueOf(10);
	}

	
}


