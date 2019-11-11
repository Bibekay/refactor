package com.example.presidents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.presidents.R;

public class DisplayActivity extends AppCompatActivity {

    TextView tvName,tvPhone,tvEmail,tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        tvName = findViewById(R.id.iName);
        tvPhone= findViewById(R.id.iContact);
        tvEmail = findViewById(R.id.iEmail);
        tvAddress = findViewById(R.id.iAddress);

        Bundle bundleForm = getIntent().getExtras();
        if(bundleForm != null){
            tvName.setText(bundleForm.getString("forName"));
            tvPhone.setText(bundleForm.getString("forPhone"));
            tvEmail.setText(bundleForm.getString("forEmail"));
            tvAddress.setText(bundleForm.getString("forAddress"));

        }
        else{
            Toast.makeText(this, "Sorry, no data found.", Toast.LENGTH_SHORT).show();
        }

    }
}
