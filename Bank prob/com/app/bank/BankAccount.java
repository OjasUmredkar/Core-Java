package com.app.bank;

public class BankAccount {
	private int acctNo;
	
	private String name;
	private String type;
	private double balance;
	
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", name=" + name + ", type=" + type + ", balance=" + balance + "]";
	}

	public BankAccount(int acctNo, String name, String type, double balance) {
		super();
		this.acctNo = acctNo;
		this.name = name;
		this.type = type;
		this.balance = balance;
	}
	
	@Override
	public boolean equals(Object anotheracct) {
		System.out.println("In acct equals");
		if(anotheracct instanceof BankAccount) {
			return this.acctNo==((BankAccount)anotheracct).acctNo  ;
		}
		
		return false;
	}
}
