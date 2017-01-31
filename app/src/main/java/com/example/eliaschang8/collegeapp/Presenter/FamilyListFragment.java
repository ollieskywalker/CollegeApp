package com.example.eliaschang8.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eliaschang8.collegeapp.Model.Guardian;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eliaschang8 on 1/31/17.
 */
public class FamilyListFragment extends ListFragment{
    private List<Guardian>guardianList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        guardianList = new ArrayList<>();
        populateList();

        return root;
    }

    private void populateList() {
        guardianList.add(new Guardian("My Dad", "LastName", 45, "President of Uganda"));
        guardianList.add(new Guardian("My Mom", "LastName", 0, "Something"));
        guardianList.add(new Guardian("My Dad", "LastName", 45, "President of Uganda"));
    }
}
