package com.sstpath.marketplace.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sstpath.marketplace.payment.config.ChipFeignConfig;
import com.sstpath.marketplace.payment.dto.ChipPayoutResponse;
import com.sstpath.marketplace.payment.dto.ChipRecipientResponse;
import com.sstpath.marketplace.payment.dto.request.ChipPayoutRequest;
import com.sstpath.marketplace.payment.dto.request.ChipRecipientRequest;

@FeignClient(name = "ChipSend", url = "${app.chip-send.url}", configuration = ChipFeignConfig.class)
public interface ChipSendClient {

    @PostMapping("/recipients/")
    ChipRecipientResponse createRecipient(@RequestBody ChipRecipientRequest request);

    @PostMapping("/payouts/")
    ChipPayoutResponse createPayout(@RequestBody ChipPayoutRequest request);
}