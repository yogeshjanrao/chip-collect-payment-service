package com.sstpath.marketplace.payment.internal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sstpath.marketplace.payment.api.PaymentApi;
import com.sstpath.marketplace.payment.dto.OrderDTO;
import com.sstpath.marketplace.payment.internal.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController implements PaymentApi {
	
	 private final PaymentService paymentService;

	    @PostMapping("/process")
	    public ResponseEntity<String> processPayment(@RequestBody OrderDTO order) {
	    	String redirectUrl = paymentService.handlePayment(order);
	        return ResponseEntity.ok(redirectUrl);
	    }
}
