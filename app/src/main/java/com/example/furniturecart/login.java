package com.example.furniturecart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
Button button,btn3;
EditText em,ps;
CheckBox remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button=findViewById(R.id.button);
        remember=findViewById(R.id.checkBox);
        btn3=findViewById(R.id.button3);
        em=(EditText) findViewById(R.id.EmailAddress);
        ps=(EditText)findViewById(R.id.TextPassword);
        btn3=(Button) findViewById(R.id.button3);
        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox =preferences.getString("remember","");
        if (checkbox.equals("true")){
           Intent intent=new Intent(login.this,dashboard.class);
           startActivity(intent);
        }else if(checkbox.equals("false")){
            Toast.makeText(this, "sign in", Toast.LENGTH_SHORT).show();
        }



        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i=new Intent(login.this,register.class);
                startActivity(i);
            }
        });
        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(compoundButton.isChecked()){
                   SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                   SharedPreferences.Editor editor = preferences.edit();
                   editor.putString("remember","true");
                   editor.apply();
                   Toast.makeText(login.this, "checked", Toast.LENGTH_SHORT).show();
               }
               else if (!compoundButton.isChecked()){
                   SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                   SharedPreferences.Editor editor = preferences.edit();
                   editor.putString("remember","false");
                   editor.apply();
                   Toast.makeText(login.this, "Unchecked", Toast.LENGTH_SHORT).show();

               }




            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    checkcredentials();
                }

            });
        }
        private void checkcredentials() {
            String email=em.getText().toString();
            String pass=ps.getText().toString();
            if(email.isEmpty()  || !email.contains("@gmail.com")){
                showError(em,"email is not valid");
            }
            else if(pass.isEmpty() || pass.length()<7)
            {
                showError(ps,"password can't be empty");
            }
            else {
                Toast.makeText(this, "Loged IN", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(login.this,dashboard.class);
                startActivity(i);
            }
        }

        private void showError(EditText input, String s) {
            input.setError(s);
            input.requestFocus();
        }
    }
