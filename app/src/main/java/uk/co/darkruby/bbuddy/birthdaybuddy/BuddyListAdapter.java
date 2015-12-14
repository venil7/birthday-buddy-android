package uk.co.darkruby.bbuddy.birthdaybuddy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BuddyListAdapter extends ArrayAdapter<BuddyModel> {

    private int viewId;
    private Context context;
    private ArrayList<BuddyModel> list;
    private SimpleDateFormat sdf;

    public BuddyListAdapter(Context context, int viewId, ArrayList<BuddyModel> list) {
        super(context, viewId, list);

        this.viewId = viewId;
        this.context = context;
        this.list = list;
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("BuddyListAdapter", "getView");
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.viewId, null);
        }

        BuddyModel model = this.list.get(position);

        TextView rowLabel = (TextView) convertView.findViewById(R.id.rowLabel);
        TextView rowValue = (TextView) convertView.findViewById(R.id.rowValue);

        rowLabel.setText(model.name);
        rowValue.setText(this.sdf.format(model.birthdate));

        return convertView;
    }
}
