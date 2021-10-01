package com.cg.utility;

import java.math.BigDecimal;

public class HomeLoan implements IInterestRate {

	@Override
	public BigDecimal rateOfInterest() {
		
		return BigDecimal.valueOf(6.5);
	}

	
}


