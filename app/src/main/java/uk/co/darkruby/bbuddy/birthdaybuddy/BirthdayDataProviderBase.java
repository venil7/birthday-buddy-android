package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.support.v4.app.Fragment;

public abstract class BirthdayDataProviderBase
        extends Fragment
        implements BirthdayDataProvider {

    protected BuddyModel buddy;

    public BirthdayDataProviderBase(BuddyModel buddy) {
        super();
        this.buddy = buddy;
    }

    @Override
    public Fragment getFragment() {
        return this;
    }
}
