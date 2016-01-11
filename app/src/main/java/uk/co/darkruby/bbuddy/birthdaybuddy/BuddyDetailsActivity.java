package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.app.ActionBar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;

public class BuddyDetailsActivity extends AppCompatActivity {
    //http://manishkpr.webheavens.com/android-viewpager-example/

    private BuddyModel buddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_details);

        this.buddy = (BuddyModel) getIntent().getSerializableExtra(MainActivity.BUDDY);

        ViewPager pager = (ViewPager) findViewById(R.id.detailsPager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), getProviders());

        pager.setAdapter(adapter);

        getSupportActionBar().setTitle("How old is " + this.buddy.name + "?");
    }

    ArrayList<BirthdayDataProvider> getProviders() {
        final BuddyModel buddy = this.buddy;

        ArrayList<BirthdayDataProvider> providers = new ArrayList() {
            {
                add(new MarsDataProvider(buddy));
                add(new MoonDataProvider(buddy));
                add(new VenusDataProvider(buddy));
                add(new CatDataProvider(buddy));
                add(new DogDataProvider(buddy));
            }
        };

        return providers;
    }
}
