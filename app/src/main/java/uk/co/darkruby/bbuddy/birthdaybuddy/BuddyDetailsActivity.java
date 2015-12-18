package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BuddyDetailsActivity extends AppCompatActivity {
    //http://manishkpr.webheavens.com/android-viewpager-example/

    private BuddyModel buddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_details);

        this.buddy = (BuddyModel) getIntent().getSerializableExtra(MainActivity.BUDDY);

        ViewPager pager = (ViewPager) findViewById(R.id.detailsPager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
    }
}
