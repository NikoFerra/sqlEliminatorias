package com.sqleliminatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mostrar,incertar,eliminars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = (Button) findViewById(R.id.bnt_mostrar);
        incertar = (Button)findViewById(R.id.btn_incertar);
        eliminars =(Button)findViewById(R.id.btn_eliminar);
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),Mostrar.class);
                startActivity(I);
            }
        });


        incertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),incertar.class);
                startActivity(I);
            }
        });
        eliminars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),eliminar.class);
                startActivity(I);
            }
        });
    }
}