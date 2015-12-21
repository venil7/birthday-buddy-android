package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<BirthdayDataProvider> providers;

    public PagerAdapter(FragmentManager fm, ArrayList<BirthdayDataProvider> providers) {
        super(fm);
        this.providers = providers;
    }

    @Override
    public Fragment getItem(int position) {
        BirthdayDataProvider provider = this.providers.get(position);
        Fragment fragment = provider.getFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return this.providers.size();
    }
}
