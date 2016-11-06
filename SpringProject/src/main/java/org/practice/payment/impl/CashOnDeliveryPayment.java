package org.practice.payment.impl;

import org.practice.interfaces.payment.Payment;

public class CashOnDeliveryPayment implements Payment {

	public void makePayment(Long amount) {
		System.out.println("Cash on delivery payment");
	}

}
