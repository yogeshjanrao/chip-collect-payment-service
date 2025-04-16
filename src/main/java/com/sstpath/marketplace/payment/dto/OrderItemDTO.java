package com.sstpath.marketplace.payment.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrderItemDTO {
    private BigDecimal price;
    private VendorDTO vendor;
}