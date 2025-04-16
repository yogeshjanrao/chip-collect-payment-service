package com.sstpath.marketplace.payment.dto;

import lombok.Data;

@Data
public class VendorDTO {
    private String name;
    private String bankAccountNumber;
    private String bankCode;
}