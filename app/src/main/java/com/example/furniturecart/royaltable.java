package com.example.furniturecart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class royaltable extends AppCompatActivity {
    Button royal;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_royal_table);
        royal=(Button)findViewById(R.id.fancytable);
        royal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(royal.isPressed()){
                    Intent intent=new Intent(royaltable.this,home.class);
                    startActivity(intent);
                    Toast.makeText(royaltable.this, "product added to the cart", Toast.LENGTH_SHORT).show();



                }


            }
        });

        TextView t = (TextView) findViewById(R.id.src);
        t1.setText("Rs 25,000");
        t1.setPaintFlags(t.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
