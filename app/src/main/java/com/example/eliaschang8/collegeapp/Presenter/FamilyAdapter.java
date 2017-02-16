package com.example.eliaschang8.collegeapp.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eliaschang8.collegeapp.Model.Guardian;
import com.example.eliaschang8.collegeapp.R;

import java.util.List;

/**
 * Created by eliaschang8 on 2/2/17.
 */
public class FamilyAdapter extends ArrayAdapter<Guardian> {
    public FamilyAdapter(Context context, List<Guardian> objects) {
        super(context, 0, objects);
        Log.d("LOOK HERE", "DATA LOADED");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.guardian_item, null);
            Log.d("LOOK HERE", "DATA LOADED");
        }

        Guardian guardian = getItem(position);

        TextView name = (TextView) convertView.findViewById(R.id.first_name);
        TextView lastName = (TextView) convertView.findViewById(R.id.last_name);
        TextView occupation = (TextView) convertView.findViewById(R.id.ocupation);
        TextView age = (TextView) convertView.findViewById(R.id.age);

        name.setText(guardian.getFirstname());
        lastName.setText(guardian.getLastname());
        occupation.setText(guardian.getOccupation());
        age.setText(guardian.getAge());

        Log.d("LOOK HERE", "DATA LOADED");

        return convertView;
    }
}
