package com.sstpath.marketplace.payment.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ChipPurchaseRequest {
    private String brand_id;
    private String external_id;
    private String name;
    private String email;
    private Integer amount;
    private String currency;
    private String success_redirect;
    private String success_callback;
    private List<Product> products;

    @Data
    public static class Product {
        private String name;
        private Integer price;
        private Integer quantity;
    }
}