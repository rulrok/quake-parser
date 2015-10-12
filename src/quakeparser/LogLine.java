/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.util.Date;
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class LogLine implements ILine {

    private final Date time;
    private final Event event;
    private final String subject;
    private final String directObject;
    private final String indirectObject;

    private final String rawLine;

    boolean parsed = false;

    public LogLine(String rawLine) {
        this.rawLine = rawLine;

        ILine parsedLine = LineParser.parseLine(rawLine);

        this.time = parsedLine.time();
        this.event = parsedLine.event();
        this.subject = parsedLine.eventSubject();
        this.directObject = parsedLine.eventDirectObject();
        this.indirectObject = parsedLine.eventIndirectObject();

    }

    @Override
    public Date time() {
        return time;
    }

    @Override
    public Event event() {
        return event;
    }

    @Override
    public String eventSubject() {
        return subject;
    }

    @Override
    public String eventDirectObject() {
        return directObject;
    }

    @Override
    public String eventIndirectObject() {
        return indirectObject;
    }

}
