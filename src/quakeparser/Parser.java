/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.io.FileNotFoundException;
import java.util.List;
import quakeparser.contracts.IGame;
import quakeparser.contracts.IParser;
import quakeparser.exceptions.ParserNotInitialized;

/**
 *
 * @author rulrok
 */
public class Parser implements IParser {

    private boolean initiated = false;

    private Log log;

    @Override
    public void readLog(Log log) throws FileNotFoundException {
        this.log = log;
        this.initiated = true;
    }

    @Override
    public List<? extends IGame> games() throws ParserNotInitialized {

        if (!this.initiated) {
            throw new ParserNotInitialized("You must initialize the parser first");
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
