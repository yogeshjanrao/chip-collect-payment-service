package com.sstpath.marketplace.payment.dto;

import lombok.Data;

@Data
public class CreateBrandResponse {
    private String id;
    private String name;
    private BusinessProfile business_profile;
    private String created_at;
    private String updated_at;

    @Data
    public static class BusinessProfile {
        private String name;
        private String email;
        private String phone_number;
        private String address;
    }
}