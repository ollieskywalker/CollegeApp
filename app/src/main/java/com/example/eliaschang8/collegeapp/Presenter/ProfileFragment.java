package com.example.eliaschang8.collegeapp.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eliaschang8.collegeapp.Model.Profile;
import com.example.eliaschang8.collegeapp.R;

import java.util.Date;

/**
 * Created by eliaschang8 on 12/9/16.
 */
public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_profile, container,false);
        Date birthday = new Date(1999, 10, 8);

        EditText editFirstName = (EditText)rootView.findViewById(R.id.edit_first);
        EditText editLastName = (EditText)rootView.findViewById(R.id.edit_last);
        EditText editBirthday = (EditText)rootView.findViewById(R.id.edit_birthday);

        Profile student = new Profile("Oliver", "Chang", birthday);

//        editFirstName.setText(""+student.getFirstname());
//        editLastName.setText(""+student.getLastname());
//        editBirthday.setText(""+(CharSequence) student.getBirthday());

        return rootView;
    }
}
