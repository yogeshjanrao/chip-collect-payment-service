package com.sstpath.marketplace.payment.dto;

import lombok.Data;

@Data
public class ChipPurchaseResponse {
    private String id;
    private String status;
    private String checkout_url;
}