package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        //add button handler
        final Button addButton = (Button) findViewById(R.id.addbtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText name = (EditText) findViewById(R.id.name);
                final DatePicker birthdate = (DatePicker) findViewById(R.id.birthdate);
                final GregorianCalendar date = AddPerson.getDateFromDatePicker(birthdate);
                final BuddyModel buddy = new BuddyModel(name.getText().toString(), date);
                Toast.makeText(AddPerson.this, buddy.toString(), Toast.LENGTH_SHORT).show();
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
