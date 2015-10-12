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
public class InitGameParser extends AbstractLineParser {

    @Override
    public ILine processLine(ILine line) {
        if (line.event().equals(Event.InitGame)) {
            String rawLine = line.rawLine();

            String[] split = rawLine.split("\\s+", 3);

            line.setSubject(split[2]);

            return line;
        } else if (successor != null) {
            return successor.processLine(line);
        } else {
            //return defaul unknown event
            return LogLine.unknownEvent();
        }
    }

}
