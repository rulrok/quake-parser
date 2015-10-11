/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.contracts;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import quakeparser.exceptions.ParserNotInitialized;

/**
 *
 * @author rulrok
 */
public interface IParser {

    public void readLog(File log) throws FileNotFoundException;

    public List<? extends IGame> games() throws ParserNotInitialized;

}
