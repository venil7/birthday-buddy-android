package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.darkruby.bbuddy.birthdaybuddy.databinding.MartianDataBinding;

public class MarsDataProvider extends BirthdayDataProviderBase {
    private final int YEAR_LENGTH = 687;
    private final double SOLS_PER_DAY = 0.973244296714;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.martian_data, container, false);
        MartianDataBinding binding = DataBindingUtil.bind(view);
        binding.setData(this);
        return view;
    }

    public int getMartianYears() {
        int days = this.getDaysTillNow();
        return days / YEAR_LENGTH;
    }

    public int getMartianSols() {
        return (int) Math.round(this.getDaysTillNow() * SOLS_PER_DAY);
    }

    @Override
    public String getMessage() {
        return String.format("%d Sols, that is %d Mars years", this.getMartianSols(), this.getMartianYears());
    }
}
