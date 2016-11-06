package org.practice.payment.impl;

import org.practice.interfaces.payment.Payment;

public class CreditCardPayment/* implements Payment*/ {

	public void makePayment(Long amount) {
		System.out.println("Credit Card Payment");
	}

}
