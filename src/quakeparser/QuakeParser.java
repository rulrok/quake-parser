/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.lineparsers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import quakeparser.contracts.IGame;
import quakeparser.contracts.ILine;
import quakeparser.contracts.IParser;

/**
 *
 * @author rulrok
 */
public class QuakeParser implements IParser {

    private boolean parsed = false;

    private final LogFile log;
    private IGame actualGame;

    private final List<? super IGame> games;

    public QuakeParser(LogFile log) {
        this.games = new ArrayList<>();
        this.log = log;
    }

    @Override
    public List<? super IGame> games() {

        if (!this.parsed) {
            _parse();
        }

        return games;
    }

    private void _parse() {

        _configureNewGame();

        for (String rawLine : log) {
            ILine line = LineParser.parseLine(rawLine);

            actualGame.addEvent(line);

            if (actualGame.isFinished()) {
                _configureNewGame();
            }

        }

        parsed = true;

    }

    private void _configureNewGame() {
        if (actualGame != null) {
            games.add(actualGame);
        }
        actualGame = new Game();
    }

    @Override
    public String results() {

        if (!this.parsed) {
            _parse();
        }

        StringBuilder result = new StringBuilder();

        int gameCount = 1;
        for (Iterator<? super IGame> it = games.iterator(); it.hasNext();) {
            IGame game = (IGame) it.next();

            //Total kills
            result.append("game_").append(gameCount).append(": {\n");
            result.append("\ttotal_kills: ").append(game.totalKills()).append(";\n");

            //Players
            result.append("\tplayers: [");
            for (String playerName : game.players()) {
                result.append('"').append(playerName).append('"').append(',');
            }
            result.deleteCharAt(result.lastIndexOf(","));
            result.append("]\n");
            result.append("\tkills: {\n");

            //Kills
            for (String killLine : game.kills()) {
                result.append("\t\t").append(killLine).append(",\n");
            }
            result.deleteCharAt(result.lastIndexOf(","));
            result.append("\t}\n");

            //Kills by means
            result.append("\tkills_by_means: {\n");
            Map<MeansOfDeath, Integer> killsByMeans = game.killsByMeans();
            for (Map.Entry<MeansOfDeath, Integer> entrySet : killsByMeans.entrySet()) {
                MeansOfDeath key = entrySet.getKey();
                Integer value = entrySet.getValue();

                result.append("\t\t\"").append(key).append("\": ").append(value).append(",\n");
            }

            result.append("\t}\n");

            result.append("}\n\n");

            gameCount++;

        }

        return result.toString();

    }

}
