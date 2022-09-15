package com.example.furniturecart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class fancyTable extends AppCompatActivity {
    Button fancy;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_table);
        fancy=(Button)findViewById(R.id.fancytable);
       fancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fancy.isPressed()){
                    Intent intent=new Intent(fancyTable.this,home.class);
                    startActivity(intent);
                    Toast.makeText(fancyTable.this, "product added to the cart", Toast.LENGTH_SHORT).show();



                }


            }
        });

        TextView t = (TextView) findViewById(R.id.textView2);
        t.setText("Rs 25,000");
        t.setPaintFlags(t.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
