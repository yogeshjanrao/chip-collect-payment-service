package com.sstpath.marketplace.payment.internal;

import com.sstpath.marketplace.payment.dto.ChipPurchaseResponse;

public interface PaymentService {

    ChipPurchaseResponse makeOrderPayment(Long orderId);
}
