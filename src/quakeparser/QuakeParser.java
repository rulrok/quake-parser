/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.lineparsers.*;
import java.util.ArrayList;
import java.util.List;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
