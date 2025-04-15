package com.sstpath.marketplace.payment.dto.request;

import java.util.List;

import com.sstpath.marketplace.payment.dto.BeneficiaryDTO;

import lombok.Data;

@Data
public class ChipPayoutRequest {
    private String purchaseId;
    private List<BeneficiaryDTO> payouts;
}
