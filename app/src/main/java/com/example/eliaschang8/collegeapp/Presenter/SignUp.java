package com.example.eliaschang8.collegeapp.Presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.eliaschang8.collegeapp.R;

public class SignUp extends AppCompatActivity {

    private Button submit;
    private EditText password;
    private EditText confirmPassword;
    private EditText firstName, lastName, email, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        submit = (Button)findViewById(R.id.button_submit);
        password = (EditText)findViewById(R.id.edit_password);
        confirmPassword = (EditText)findViewById(R.id.edit_confirm);
        firstName = (EditText)findViewById(R.id.edit_first_name);
        lastName = (EditText)findViewById(R.id.edit_last_name);
        email = (EditText)findViewById(R.id.edit_email);
        username = (EditText)findViewById(R.id.edit_username);

        //Provide for up-navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Backendless Registration
        Backendless.initApp(this,"9B3BAF68-CCEF-BA4A-FF87-E2726E38C800", "1B5B5445-1774-AD45-FF2C-EB261E1F3400", "v1" );


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sPassword = String.valueOf(password.getText());
                String sConfirm = String.valueOf(confirmPassword.getText());

                if(sPassword.equals(sConfirm)){
                    Toast.makeText(SignUp.this,"Passwords match!", Toast.LENGTH_SHORT).show();

                    //Backendless User
                    BackendlessUser user = new BackendlessUser();
                    user.setEmail( email.getText().toString());
                    user.setPassword(confirmPassword.getText().toString());
                    user.setProperty("first_name", firstName.getText().toString());
                    user.setProperty("last_name",lastName.getText().toString());
                    user.setProperty("username",username.getText().toString());

                    //Register the user by calling the Backendless
                    Backendless.UserService.register(user, createRegCallback());

//                    Intent mainIntent = new Intent(SignUp.this,MainActivity.class);
//                    SignUp.this.startActivity(mainIntent);
                }
            }
        });
    }

    private AsyncCallback<BackendlessUser> createRegCallback() {
        return new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(SignUp.this, "Registration Success", Toast.LENGTH_SHORT).show();

                Intent i = new Intent();
                Bundle extras = new Bundle();
                extras.putString("EXTRA_USERNAME", username.getText().toString());
                extras.putString("EXTRA_PASSWORD", password.getText().toString());
                setResult(Activity.RESULT_OK, i);
                finish();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(SignUp.this, "" + fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}
