package com.icinbank.model;

public class UserDisplay {
	String username;
	private int primaryAccno;
	private int primaryBalance;
	private int savingsAccno;
	private int savingsBalance;
	
	public UserDisplay() {
		
	}
	
	public UserDisplay(String username,int primaryAccno,
			int primaryBalance, int savingsAccno, int savingsBalance) {
		super();
		this.username=username;
		this.primaryAccno = primaryAccno;
		this.primaryBalance = primaryBalance;
		this.savingsAccno = savingsAccno;
		this.savingsBalance = savingsBalance;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPrimaryAccno() {
		return primaryAccno;
	}
	public void setPrimaryAccno(int accno) {
		this.primaryAccno = accno;
	}
	
	public int getPrimaryBalance() {
		return primaryBalance;
	}

	public void setPrimaryBalance(int primaryBalance) {
		this.primaryBalance = primaryBalance;
	}

	public int getSavingsAccno() {
		return savingsAccno;
	}

	public void setSavingsAccno(int savingsAccno) {
		this.savingsAccno = savingsAccno;
	}

	public int getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(int savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	
}
