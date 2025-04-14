package com.sstpath.marketplace.payment.client;

import com.sstpath.marketplace.payment.api.PaymentApi;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/v1/payments")
public interface PaymentApiClient extends PaymentApi {
}
