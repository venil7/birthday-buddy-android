package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.nfc.FormatException;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BuddyModel implements Serializable {
    public String name;
    public Date birthdate;

    public BuddyModel(String name, String birthdate) throws FormatException {
        if (name.trim() == "") {
            throw new FormatException();
        }
        this.name = name;
        Date date = this.convertFromString(birthdate);
        if (date != null) {
            this.birthdate = date;
        } else throw new FormatException();
    }

    private Date convertFromString(String birthdate) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);

        try {
            date = format.parse(birthdate);
        } catch (ParseException exception) {
            ;
        }
        return date;
    }

    @Override
    public String toString() {
        return this.name;// + " - " + this.birthdate.toString();
    }
}
