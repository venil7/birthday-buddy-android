package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.darkruby.bbuddy.birthdaybuddy.databinding.DogDataBinding;

public class DogDataProvider extends BirthdayDataProviderBase {

    public DogDataProvider() {
        super();
    }

    public DogDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dog_data, container, false);
        DogDataBinding binding = DataBindingUtil.bind(view);
        binding.setData(this);
        return view;
    }

    public int getDogYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        double dogYears = (fullYears >= 21)
            ? (fullYears - 21)/4 + 2
            : fullYears/10.5;

        return ((int) dogYears);
    }

    public int getHumanDogYears() {
        int fullYears = this.getDaysTillNow() / DAYS_IN_YEAR;
        if (fullYears > 0) {
            return 21 + ((fullYears - 2) * 4);
        }

        return (int)(fullYears * 10.5);
    }

    @Override
    public String getMessage() {
        return String.format("%d Dog years, %d Human-Dog years", this.getDogYears(), this.getHumanDogYears());
    }
}
