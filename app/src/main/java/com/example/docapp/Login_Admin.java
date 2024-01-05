package com.example.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Admin extends AppCompatActivity {
    EditText PhoneNumbAdm,PasswordAdm,AdminID;
    Button LoginAdm,RegisterAdm,LogasPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        PhoneNumbAdm=findViewById(R.id.PhoneNumbAdm);
        PasswordAdm=findViewById(R.id.PasswordAdm);
        AdminID=findViewById(R.id.AdminID);
        LoginAdm=findViewById(R.id.LoginAdm);
        RegisterAdm=findViewById(R.id.RegisterAdm);
        LogasPatient=findViewById(R.id.LogasPatient);
        LoginAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String AdmID=AdminID.getText().toString();
                String PhoneNumbtxt=PhoneNumbAdm.getText().toString();
                String Passwordtxt=PasswordAdm.getText().toString();
                if (AdminID.length()==0){
                    Toast.makeText(Login_Admin.this, "Enter Correct Admin ID", Toast.LENGTH_SHORT).show();
                } else if (PhoneNumbAdm.length()!=10) {
                    Toast.makeText(Login_Admin.this, "Enter Correct Phone Number", Toast.LENGTH_SHORT).show();
                } else if (PasswordAdm.length()<8||PasswordAdm.length()>16) {
                    Toast.makeText(Login_Admin.this, "Password must be of 8-16 Characters", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login_Admin.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                }
            }
        });
        RegisterAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Admin.this,Register_Admin.class));
            }
        });
        LogasPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Admin.this,LoginActivity.class));
            }
        });
    }
}