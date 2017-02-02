package com.example.eliaschang8.collegeapp.Presenter;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.UserService;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.eliaschang8.collegeapp.R;

public class LoginScreen extends AppCompatActivity {

    private Button signup, login;
    private EditText username, password;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        signup = (Button)findViewById(R.id.button_signup);
        login = (Button)findViewById(R.id.button_login);
        username = (EditText)findViewById(R.id.edit_login);
        password = (EditText)findViewById(R.id.edit_password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(LoginScreen.this,SignUp.class);
                LoginScreen.this.startActivity(mainIntent);
            }
        });

        Backendless.initApp(this,"9B3BAF68-CCEF-BA4A-FF87-E2726E38C800", "1B5B5445-1774-AD45-FF2C-EB261E1F3400", "v1" );

       //Bundle extras = getIntent().getExtras();


//        username.setText(extras.getString("EXTRA_USERNAME"));
//        password.setText(extras.getString("EXTRA_PASSWORD"));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backendless.UserService.login(username.getText().toString(),password.getText().toString(), createCallback());
                progressDialog.show();
            }
        });

    }

    private AsyncCallback<BackendlessUser> createCallback() {
        return new AsyncCallback<BackendlessUser>() {

            protected void doInBackground(Void...voids){

            }

            @Override
            public void handleResponse(BackendlessUser response) {
                //Toast.makeText(LoginScreen.this, "Login Success", Toast.LENGTH_SHORT).show();
                progressDialog.cancel();
                Intent mainIntent = new Intent(LoginScreen.this,MainActivity.class);
                LoginScreen.this.startActivity(mainIntent);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(LoginScreen.this, "" + fault.getMessage(), Toast.LENGTH_SHORT).show();
//                try{
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };
    }
}