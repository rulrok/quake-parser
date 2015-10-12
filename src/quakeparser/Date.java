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
            return minutes > date.minutes();
        }

        return hours > date.hours();
    }

    @Override
    public boolean before(IDate date) {

        if (hours == date.hours()) {
            return minutes < date.minutes();
        }

        return hours < date.hours();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof IDate)) {
            return false;
        }

        IDate objDate = (IDate) obj;

        if (objDate.hours() != this.hours) {
            return false;
        }

        if (objDate.minutes() != this.minutes) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.hours;
        hash = 17 * hash + this.minutes;
        return hash;
    }

}
