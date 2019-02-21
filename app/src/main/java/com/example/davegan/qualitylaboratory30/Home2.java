package com.example.davegan.qualitylaboratory30;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class Home2 extends AppCompatActivity {

    ImageButton btnDashboard;
    ImageButton btn_equipment;
    ImageButton btn_Calibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home2);

        btnDashboard =(ImageButton) findViewById(R.id.btnDashboard);
        btn_equipment =(ImageButton) findViewById(R.id.btn_equipment);
        btn_Calibration = (ImageButton) findViewById(R.id.btn_Calibration);

        btn_Calibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata3 = new Intent(Home2.this,WebViewKU.class);
                startActivity(godata3);
            }
        });

        btn_equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata2 = new Intent(Home2.this,MasterListAlatUkur.class);
                startActivity(godata2);
            }
        });

        btnDashboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent godata = new Intent(Home2.this,DashView.class);
                startActivity(godata);
            }
        });
    }
}
