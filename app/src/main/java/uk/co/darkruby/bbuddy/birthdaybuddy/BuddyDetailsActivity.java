package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BuddyDetailsActivity extends AppCompatActivity {

    private BuddyModel buddy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_details);

        this.buddy = (BuddyModel) getIntent().getSerializableExtra(MainActivity.BUDDY);

        TextView tv = (TextView) findViewById(R.id.detailsText);
        tv.setText(this.buddy.name);
    }
}
