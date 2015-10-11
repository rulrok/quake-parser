/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.contracts;

import java.util.Date;
import quakeparser.Event;

/**
 *
 * @author rulrok
 */
public interface ILine {
    
    
    public Date time();
    
    public Event event();
    
    public String eventSubject();
    
    public String eventDirectObject();
    
    public String eventIndirectObject();

}
