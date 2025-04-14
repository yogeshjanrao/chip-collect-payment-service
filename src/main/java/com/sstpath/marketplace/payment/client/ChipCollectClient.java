package com.sstpath.marketplace.payment.client;

import com.sstpath.marketplace.payment.config.ChipFeignConfig;
import com.sstpath.marketplace.payment.dto.request.ChipPurchaseRequest;
import com.sstpath.marketplace.payment.dto.ChipPurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ChipCollect", url = "${app.chip-collect.url}", configuration = ChipFeignConfig.class)
public interface    ChipCollectClient {
    
    @PostMapping("/purchases/")
    ChipPurchaseResponse createPurchase(@RequestBody ChipPurchaseRequest request);
    
    @GetMapping("/purchases/{id}/")
    ChipPurchaseResponse getPurchase(@PathVariable("id") String id);
}
