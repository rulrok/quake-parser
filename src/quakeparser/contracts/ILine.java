/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.contracts;

import quakeparser.Event;

/**
 *
 * @author rulrok
 */
public interface ILine {

    public IDate time();

    public Event event();

    public String eventSubject();

    public void setSubject(String subject);

    public String eventDirectObject();

    public void setDirectObject(String object);

    public String eventIndirectObject();

    public void setIndirectObject(String indirectObject);

    public String rawLine();

    public void setRawLine(String rawLine);

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
}
