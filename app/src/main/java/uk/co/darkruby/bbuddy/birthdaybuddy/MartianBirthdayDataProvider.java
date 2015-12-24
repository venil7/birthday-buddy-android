package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MartianBirthdayDataProvider extends BirthdayDataProviderBase {
    public MartianBirthdayDataProvider(BuddyModel buddy) {
        super(buddy);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.martian_data, container, false);
    }
}
