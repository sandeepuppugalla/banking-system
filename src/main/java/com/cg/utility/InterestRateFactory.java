package com.cg.utility;

import com.cg.entities.LoanType;

public class InterestRateFactory {

	public IInterestRate getInterestRate(LoanType loantype)
	{
		if(loantype.equals(loantype.PersonalLoan))
		{
			return new PersonalLoan();
		}
		else if(loantype.equals(loantype.CarLoan))
		{
			return new CarLoan();
		}
		else if(loantype.equals(loantype.HomeLoan))
		{
			return new HomeLoan();
		}
		
		return null;
		
	}
}
