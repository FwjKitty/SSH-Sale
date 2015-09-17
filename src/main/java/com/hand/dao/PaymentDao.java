package com.hand.dao;

import java.util.List;

import com.hand.model.Payment;

public interface PaymentDao {
	

	public List<Payment> getPayment();
	public Payment getPayment(int customer_id);
	//public Payment getPayment2(int payment_id);
	public void update(Payment payment, int customer_id);
	public void add(Payment payment);
	public void delete(Payment payment);
}
