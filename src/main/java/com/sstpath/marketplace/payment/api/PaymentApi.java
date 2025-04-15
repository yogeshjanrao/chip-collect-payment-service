package com.sstpath.marketplace.payment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface PaymentApi {

    @PostMapping
    ResponseEntity<String> makeOrderPayment(Long orderId);
}
