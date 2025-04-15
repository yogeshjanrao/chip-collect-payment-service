package com.sstpath.marketplace.payment.dto;

import lombok.Data;

@Data
public class ChipPayoutResponse {
    private String id; // This is the purchaseId
    private String redirectUrl;
}
