package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.app.Activity;
import android.content.Intent;
import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBuddyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_buddy);
    }

    public void onAddClick(View view) {
        BuddyModel buddy = null;
        try {
            final EditText name = (EditText) findViewById(R.id.name);
            final EditText date = (EditText) findViewById(R.id.birthdate);
            buddy = new BuddyModel(name.getText().toString(), date.getText().toString());
            Intent resultData = new Intent();
            resultData.putExtra(MainActivity.BUDDY, buddy);
            setResult(Activity.RESULT_OK, resultData);
            finish();
        }
        catch (FormatException exception) {
            Toast.makeText(AddBuddyActivity.this, "name or date of birth missing", Toast.LENGTH_SHORT).show();
        }
    }
}
