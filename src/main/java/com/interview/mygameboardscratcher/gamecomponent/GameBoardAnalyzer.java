package com.interview.mygameboardscratcher.gamecomponent;

import java.math.BigDecimal;
import java.util.*;

import com.interview.mygameboardscratcher.config.Config;
import com.interview.mygameboardscratcher.config.Symbol;
import com.interview.mygameboardscratcher.gamecomponent.matchers.CombinationMatcher;
import com.interview.mygameboardscratcher.gamecomponent.matchers.MatchingResult;

import static java.math.BigDecimal.ZERO;

/**
 * @author SURESH S
 * Date: 10.04.2025
 */
public class GameBoardAnalyzer {
    private final Config config;

    Map<String, List<String>> winningCombinations;
    Map<String, BigDecimal> rewardMultipliers;

    public GameBoardAnalyzer(Config config) {
        this.config = config;
    }

    public GameBoard analyze(GameBoard gameBoard, BigDecimal bet) {
        List<MatchingResult> matched = new CombinationMatcher(config.winCombinations()).match(gameBoard.matrix());
        BigDecimal reward = ZERO;

        if (!matched.isEmpty()) {
            filterMultipliers(matched);
            reward = applyBasicSymbols(rewardMultipliers, bet);
            reward = applyBonusSymbol(gameBoard.bonusSymbol(), reward);
        }

        return new GameBoard(
                gameBoard.matrix(),
                reward,
                winningCombinations,
                reward.equals(ZERO) ? null : gameBoard.bonusSymbol()
        );
    }

    private void filterMultipliers(List<MatchingResult> matched) {
        winningCombinations = new HashMap<>();
        rewardMultipliers = new HashMap<>();
        Set<String> covered = new HashSet<>();
        for (MatchingResult matchingResult : matched) {
            //only one combination per group per symbol
            if (covered.add(matchingResult.symbol() + ":" + matchingResult.group())) {
                winningCombinations.computeIfAbsent(matchingResult.symbol(), k -> new ArrayList<>())
                        .add(matchingResult.combination());

                rewardMultipliers.compute(matchingResult.symbol(),
                        (k, v) -> v == null ? matchingResult.rewardMultiplier() : v.multiply(matchingResult.rewardMultiplier()));
            }
        }
    }

    private BigDecimal applyBasicSymbols(Map<String, BigDecimal> rewardMultipliers, BigDecimal reward) {
        BigDecimal rewardMultiplier = rewardMultipliers.entrySet().stream()
                .map(e -> config.symbols().get(e.getKey()).rewardMultiplier().multiply(e.getValue()))
                .reduce(BigDecimal::add)
                .orElse(ZERO);  //should never happen

        assert rewardMultiplier.signum() > 0;

        return reward.multiply(rewardMultiplier);
    }

    private BigDecimal applyBonusSymbol(String bonusSymbol, BigDecimal reward) {
        if (bonusSymbol != null) {
            Symbol bonus = config.symbols().get(bonusSymbol);
            switch (bonus.impact()) {
                case MULTIPLY_REWARD:
                    return reward.multiply(bonus.rewardMultiplier());
                case EXTRA_BONUS:
                    return reward.add(bonus.extra());
                case MISS: //no impact
            }
        }
        return reward;
    }

}
