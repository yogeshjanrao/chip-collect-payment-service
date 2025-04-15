package com.sstpath.marketplace.payment.dto;

import lombok.Data;

@Data
public class ChipRecipientResponse {
    private String id;
    private String name;
    private String status;
    private String message;
}