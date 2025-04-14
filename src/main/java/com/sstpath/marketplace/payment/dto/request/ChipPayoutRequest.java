package com.sstpath.marketplace.payment.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ChipPayoutRequest {
    private String recipient_id;
    private String external_id;
    private Integer amount;
    private String currency;
    private String description;
}