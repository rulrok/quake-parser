/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

/**
 *
 * @author rulrok
 */
public enum Event {
    
    Item,
    Kill,
    
    InitGame,
    ShutdownGame,
    Exit,
    
    ClientConnect,
    ClientDisconect,
    ClientUserinfoChanged,
    ClientBegin,
    
}