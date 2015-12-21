package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.support.v4.app.Fragment;

public abstract class BirthdayDataProviderBase
        extends Fragment
        implements BirthdayDataProvider {

    public BirthdayDataProviderBase() {
        super();
    }

    @Override
    public Fragment getFragment() {
        return this;
    }
}
