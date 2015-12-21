package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.database.Cursor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    public static final String BUDDY = "buddy";

    private final int ADD_PERSON = 1;
    private final String BUDDIES_KEY = "buddies";
    private SharedPreferences prefs;
    private SharedPreferences.Editor prefEditor;
    private Gson gson;
    private ArrayList<BuddyModel> buddiesList;
    private BuddyListAdapter adapter;

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

        this.adapter = new BuddyListAdapter(MainActivity.this, R.layout.buddy_list_item, this.buddiesList);

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(this.adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_PERSON) {
            if (resultCode == RESULT_OK) {
                BuddyModel buddy = (BuddyModel) data.getSerializableExtra(BUDDY);
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
        int id = item.getItemId();

        switch(id) {
            case R.id.action_settings: {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.action_import_contacts: {
                Toast.makeText(this, "Import", Toast.LENGTH_SHORT).show();
                this.importContactsBirthdays();
                return  true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }

    }

    private void  importContactsBirthdays() {
        Uri uri = ContactsContract.Data.CONTENT_URI;

        String[] projection = new String[] {
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Event.CONTACT_ID,
                ContactsContract.CommonDataKinds.Event.START_DATE
        };

        String where =
                ContactsContract.Data.MIMETYPE + "= ? AND " +
                        ContactsContract.CommonDataKinds.Event.TYPE + "=" +
                        ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY;
        String[] selectionArgs = new String[] {
                ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE
        };
        String sortOrder = null;
        Cursor cursor =  managedQuery(uri, projection, where, selectionArgs, sortOrder);
        int bDayColumn = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE);
        while (cursor.moveToNext()) {
            String bDay = cursor.getString(bDayColumn);
            Log.d("MainActivity", "Birthday: " + bDay);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void initializeBuddiesList() {
        this.buddiesList = new ArrayList<>();
        String buddiesListString = this.prefs.getString(BUDDIES_KEY, this.gson.toJson(this.buddiesList));
        Type type = new TypeToken<ArrayList<BuddyModel>>() {
        }.getType();
        ArrayList<BuddyModel> items = this.gson.fromJson(buddiesListString, type);
        this.buddiesList.addAll(items);
    }

    private void addToBuddiesList(BuddyModel buddy, boolean persist) {
        this.buddiesList.add(buddy);
        this.adapter.notifyDataSetChanged();

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
        Intent addPersonIntent = new Intent(this, AddBuddyActivity.class);
        this.startActivityForResult(addPersonIntent, ADD_PERSON);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent buddyDetailsIntent = new Intent(this, BuddyDetailsActivity.class);
        buddyDetailsIntent.putExtra(BUDDY, this.buddiesList.get(position));
        this.startActivity(buddyDetailsIntent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        new AlertDialog.Builder(this)
            .setTitle(R.string.delete_title)
            .setMessage(R.string.delete_buddy_confirm)
            .setIcon(android.R.drawable.ic_delete)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    MainActivity.this.buddiesList.remove(position);
                    MainActivity.this.adapter.notifyDataSetChanged();
                    MainActivity.this.persistBuddiesList();
                    Toast.makeText(MainActivity.this, R.string.delete_confirmed, Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton(android.R.string.no, null).show();
        return true;
    }
}
