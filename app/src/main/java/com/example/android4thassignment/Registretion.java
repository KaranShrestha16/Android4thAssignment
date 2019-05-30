package com.example.android4thassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android4thassignment.API.UserAPI;
import com.example.android4thassignment.model.LoginSignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registretion extends AppCompatActivity {
    private EditText etFname,etLname, etUsername,etPassword;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registretion);
        etUsername=findViewById(R.id.etUserName);
        etPassword= findViewById(R.id.etPassword);
        etFname=findViewById(R.id.etFname);
        etLname= findViewById(R.id.etLname);
        btnRegister= findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkUser();

            }
        });
    }

    private void checkUser() {
        UserAPI userAPI= Url.getInstance().create(UserAPI.class);
        String fname=etFname.getText().toString().trim();
        String lname=etLname.getText().toString().trim();
        String userName=etUsername.getText().toString().trim();
        String password=etPassword.getText().toString().trim();

        Call<LoginSignupResponse> checkUser= userAPI.RegisterUser(fname,lname,userName,password);

        checkUser.enqueue(new Callback<LoginSignupResponse>() {
            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                if (!response.isSuccessful()) {

                    Toast.makeText(Registretion.this,"User cannot register",Toast.LENGTH_LONG ).show();
                    return;

                }else{
                    if(response.body().getSuccess()){
                        Intent intent = new Intent(Registretion.this, Login.class);
                        Toast.makeText(Registretion.this,"User Register Sucessfull",Toast.LENGTH_LONG ).show();

                        startActivity(intent);
                        finish();
                    }
                }
            }
            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                Toast.makeText(Registretion.this,"Error: "+t.getLocalizedMessage(),Toast.LENGTH_LONG ).show();

            }
        });

    }
}
