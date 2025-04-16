package com.sstpath.marketplace.payment.dto.request;

import lombok.Data;

@Data
public class CreateBrandRequest {
    private String name;
    private BusinessProfile business_profile;

    @Data
    public static class BusinessProfile {
        private String name;
        private String email;
        private String phone_number;   // optional
        private String address;        // optional
    }
}