package com.example.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    EditText PhoneNumb,Password;
    Button Login,Register,LogasAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhoneNumb=findViewById(R.id.PhoneNumb);
        Password=findViewById(R.id.Password);
        Login=findViewById(R.id.Login);
        Register=findViewById(R.id.Register);
        LogasAdmin=findViewById(R.id.LogasAdmin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PhoneNumbtxt= PhoneNumb.getText().toString();
                String Passwordtxt = Password.getText().toString();
                Database db=new Database(getApplicationContext(),"LoginData",null,1);
                if (PhoneNumbtxt.length() != 10) {
                    Toast.makeText(LoginActivity.this, "Enter Proper Phone Number", Toast.LENGTH_SHORT).show();
                } else if (Passwordtxt.length() < 8 || Passwordtxt.length() > 16) {
                    Toast.makeText(LoginActivity.this, "Password length should be between 8 to 16", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.login(PhoneNumbtxt,Passwordtxt)==1){
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this,Home_Patient.class));
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        LogasAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,Login_Admin.class));
            }
        });
    }
}