/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.lineparsers.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import quakeparser.contracts.IGame;
import quakeparser.contracts.ILine;
import quakeparser.contracts.IParser;
import quakeparser.exceptions.ParserNotInitialized;

/**
 *
 * @author rulrok
 */
public class QuakeParser implements IParser {

    private boolean initialized = false;
    private boolean parsed = false;

    private LogFile log;
    private IGame actualGame;

    private final List<? super IGame> games;

    public QuakeParser() {
        games = new ArrayList<>();
    }

    @Override
    public void readLog(LogFile log) throws FileNotFoundException {
        this.log = log;
        this.initialized = true;
    }

    @Override
    public List<? super IGame> games() throws ParserNotInitialized {

        if (!this.initialized) {
            throw new ParserNotInitialized("You must initialize the parser first");
        }

        if (!this.parsed) {
            _parse();
        }

        return games;
    }

    boolean isInitialized() {
        return this.initialized;
    }

    private void _parse() {

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
        games.add(actualGame);
        actualGame = new Game();
    }

}
