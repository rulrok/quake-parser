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
public interface IGame {

    public int totalKills();

    public String[] players();

    public String[] kills();
}
