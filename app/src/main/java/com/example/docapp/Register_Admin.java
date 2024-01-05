package com.example.docapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register_Admin extends AppCompatActivity {
    EditText regNameAdm,regHospNameAdm,regPhoneNumbAdm,regPasswordAdm,regEmailAddressAdm,regConfirmPasswordAdm;
    TextView regAlreadyAccAdm;
    Button regRegisterAdm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);
        regNameAdm=findViewById(R.id.regNameAdm);
        regPasswordAdm=findViewById(R.id.regPasswordAdm);
        regHospNameAdm=findViewById(R.id.regHospNameAdm);
        regPhoneNumbAdm=findViewById(R.id.regPhoneNumbAdm);
        regEmailAddressAdm=findViewById(R.id.regEmailAddressAdm);
        regConfirmPasswordAdm=findViewById(R.id.regConfirmPasswordAdm);
        regAlreadyAccAdm=findViewById(R.id.regAlreadyAccAdm);
        regRegisterAdm=findViewById(R.id.regRegisterAdm);
        regRegisterAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NameAdm=regNameAdm.getText().toString();
                String PassAdm=regPasswordAdm.getText().toString();
                String HospNameAdm=regHospNameAdm.getText().toString();
                String PhnAdm=regPhoneNumbAdm.getText().toString();
                String EmailAdm=regEmailAddressAdm.getText().toString();
                String CnfmAdm=regConfirmPasswordAdm.getText().toString();
                if(NameAdm.isEmpty()){
                    Toast.makeText(Register_Admin.this, "Enter Correct Name", Toast.LENGTH_SHORT).show();
                } else if (HospNameAdm.isEmpty()) {
                    Toast.makeText(Register_Admin.this, "Enter Corect Hospital Name", Toast.LENGTH_SHORT).show();
                }
                 else if (EmailAdm.toLowerCase().isEmpty()) {
                    Toast.makeText(Register_Admin.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();

                }else if (PhnAdm.length()!=10) {
                    Toast.makeText(Register_Admin.this, "Enter Proper Phone Number", Toast.LENGTH_SHORT).show();
                }
                 else if (PassAdm.length()<8 || PassAdm.length()>16) {
                    Toast.makeText(Register_Admin.this, "Password length should be between 8-16", Toast.LENGTH_SHORT).show();
                } else if (PassAdm.equals(CnfmAdm)) {
                    Toast.makeText(Register_Admin.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Register_Admin.this, Login_Admin.class));
                }
                else {
                    Toast.makeText(Register_Admin.this, "Password and Confirm Password Doesn't Match ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        regAlreadyAccAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register_Admin.this,Login_Admin.class));
            }
        });
    }
}
