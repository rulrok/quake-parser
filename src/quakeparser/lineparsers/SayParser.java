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
public class SayParser extends AbstractLineParser {

    @Override
    public ILine processLine(ILine line) {
        if (line.event().equals(Event.say)) {
            String rawLine = line.rawLine();

            String[] split = rawLine.split(" +", 3);

            String[] contents = split[2].split(":");

            String subject = contents[0];
            String indirectObject = contents[1].trim();

            line.setSubject(subject);
            line.setIndirectObject(indirectObject);

            return line;

        } else if (successor != null) {
            return successor.processLine(line);
        } else {
            //return defaul unknown event
            return LogLine.unknownEvent();
        }
    }

}
