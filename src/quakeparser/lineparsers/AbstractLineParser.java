/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.lineparsers;

import quakeparser.contracts.ILine;

/**
 *
 * @author rulrok
 */
public abstract class AbstractLineParser {

    protected AbstractLineParser successor;

    public void setSuccessor(AbstractLineParser successor) {
        this.successor = successor;
    }

    abstract public ILine processLine(ILine line);
}
