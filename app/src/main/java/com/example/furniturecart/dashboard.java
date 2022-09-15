package com.example.furniturecart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class dashboard extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
FloatingActionButton floatingAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        floatingAction=findViewById(R.id.floatingActionButton);
        floatingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(dashboard.this,acc.class);
                startActivity(intent);
            }
        });

       bottomNavigationView=findViewById(R.id.bottonnavigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(listener);
       getSupportFragmentManager().beginTransaction().replace(R.id.container,new home()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener listener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selFra=null;
            switch (item.getItemId()){
                case R.id.home:
                    selFra=new home();
                    break;
                case R.id.search:
                    selFra=new search();
                    break;
                case R.id.mycart:
                    selFra=new mycart();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,selFra).commit();
            return true;
        }
    };

}