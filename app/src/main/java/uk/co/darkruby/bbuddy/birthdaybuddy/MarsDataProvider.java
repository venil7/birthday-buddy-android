package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MarsDataProvider extends BirthdayDataProviderBase {
    private final int YEAR_LENGTH = 687;
    private final double SOLS_PER_DAY = 0.973244296714;

    public MarsDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.martian_data, container, false);
    }

    public int getMartianYears() {
        int days = this.getDaysTillNow();
        return days / YEAR_LENGTH;
    }

    public double getMartianSols() {
        return this.getDaysTillNow() * SOLS_PER_DAY;
    }
}
