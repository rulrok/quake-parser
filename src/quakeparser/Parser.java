/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import quakeparser.contracts.IGame;
import quakeparser.contracts.IParser;
import quakeparser.exceptions.ParserNotInitialized;

/**
 *
 * @author rulrok
 */
public class Parser implements IParser {

    private boolean initiated = false;

    private File oLog;
    private List<String> lines;

    @Override
    public void readLog(File log) throws FileNotFoundException {
        this.oLog = log;
        this.lines = new ArrayList<>();

        Scanner reader = new Scanner(this.oLog);

        while (reader.hasNextLine()) {
            this.lines.add(reader.nextLine());
        }

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
