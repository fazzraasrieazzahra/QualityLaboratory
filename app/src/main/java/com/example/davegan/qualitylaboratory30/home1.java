package com.example.davegan.qualitylaboratory30;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;


public class home1 extends AppCompatActivity {

    ImageButton btnQlab;

    ConstraintLayout myLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home1);

        btnQlab = (ImageButton) findViewById(R.id.btnQlab);

        btnQlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godata = new Intent(home1.this,Home2.class);
                startActivity(godata);
            }
        });
        myLayout2 = (ConstraintLayout) findViewById(R.id.myLayout2);



    }
}
