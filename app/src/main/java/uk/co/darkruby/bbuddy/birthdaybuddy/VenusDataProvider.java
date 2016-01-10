package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VenusDataProvider
        extends BirthdayDataProviderBase
        implements BirthdayDataProvider {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.venus_data, container, false);
    }

    private final int YEAR_LENGTH = 225;
    private final int DAY_LENGTH = 243;

    public VenusDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    public int getVenetianYears() {
        return this.getDaysTillNow() / YEAR_LENGTH;
    }

    public int getVenetianDays() {
        return this.getDaysTillNow() / DAY_LENGTH;
    }
}