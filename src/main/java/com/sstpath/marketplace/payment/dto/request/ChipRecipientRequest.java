package com.sstpath.marketplace.payment.dto.request;

import lombok.Data;

@Data
public class ChipRecipientRequest {
    private String name;
    private String email;
    private String bank_account_number;
    private String bank_code;
    private String bank_name;
    private String id_type;
    private String id_number;
}