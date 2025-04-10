package com.interview.mygameboardscratcher.gamecomponent;

import java.math.BigDecimal;
import java.util.Random;

import com.interview.mygameboardscratcher.config.CellDistribution;
import com.interview.mygameboardscratcher.config.Config;

import static java.math.BigDecimal.ZERO;

/**
 * @author SURESH S
 * Date: 10.04.2025
 */
public class Scratch {
    private final Config config;

    public Scratch(Config config) {
        this.config = config;
    }

    public GameBoard scratch(BigDecimal bet) {
        return new GameBoardAnalyzer(config).analyze(distribute(), bet);
    }

    private GameBoard distribute() {
        boolean isBonus = config.probabilities().bonusSymbols() != null;
        String[][] board = new String[config.rows()][config.columns()];
        String bonusSymbol = null;
        for (CellDistribution cellDistribution : config.probabilities().standardSymbols()) {
            if (isBonus && new Random().nextBoolean()) {    //once or never (but once is almost guaranteed)
                bonusSymbol = new Distribution(config.probabilities().bonusSymbols()).next();   //save one look across the board
                board[cellDistribution.row()][cellDistribution.column()] = bonusSymbol;
                isBonus = false;
            } else {
                board[cellDistribution.row()][cellDistribution.column()] = new Distribution(cellDistribution).next();
            }
        }
        return new GameBoard(board, ZERO, null, bonusSymbol);
    }

}
