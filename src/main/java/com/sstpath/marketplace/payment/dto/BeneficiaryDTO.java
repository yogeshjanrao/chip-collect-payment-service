package com.sstpath.marketplace.payment.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryDTO {
	private String beneficiaryName;
    private String beneficiaryAccountNumber;
    private String beneficiaryBankCode;
    private BigDecimal amount;
}
