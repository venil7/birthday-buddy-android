package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.darkruby.bbuddy.birthdaybuddy.databinding.VenusDataBinding;

public class VenusDataProvider extends BirthdayDataProviderBase {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.venus_data, container, false);
        VenusDataBinding binding = DataBindingUtil.bind(view);
        binding.setData(this);
        return view;
    }

    private final int YEAR_LENGTH = 225;
    private final int DAY_LENGTH = 243;

    public int getVenetianYears() {
        return this.getDaysTillNow() / YEAR_LENGTH;
    }

    public int getVenetianDays() {
        return this.getDaysTillNow() / DAY_LENGTH;
    }

    @Override
    public String getMessage() {
        return String.format("%d Venetian days or %d Venetian years", this.getVenetianDays(), this.getVenetianYears());
    }
}