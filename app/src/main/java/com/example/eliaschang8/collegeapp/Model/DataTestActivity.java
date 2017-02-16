package com.example.eliaschang8.collegeapp.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.BackendlessCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.eliaschang8.collegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class DataTestActivity extends AppCompatActivity {
    private Button save;
    private TextView display;
    private Guardian randomPerson;
    private Sibling bro;
    private List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);

        save = (Button)findViewById(R.id.button_save);
        display = (TextView)findViewById(R.id.text_display);

        randomPerson = new Guardian("Rich", "Guy",45,"President of the USA");
        bro = new Sibling("Eddie", "lad", 10000, "Bro");

        Backendless.initApp(this,"9B3BAF68-CCEF-BA4A-FF87-E2726E38C800", "1B5B5445-1774-AD45-FF2C-EB261E1F3400", "v1" );

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Backendless.Persistence.of(Person.class).save(randomPerson, new BackendlessCallback<Person>() {
                    @Override
                    public void handleResponse(Person response) {
                        Toast.makeText(DataTestActivity.this, "This works!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        super.handleFault(fault);
                        Toast.makeText(DataTestActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                Backendless.Persistence.of(Person.class).save(bro, new BackendlessCallback<Person>() {
                    @Override
                    public void handleResponse(Person response) {
                        Toast.makeText(DataTestActivity.this, "This works!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        super.handleFault(fault);
                        Toast.makeText(DataTestActivity.this, fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

                Log.d("LOOK HERE", "onCreate" + people.toString());
            }
        });
        //Make a list instance variable of type Person
        //Initialize the arrayList in onCreate
        people = new ArrayList<>();
        //Load all the Guardians and add them to the list
        Backendless.Persistence.of(Guardian.class).find(new BackendlessCallback<BackendlessCollection<Guardian>>() {
            @Override
            public void handleResponse(BackendlessCollection<Guardian> response) {
                people.addAll(response.getData());
            }
        });

        //Load all the siblings and add them to the list
        //Display the list in the TextView

    }
}