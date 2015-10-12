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
public class KillParser extends AbstractLineParser {

    @Override
    public ILine processLine(ILine line) {
        if (line.event().equals(Event.Kill)) {
            String rawLine = line.rawLine().trim();

            String[] split = rawLine.split(" +");

            line.setSubject(split[2]);
            line.setDirectObject(split[3]);
            //The last number has a ':' together with it
            line.setIndirectObject(split[4].split(":", 2)[0]);

            return line;

        } else if (successor != null) {
            return successor.processLine(line);
        } else {
            //return defaul unknown event
            return LogLine.unknownEvent();
        }
    }

}
