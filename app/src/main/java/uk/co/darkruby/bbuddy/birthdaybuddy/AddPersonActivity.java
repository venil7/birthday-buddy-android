package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        //add button handler
        final Button addButton = (Button) findViewById(R.id.addbtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BuddyModel buddy = null;
                try {
                    final EditText name = (EditText) findViewById(R.id.name);
                    final EditText date = (EditText) findViewById(R.id.birthdate);
                    buddy = new BuddyModel(name.getText().toString(), date.getText().toString());
                    Toast.makeText(AddPersonActivity.this, buddy.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (FormatException exception) {
                    Toast.makeText(AddPersonActivity.this, "name or date of birth missing", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static GregorianCalendar getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return new GregorianCalendar(year, month, day);
    }
}
