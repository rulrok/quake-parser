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
public class ClientInfoChangedParser extends AbstractLineParser {

    @Override
    public ILine processLine(ILine line) {
        if (line.event().equals(Event.ClientUserinfoChanged)) {
            String rawLine = line.rawLine();

            String[] split = rawLine.split("\\s+");

            line.setSubject(split[2]);

            String info = split[3];

            String[] details = info.split("\\\\");

            for (int i = 0; i < details.length; i++) {
                String detail = details[i];

                switch (detail) {
                    case "n":
                        line.setIndirectObject(details[i + 1]);
                        i++;
                        break;
                }

            }

            return line;
        } else if (successor != null) {
            return successor.processLine(line);
        } else {
            //return defaul unknown event
            return LogLine.unknownEvent();
        }
    }

}
