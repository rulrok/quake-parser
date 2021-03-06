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
public class ItemParser extends AbstractLineParser {

    @Override
    public ILine processLine(ILine line) {
        if (line.event().equals(Event.Item)) {
            String rawLine = line.rawLine();

            String[] split = rawLine.split("\\s+");

            line.setSubject(split[2]);
            line.setIndirectObject(split[3]);

            return line;
        } else if (successor != null) {
            return successor.processLine(line);
        } else {
            //return defaul unknown event
            return LogLine.unknownEvent();
        }
    }

}
