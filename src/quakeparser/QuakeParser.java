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

    private Log log;
    private IGame actualGame;

    private final List<? extends IGame> games;

    public QuakeParser() {
        games = new ArrayList<>();
    }

    @Override
    public void readLog(Log log) throws FileNotFoundException {
        this.log = log;
        this.initialized = true;
    }

    @Override
    public List<? extends IGame> games() throws ParserNotInitialized {

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

        /*
         * Chain of responsability pattern
         */
        ClientBeginParser beginParser = new ClientBeginParser();
        ClientConnectParser clientConnectParser = new ClientConnectParser();
        ClientDisconnectParser clientDisconnectParser = new ClientDisconnectParser();
        ClientInfoChangedParser clientInfoChangedParser = new ClientInfoChangedParser();

        beginParser.setSuccessor(clientConnectParser);
        clientConnectParser.setSuccessor(clientDisconnectParser);
        clientDisconnectParser.setSuccessor(clientInfoChangedParser);

        for (String s : log) {
            ILine line = LineParser.parseLine(s);

            beginParser.processLine(line);

            actualGame.addEvent(line);
            
            if (actualGame.isFinished()) {
                _configureNewGame();
            }

        }

        parsed = true;

    }

    private void _configureNewGame() {
        actualGame = new Game();
    }

}
