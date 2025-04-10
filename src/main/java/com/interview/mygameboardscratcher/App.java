package com.interview.mygameboardscratcher;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.interview.mygameboardscratcher.config.Config;
import com.interview.mygameboardscratcher.gamecomponent.GameBoard;
import com.interview.mygameboardscratcher.gamecomponent.Scratch;
import com.interview.mygameboardscratcher.helpers.Params;

import java.io.File;
import java.io.IOException;

/**
 * @author SURESH S
 * Date: 10.04.2025
 */
public class App {
    public static void main(String[] args) throws IOException {
        Params params = new Params();
        if (params.init(args)) {
            ObjectMapper objectMapper = JsonMapper.builder()
                    .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                    .build();
            Config config = objectMapper.readValue(new File(params.getConfigPath()), Config.class);

            GameBoard output = new Scratch(config).scratch(params.getBettingAmount());

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(System.out, output);
        }
    }
}
