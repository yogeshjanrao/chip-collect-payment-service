package com.sstpath.marketplace.payment.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class OrderDTO {
    private String orderRef;
    private BigDecimal totalAmount;
    private List<OrderItemDTO> items;
}