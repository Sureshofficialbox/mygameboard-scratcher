package com.interview.mygameboardscratcher.gamecomponent.matchers;

import java.math.BigDecimal;

import com.interview.mygameboardscratcher.config.CombinationGroup;

/**
 * @author SURESH S
 * Date: 10.04.2025
 */
public record MatchingResult(
        String symbol,
        String combination,
        CombinationGroup group,
        BigDecimal rewardMultiplier
) {
}
