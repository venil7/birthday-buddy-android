package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.support.v4.app.Fragment;

import org.joda.time.DateTime;
import org.joda.time.Days;

public abstract class BirthdayDataProviderBase
        extends Fragment
        implements BirthdayDataProvider {

    protected final int DAYS_IN_YEAR = 365;

    protected BuddyModel buddy;
    protected DateTime now, then;

    protected int getDaysTillNow() {
        return Days.daysBetween(then, now).getDays();
    }

    public BirthdayDataProviderBase(BuddyModel buddy) {
        super();
        this.buddy = buddy;
        this.now = new DateTime();
        this.then = new DateTime(this.buddy.birthdate);
    }

    @Override
    public Fragment getFragment() {
        return this;
    }
}
