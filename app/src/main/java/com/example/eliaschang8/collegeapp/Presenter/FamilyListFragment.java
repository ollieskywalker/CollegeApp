package com.example.eliaschang8.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;
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

        Backendless.initApp(getActivity(),"9B3BAF68-CCEF-BA4A-FF87-E2726E38C800", "1B5B5445-1774-AD45-FF2C-EB261E1F3400", "v1" );

        guardianList = new ArrayList<>();
        populateList();

        FamilyAdapter adapter = new FamilyAdapter(getActivity() , guardianList);

        setListAdapter(adapter);

        return root;
    }

    private void populateList() {

        Backendless.Persistence.of(Guardian.class).find(new BackendlessCallback<BackendlessCollection<Guardian>>() {
            @Override
            public void handleResponse(BackendlessCollection<Guardian> response) {
                guardianList.addAll(response.getData());
                Log.d("LOOK HERE", "getGuardian" + guardianList.get(0).getOccupation());
            }
        });
    }
}