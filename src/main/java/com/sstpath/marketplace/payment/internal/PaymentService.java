package com.sstpath.marketplace.payment.internal;

import com.sstpath.marketplace.payment.dto.OrderDTO;

public interface PaymentService {
	public String handlePayment(OrderDTO order);
}
