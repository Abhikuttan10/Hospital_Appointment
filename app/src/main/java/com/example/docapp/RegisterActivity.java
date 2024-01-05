package com.example.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {
    EditText regPhoneNumb,regPassword,regEmailAddress,regConfirmPassword,regName;
    TextView regAlreadyAcc;
    Button regRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regPhoneNumb=findViewById(R.id.regPhoneNumb);
        regPassword=findViewById(R.id.regPassword);
        regRegister=findViewById(R.id.regRegister);
        regEmailAddress=findViewById(R.id.regEmailAddress);
        regAlreadyAcc=findViewById(R.id.regAlreadyAcc);
        regConfirmPassword=findViewById(R.id.regConfirmPassword);
        regName=findViewById(R.id.regName);

        regAlreadyAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        regRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Phnnumb=regPhoneNumb.getText().toString();
                String Pass=regPassword.getText().toString();
                String ConfmPass=regConfirmPassword.getText().toString();
                String Email=regEmailAddress.getText().toString();
                String Name=regName.getText().toString();
                Database db=new Database(getApplicationContext(),"LoginData",null,1);
                if(Phnnumb.length()!=10){
                    Toast.makeText(RegisterActivity.this, "Enter Proper Phone Number", Toast.LENGTH_SHORT).show();
                } else if (Email.toLowerCase().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();

                } else if (Pass.length()<8 || Pass.length()>16) {
                    Toast.makeText(RegisterActivity.this, "Password length should be between 8-16", Toast.LENGTH_SHORT).show();
                } else if (Pass.equals(ConfmPass)) {
                    Toast.makeText(RegisterActivity.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                    db.register(Name,Phnnumb,Email,Pass);
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Password and Confirm Password Doesn't Match ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}