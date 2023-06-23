package com.cihan.kafkaproducerconsumer.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountSummaryMessage {
    private Instant fromTime;
    private Instant toTime;
    private BigDecimal startingBalance;
    private BigDecimal endingBalance;
    private BigDecimal totalDeposited;
    private BigDecimal totalWagered;
    private BigDecimal totalBonuses;
}