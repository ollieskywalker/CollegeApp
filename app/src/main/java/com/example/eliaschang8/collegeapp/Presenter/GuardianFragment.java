package com.example.eliaschang8.collegeapp.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eliaschang8.collegeapp.Model.Guardian;
import com.example.eliaschang8.collegeapp.R;

/**
 * Created by eliaschang8 on 12/13/16.
 */
public class GuardianFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container,false);

        EditText editFirstName = (EditText)rootView.findViewById(R.id.edit_first);
        EditText editLasttName = (EditText)rootView.findViewById(R.id.edit_last);
        EditText editJob = (EditText)rootView.findViewById(R.id.edit_job);

        Guardian g = new Guardian("Parent", "Parent", 45, "Lawyer");

        editFirstName.setText(""+g.getFirstname());
        editLasttName.setText(""+g.getLastname());
        editJob.setText(""+g.getOccupation());

        Log.d("TAG", String.valueOf(editJob.getText()));
        return rootView;
    }
}
