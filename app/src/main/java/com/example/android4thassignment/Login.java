package com.example.android4thassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android4thassignment.API.UserAPI;
import com.example.android4thassignment.model.LoginSignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText etUserName,etPassword;
    private Button btnLogin;
    private TextView tvRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=findViewById(R.id.etUserName);
        etPassword= findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        tvRegister= findViewById(R.id.tvRegister);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,Registretion.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUsers();
            }
        });


    }

    private void checkUsers() {
        UserAPI userAPI= Url.getInstance().create(UserAPI.class);
        String username=etUserName.getText().toString().trim();
        String password=etPassword.getText().toString().trim();

        Call<LoginSignupResponse> userCell= userAPI.CheckUser(username,password);
        userCell.enqueue(new Callback<LoginSignupResponse>() {
            @Override
            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(Login.this, "Either email or password incorrect",Toast.LENGTH_LONG).show();
                    return;
                }else{

                    if(response.body().getSuccess()){
                        Url.setAccessTooke(response.headers().get("accessToken"));
                        Intent intent= new Intent(Login.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
                Toast.makeText(Login.this,"Error: "+t.getLocalizedMessage(),Toast.LENGTH_LONG ).show();

            }
        });




    }
}
