package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CatDataProvider
        extends BirthdayDataProviderBase
        implements BirthdayDataProvider {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cat_data, container, false);
    }

    public CatDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    public int getCatYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        int catYears = ((fullYears >= 25)
                ? ((fullYears - 25) / 4 + 2)
                : (fullYears > 15 ? (fullYears - 15) / 10 + 1 : fullYears / 15));

        return catYears;
    }
}
