package com.interview.mygameboardscratcher.config;

import java.util.Map;

/**
 * @author SURESH S
 * Date: 10.04.2025
 */
public record CellDistribution(
        int column,
        int row,
        Map<String, Integer> symbols
) {
}
