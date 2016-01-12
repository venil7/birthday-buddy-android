package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.darkruby.bbuddy.birthdaybuddy.databinding.MoonDataBinding;

public class MoonDataProvider extends BirthdayDataProviderBase {
    private final int YEAR_LENGTH = 29;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moon_data, container, false);
        MoonDataBinding binding = DataBindingUtil.bind(view);
        binding.setData(this);
        return view;
    }

    public int getMoonYears() {
        int days = this.getDaysTillNow();
        return days / YEAR_LENGTH;
    }

    @Override
    public String getMessage() {
        int years = this.getMoonYears();
        return String.format("%d Lunar months, same as %d Lunar years", years, years);
    }
}
