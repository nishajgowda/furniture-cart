package com.example.furniturecart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class table extends AppCompatActivity {

        Button btn9;
        TextView t2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_table);

            btn9=(Button)findViewById(R.id.btnd);
            btn9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(table.this,home.class);
                    startActivity(intent);
                    Toast.makeText(table.this, "product added to the cart", Toast.LENGTH_SHORT).show();
                }
            });

            TextView t2 = (TextView) findViewById(R.id.textVw2);
            t2.setText("Rs 17,000");
            t2.setPaintFlags(t2.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }