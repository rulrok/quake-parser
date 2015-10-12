/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser.contracts;

/**
 *
 * @author rulrok
 */
public interface IDate {

    public int hours();

    public int minutes();

    public boolean after(IDate date);

    public boolean before(IDate date);

}
