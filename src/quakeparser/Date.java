/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quakeparser;

import quakeparser.contracts.IDate;

/**
 *
 * @author rulrok
 */
public class Date implements IDate {

    private final int hours;
    private final int minutes;

    public Date(int hours, int minutes) {
        this.hours = hours % 24;
        this.minutes = minutes % 60;
    }

    @Override
    public int hours() {
        return hours;
    }

    @Override
    public int minutes() {
        return minutes;
    }

    @Override
    public boolean after(IDate date) {
        if (hours == date.hours()) {
            return minutes < date.minutes();
        }

        return hours < date.hours();
    }

    @Override
    public boolean before(IDate date) {

        if (hours == date.hours()) {
            return minutes > date.minutes();
        }

        return hours > date.hours();
    }

}
