package org.practice.main;

import org.practice.interfaces.payment.Payment;
import org.practice.payment.impl.CashOnDeliveryPayment;
import org.practice.payment.impl.CreditCardPayment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		/*Address address = (Address) context.getBean("address");
		System.out.println(address);*/
		
		/*User user = (User) context.getBean("user");
		System.out.println(user);*/
		
		CreditCardPayment  cardPayment = (CreditCardPayment)context.getBean("creditPayment");
		//Payment cashOnDeliveryPayment = (Payment)context.getBean("codPayment");
		cardPayment.makePayment(1000L);
		//cashOnDeliveryPayment.makePayment(1000L);
	}
}
