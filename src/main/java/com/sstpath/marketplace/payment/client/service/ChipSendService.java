package com.sstpath.marketplace.payment.client.service;

import com.sstpath.marketplace.payment.client.ChipSendClient;
import com.sstpath.marketplace.payment.dto.ChipPurchaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChipSendService {

    private final ChipSendClient chipSendClient;

}
