package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MoonDataProvider extends BirthdayDataProviderBase {
    private final int YEAR_LENGTH = 29;

    public MoonDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.moon_data, container, false);
    }

    public int getMoonYears() {
        int days = this.getDaysTillNow();
        return days / YEAR_LENGTH;
    }
}
