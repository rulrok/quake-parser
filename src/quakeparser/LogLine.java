/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.contracts.IDate;
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class LogLine implements ILine {

    private final IDate time;
    private final Event event;
    private String subject;
    private String directObject;
    private String indirectObject;

    public LogLine(IDate time, Event event) {
        this.time = time;
        this.event = event;
    }

    public LogLine(IDate time, Event event, String subject, String directObject, String indirectObject) {

        this(time, event);
        this.subject = subject;
        this.directObject = directObject;
        this.indirectObject = indirectObject;

    }

    @Override
    public IDate time() {
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
