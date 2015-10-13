/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.lineparsers;

import quakeparser.Event;
import quakeparser.LogLine;
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class ScoreParser extends AbstractLineParser {

    @Override
    public ILine processLine(ILine line) {
        if (line.event().equals(Event.score)) {
            String rawLine = line.rawLine().trim();

            String[] split = rawLine.split(" +");

            String score = split[2];
            String ping = split[4];
            String playerID = split[6];

            line.setSubject(playerID);
            line.setDirectObject(score);
            line.setIndirectObject(ping);

            return line;

        } else if (successor != null) {
            return successor.processLine(line);
        } else {
            //return defaul unknown event
            return LogLine.unknownEvent();
        }
    }

}
