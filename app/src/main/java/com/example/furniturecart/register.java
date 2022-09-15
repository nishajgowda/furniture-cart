package com.example.furniturecart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    Button button1, btn5;
    EditText ema, pas, cpas, nam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button1 = findViewById(R.id.button5);
        btn5 = findViewById(R.id.button2);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(register.this,login.class);
                 startActivity(intent);
             }
         });
        nam = (EditText) findViewById(R.id.PersonName);
        ema = (EditText) findViewById(R.id.EmailAddress3);
        pas = (EditText) findViewById(R.id.editTextTextPassword2);
        cpas = (EditText) findViewById(R.id.editTextTextPassword3);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkcredentials();
            }

            private void checkcredentials() {
                String user = nam.getText().toString();
                String email = ema.getText().toString();
                String pa = pas.getText().toString();
                String cp = cpas.getText().toString();

                if (user.isEmpty() || user.length() > 20) {
                    showError(nam, "Enter valid username");
                } else if (email.isEmpty() || !email.contains("@gmail.com")) {
                    showError(ema, "enter valid email");
                } else if (pa.isEmpty() || pa.length() < 7) {
                    showError(pas, "Password is week");
                } else if (cp.isEmpty() || !cp.equals(pa)) {
                    showError(cpas, "Password must be same");
                } else {

                    Toast.makeText(register.this, "Registered succesfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(register.this, dashboard.class);
                    startActivity(i);
                }
            }

            private void showError(EditText i, String s) {
                i.setError(s);
                i.requestFocus();
            }
        });
    }
}
