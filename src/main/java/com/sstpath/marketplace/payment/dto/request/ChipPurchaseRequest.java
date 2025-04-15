package com.sstpath.marketplace.payment.dto.request;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ChipPurchaseRequest {
    private String brand_id;
    private String external_id;
    private ClientInfo client;
    private PurchaseDetails purchase;
    private String success_redirect;
    private String failure_redirect;
    private String success_callback;
    private String orderRef;
    
    @Data
    public static class ClientInfo {
        private String email;
        private String phone;
        private String name;
    }

    @Data
    public static class PurchaseDetails {
        private List<Product> products;
        private BigDecimal total;
        private String currency;
        private String invoice;

        @Data
        public static class Product {
            private String name;
            private int quantity;
            private int price;
        }
    }
}


