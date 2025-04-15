package com.sstpath.marketplace.payment.internal.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sstpath.marketplace.payment.client.ChipCollectClient;
import com.sstpath.marketplace.payment.client.ChipSendClient;
import com.sstpath.marketplace.payment.dto.BeneficiaryDTO;
import com.sstpath.marketplace.payment.dto.ChipPurchaseResponse;
import com.sstpath.marketplace.payment.dto.OrderDTO;
import com.sstpath.marketplace.payment.dto.OrderItemDTO;
import com.sstpath.marketplace.payment.dto.VendorDTO;
import com.sstpath.marketplace.payment.dto.request.ChipPayoutRequest;
import com.sstpath.marketplace.payment.dto.request.ChipPurchaseRequest;
import com.sstpath.marketplace.payment.internal.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private final ChipCollectClient chipCollectClient;
	private final ChipSendClient chipSendClient;

	@Override
	public String handlePayment(OrderDTO order) {
		
        ChipPurchaseRequest purchaseRequest = new ChipPurchaseRequest();
        purchaseRequest.getPurchase().setTotal(order.getTotalAmount());
        purchaseRequest.getPurchase().setCurrency("MYR");
        purchaseRequest.setOrderRef(order.getOrderRef());
        purchaseRequest.setSuccess_redirect("https://your-frontend.com/success");
        purchaseRequest.setFailure_redirect("https://your-frontend.com/failure");

		ChipPurchaseResponse purchaseResponse = chipCollectClient.createPurchase(purchaseRequest);

		Map<VendorDTO, BigDecimal> vendorTotals = new HashMap<>();
        for (OrderItemDTO item : order.getItems()) {
            vendorTotals.merge(item.getVendor(), item.getPrice(), BigDecimal::add);
        }
        
        List<BeneficiaryDTO> payouts = vendorTotals.entrySet().stream()
                .map(entry -> {
                    VendorDTO vendor = entry.getKey();
                    return new BeneficiaryDTO(
                        vendor.getName(),
                        vendor.getBankAccountNumber(),
                        vendor.getBankCode(),
                        entry.getValue()
                    );
                })
                .toList();
        
       
        ChipPayoutRequest payoutRequest = new ChipPayoutRequest();
        payoutRequest.setPurchaseId(purchaseResponse.getId());
        payoutRequest.setPayouts(payouts);

        chipSendClient.createPayout(payoutRequest);

        return purchaseResponse.getCheckout_url();
    }

}
