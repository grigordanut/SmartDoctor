package com.example.smartdoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class CheckUniqueCode extends AppCompatActivity {

    private TextInputEditText eTCheckUniqueCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_unique_code);

        eTCheckUniqueCode = findViewById(R.id.etCheckUniqueCode);

        Button buttonCheckCode = findViewById(R.id.btnCheckCode);

        buttonCheckCode.setOnClickListener(view -> {
            String editText_CheckCode = Objects.requireNonNull(eTCheckUniqueCode.getText()).toString();
            if (editText_CheckCode.isEmpty()) {
                eTCheckUniqueCode.setError("Please enter your Unique code");
                eTCheckUniqueCode.requestFocus();
            }

            else{
                if(editText_CheckCode.charAt(0) =='h'||editText_CheckCode.charAt(0)=='H'){
                    Toast.makeText(CheckUniqueCode.this, "This is a correct code for Hospital",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CheckUniqueCode.this, HospitalRegistration.class));
                }

                else if(editText_CheckCode.charAt(0) =='d'||editText_CheckCode.charAt(0)=='D'){
                    Toast.makeText(CheckUniqueCode.this, "This is a correct code for Doctor",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CheckUniqueCode.this, HospitalImageAddDoctor.class));
                }

                else{
                    Toast.makeText(CheckUniqueCode.this, "Please enter a correct Unique Code",Toast.LENGTH_SHORT).show();
                    eTCheckUniqueCode.setError("Enter a correct Unique Code");
                    eTCheckUniqueCode.requestFocus();
                }
            }
        });
    }
}