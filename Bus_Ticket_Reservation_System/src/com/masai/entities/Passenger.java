package com.masai.entities;

import java.io.Serializable;

public class Passenger extends User implements Serializable {

	private double walletBalance;

	public Passenger(double walletBalance, String username, String password, String address, String email,long mobileNo) {
		super(username, password, address, email,mobileNo);
		this.walletBalance = walletBalance;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	

}
