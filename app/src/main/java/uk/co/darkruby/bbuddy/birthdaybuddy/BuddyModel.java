package uk.co.darkruby.bbuddy.birthdaybuddy;

import java.util.GregorianCalendar;

/**
 * Created by darkruby on 06/12/15.
 */
public class BuddyModel {
    String _name;
    GregorianCalendar _birthdate;

    public BuddyModel(String name, GregorianCalendar birthdate) {
        this._name = name;
        this._birthdate = birthdate;
    }

    public String getName() {
        return this._name;
    }

    public GregorianCalendar getBirthdate() {
        return this._birthdate;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this._birthdate.toString();
    }
}
