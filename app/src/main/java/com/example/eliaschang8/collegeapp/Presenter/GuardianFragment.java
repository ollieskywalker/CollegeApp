package com.example.eliaschang8.collegeapp.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eliaschang8.collegeapp.Model.Guardian;
import com.example.eliaschang8.collegeapp.R;

/**
 * Created by eliaschang8 on 12/13/16.
 */
public class GuardianFragment extends Fragment {
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editAge;
    private EditText editJob;
    private Button addMember;
    public static final String EXTRA_NAME_FIRST= "guardian first name";
    public static final String EXTRA_NAME_LAST = "guardian last name";
    public static final String EXTRA_JOB = "guardian job";
    public static final String EXTRA_AGE = "guardian age";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian, container,false);

        editFirstName = (EditText)rootView.findViewById(R.id.edit_first);
        editLastName = (EditText)rootView.findViewById(R.id.edit_last);
        editAge = (EditText)rootView.findViewById(R.id.edit_age);
        editJob = (EditText)rootView.findViewById(R.id.edit_job);
        addMember = (Button)rootView.findViewById(R.id.button_addmember);

        addMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(editAge.getText().toString());
                Guardian g = new Guardian(editFirstName.getText().toString(), editLastName.getText().toString(),
                       a, editJob.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putString(EXTRA_NAME_FIRST, editFirstName.getText().toString());
                bundle.putString(EXTRA_NAME_LAST, editLastName.getText().toString());
                bundle.putString(EXTRA_JOB, editJob.getText().toString());
                bundle.putInt(EXTRA_AGE, Integer.parseInt(editAge.getText().toString()));

                Intent i = new Intent(getActivity(), FamilyListFragment.class);
                i.putExtras(bundle);
                startActivity(i);

                Toast.makeText(getActivity(), "" + g.getAge(), Toast.LENGTH_SHORT).show();
            }
        });

        Log.d("TAG", String.valueOf(editJob.getText()));
        return rootView;
    }
}