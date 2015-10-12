/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.contracts.ILine;
import quakeparser.lineparsers.ClientBeginParser;
import quakeparser.lineparsers.ClientConnectParser;
import quakeparser.lineparsers.ClientDisconnectParser;
import quakeparser.lineparsers.ClientInfoChangedParser;

/**
 *
 * @author rulrok
 */
public class LineParser {

    static ILine parseLine(String line) {

        ILine partialLine = LineParser.basicParse(line);

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

        return beginParser.processLine(partialLine);

    }

    private static ILine basicParse(String line) {
        return null;
    }

}
