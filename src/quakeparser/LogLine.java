/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import java.util.Objects;
import quakeparser.contracts.IDate;
import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public class LogLine implements ILine {

    private final IDate time;
    private final Event event;
    private String subject = "";
    private String directObject = "";
    private String indirectObject = "";

    private String rawLine = "";

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

    public static ILine unknownEvent() {
        return new LogLine(new Date(), Event.UNKNOWN);
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

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setDirectObject(String directObject) {
        this.directObject = directObject;
    }

    @Override
    public void setIndirectObject(String indirectObject) {
        this.indirectObject = indirectObject;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ILine)) {
            return false;
        }

        ILine objLine = (ILine) obj;

        if (!objLine.time().equals(this.time)) {
            return false;
        }

        if (!objLine.event().equals(this.event)) {
            return false;
        }

        if (!objLine.eventSubject().equals(this.subject)) {
            return false;
        }

        if (!objLine.eventDirectObject().equals(this.directObject)) {
            return false;
        }

        if (!objLine.eventIndirectObject().equals(this.indirectObject)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.time);
        hash = 97 * hash + Objects.hashCode(this.event);
        hash = 97 * hash + Objects.hashCode(this.subject);
        hash = 97 * hash + Objects.hashCode(this.directObject);
        hash = 97 * hash + Objects.hashCode(this.indirectObject);
        return hash;
    }

    @Override
    public String rawLine() {
        return rawLine.trim();
    }

    @Override
    public void setRawLine(String rawLine) {
        this.rawLine = rawLine;
    }

}
