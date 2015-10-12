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

        String[] split = line.trim().split(" +");

        String[] time = split[0].split(":");

        String[] reason = new String[2];
        if (!split[1].matches("\\w+:")) {
            reason[0] = "UNKNOWN";
        } else {
            reason = split[1].split(":", 2);
        }

        ILine logLine = new LogLine(
                new Date(Integer.parseInt(time[0]), Integer.parseInt(time[1])),
                Event.valueOf(reason[0])
        );
        
        logLine.setRawLine(line);

        return logLine;
    }

}
