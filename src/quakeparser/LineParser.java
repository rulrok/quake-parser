/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.contracts.ILine;
import quakeparser.lineparsers.*;

/**
 *
 * @author rulrok
 */
public class LineParser {

    public static ILine parseLine(String line) {

        ILine partialLine = LineParser.basicParse(line);

        /*
         * Chain of responsability pattern
         */
        ClientBeginParser beginParser = new ClientBeginParser();
        ClientConnectParser clientConnectParser = new ClientConnectParser();
        ClientDisconnectParser clientDisconnectParser = new ClientDisconnectParser();
        ClientInfoChangedParser clientInfoChangedParser = new ClientInfoChangedParser();
        InitGameParser initGameParser = new InitGameParser();
        ShutdownGameParser shutdownGameParser = new ShutdownGameParser();
        ExitParser exitParser = new ExitParser();
        ItemParser itemParser = new ItemParser();
        KillParser killParser = new KillParser();

        beginParser.setSuccessor(clientConnectParser);
        clientConnectParser.setSuccessor(clientDisconnectParser);
        clientDisconnectParser.setSuccessor(clientInfoChangedParser);
        clientInfoChangedParser.setSuccessor(initGameParser);
        initGameParser.setSuccessor(shutdownGameParser);
        shutdownGameParser.setSuccessor(exitParser);
        exitParser.setSuccessor(itemParser);
        itemParser.setSuccessor(killParser);

        return beginParser.processLine(partialLine);

    }

    static ILine basicParse(String line) {
        return null;
    }

}
