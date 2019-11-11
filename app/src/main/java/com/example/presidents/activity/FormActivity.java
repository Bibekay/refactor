package com.example.presidents.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.presidents.R;

public class FormActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etName,etEmail,etPhone;
    Spinner spinner;
    Button Submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        final Spinner spinner = findViewById(R.id.spinAddress);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.address,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        viewValue();

        Submit.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name, phone, email, address;
                name = etName.getText().toString();
                phone = etPhone.getText().toString();
                email = etEmail.getText().toString();
                address = spinner.getSelectedItem().toString();

                if (name.isEmpty())
                {
                    etName.setError("Please enter your name");
                    return;
                }

                if (phone.isEmpty())
                {
                    etPhone.setError("Please enter your Phone");
                    return;
                }

                if (email.isEmpty())
                {
                    etEmail.setError("Please enter your email");
                    return;
                }



                Intent intentForm = new Intent(FormActivity.this, DisplayActivity.class);
                intentForm.putExtra("forName", name);
                intentForm.putExtra("forPhone", phone);
                intentForm.putExtra("forEmail",email);
                intentForm.putExtra("forAddress",address);

                startActivity(intentForm);

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void viewValue() {
        etName = findViewById(R.id.personalName);
        etPhone = findViewById(R.id.contactNumber);
        etEmail = findViewById(R.id.emailAddress);
        spinner = findViewById(R.id.spinAddress);
        Submit= findViewById(R.id.btnSubmit);
    }
}
