package com.web.bank;

import java.util.Random;

public class Bank {
	
	private String Firstname;
	private String Lastname;
	private String amount;
	private String account;
		
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	
	 public static String generateRandomValue() {
	        Random random = new Random();

	        int randomInteger = random.nextInt(100000) + 1;

	        StringBuilder randomString = new StringBuilder();
	        for (int i = 0; i < 7; i++) {
	            char randomChar = (char) (random.nextInt(26) + 'a');
	            randomString.append(randomChar);
	        }

	        return randomInteger + randomString.toString();
	    }
	public  String getId() {
		return generateRandomValue();
	}
	@Override
	public String toString() {
		return "Bank [Firstname=" + Firstname + ", Lastname=" + Lastname + ", amount=" + amount + ", account=" + account
				+ "]";
	}
	
}
