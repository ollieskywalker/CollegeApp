package com.example.eliaschang8.collegeapp.Presenter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.eliaschang8.collegeapp.R;

/**
 * Created by eliaschang8 on 12/9/16.
 */
public class SiblingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_sibling, container,false);

        return rootView;
    }
}
