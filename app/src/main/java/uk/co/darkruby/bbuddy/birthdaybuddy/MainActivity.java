package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final int ADD_PERSON = 1;
    private final String BUDDIES_KEY = "buddies";
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefEditor;
    private Gson gson;
    private ArrayList<BuddyModel> buddiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.prefs = getPreferences(MODE_PRIVATE);
        this.prefEditor = this.prefs.edit();
        this.gson = new Gson();

        this.initializeBuddiesList();

        Log.d("MainActivity", "item count" + this.buddiesList.size());

        ListView listView = (ListView) findViewById(R.id.main_list);
        BuddyListAdapter adapter = new BuddyListAdapter(MainActivity.this, R.layout.buddy_list_item, this.buddiesList);
        listView.setAdapter(adapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_PERSON) {
            if (resultCode == RESULT_OK) {
                BuddyModel buddy = (BuddyModel) data.getSerializableExtra("buddy");
                MainActivity.this.addToBuddiesList(buddy);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeBuddiesList() {
        this.buddiesList = new ArrayList<>();
        String buddiesListString = this.prefs.getString(BUDDIES_KEY, this.gson.toJson(this.buddiesList));
        Type type = new TypeToken<ArrayList<BuddyModel>>(){}.getType();
        ArrayList<BuddyModel> items = this.gson.fromJson(buddiesListString, type);
        this.buddiesList.addAll(items);
    }

    private void addToBuddiesList(BuddyModel buddy, boolean persist) {
        this.buddiesList.add(buddy);
        if (persist) {
            this.persistBuddiesList();
        }
    }

    private void persistBuddiesList() {
        this.prefEditor
            .putString(BUDDIES_KEY, this.gson.toJson(this.buddiesList))
            .apply();
    }

    private void addToBuddiesList(BuddyModel buddy) {
        this.addToBuddiesList(buddy, true);
    }

    public void onBuddyAddClick(View view) {
        Intent addPersonIntent = new Intent(this, AddPersonActivity.class);
        this.startActivityForResult(addPersonIntent, ADD_PERSON);
    }

    public void onBuddyItemClick(View view) {
        Intent buddyDetailsIntent = new Intent(this, BuddyDetailsActivity.class);
        this.startActivity(buddyDetailsIntent);
    }
}
