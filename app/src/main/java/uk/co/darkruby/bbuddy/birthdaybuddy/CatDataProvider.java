package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.darkruby.bbuddy.birthdaybuddy.databinding.CatDataBinding;

public class CatDataProvider
        extends BirthdayDataProviderBase {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cat_data, container, false);
        CatDataBinding binding = DataBindingUtil.bind(view);
        binding.setData(this);
        return view;
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

    public int getHumanDogYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        return ((fullYears >= 25) ?
                ((fullYears - 25) / 4 + 2)
                : (fullYears > 15
                    ? (fullYears - 15) / 10 + 1
                    : fullYears / 15));
    }

    @Override
    public String getMessage() {
        return String.format("%d Cat years", this.getCatYears());
    }
}
