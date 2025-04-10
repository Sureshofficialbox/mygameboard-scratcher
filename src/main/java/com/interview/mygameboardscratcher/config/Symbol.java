package com.interview.mygameboardscratcher.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author SURESH S
 * Date: 10.04.2025
 */
public record Symbol(
        @JsonProperty("reward_multiplier")
        BigDecimal rewardMultiplier,
        BigDecimal extra,
        SymbolType type,
        ImpactType impact
) {
}
