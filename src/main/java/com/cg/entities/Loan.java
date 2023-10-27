package com.cg.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emi_Id")
	private int EMIId;
	private double loanAmount;
	private double rateOfInterest;
	private int tenure;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;

	public int getEMIId() {
		return EMIId;
	}

	public void setEMIId(int eMIId) {
		EMIId = eMIId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public int getTenure() {
		return tenure*12;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Loan [EMIId=" + EMIId + ", loanAmount=" + loanAmount + ", rateOfInterest=" + rateOfInterest
				+ ", tenure=" + tenure + ", startDate=" + startDate + "]";
	}

	
	

	
}
