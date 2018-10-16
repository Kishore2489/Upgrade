package com.qa.api;

public class StateInfo {
	
	private String label;
	private String abbreviation;
	private float minLoanAmount;
	private int minAge;
	public StateInfo(String label, String abbreviation, int minLoanAmount, int minAge) {
		super();
		this.label = label;
		this.abbreviation = abbreviation;
		this.minLoanAmount = minLoanAmount;
		this.minAge = minAge;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public float getMinLoanAmount() {
		return minLoanAmount;
	}
	public void setMinLoanAmount(int minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	

}
