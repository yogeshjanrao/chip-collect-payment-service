package com.sstpath.marketplace.payment.client;

import com.sstpath.marketplace.payment.config.ChipFeignConfig;
import com.sstpath.marketplace.payment.dto.ChipPayoutResponse;
import com.sstpath.marketplace.payment.dto.ChipRecipientResponse;
import com.sstpath.marketplace.payment.dto.CreateBrandResponse;
import com.sstpath.marketplace.payment.dto.request.ChipPayoutRequest;
import com.sstpath.marketplace.payment.dto.request.ChipRecipientRequest;
import com.sstpath.marketplace.payment.dto.request.CreateBrandRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ChipSend", url = "${app.chip-collect.url}", configuration = ChipFeignConfig.class)
public interface ChipSendClient {

    @PostMapping("/brands")
    CreateBrandResponse createBrand(@RequestBody  CreateBrandRequest request);

    @PostMapping("/recipients/")
    ChipRecipientResponse createRecipient(@RequestBody ChipRecipientRequest request);

    @PostMapping("/payouts/")
    ChipPayoutResponse createPayout(@RequestBody ChipPayoutRequest request);
}