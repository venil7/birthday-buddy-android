package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DogDataProvider
        extends BirthdayDataProviderBase
        implements BirthdayDataProvider {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dog_data, container, false);
    }

    public DogDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    public int getDogYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        double dogYears = (fullYears >= 21)
            ? (fullYears - 21)/4 + 2
            : fullYears/10.5;

        return ((int) dogYears);
    }
}
