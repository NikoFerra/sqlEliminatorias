package com.sqleliminatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class incertar extends AppCompatActivity {
    EditText nombrePais,id_pais;
    Button Guardar,Volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incertar);
    Guardar = (Button) findViewById(R.id.btn_guardarinst);
    Volver = (Button) findViewById((R.id.bn_volverinst));
    nombrePais = (EditText) findViewById(R.id.txt_nombrepais);
    id_pais =(EditText) findViewById(R.id.txt_codigopis);


    Guardar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SQLiteDatabase db;
            Dbhelper conn =  new Dbhelper(getApplicationContext());
            db=conn.getWritableDatabase();// write para poder escribir en la base de datos
            ContentValues cv = new ContentValues();// aca creamos un contenedor para guardar la indormacion
            cv.put("id_pais",id_pais.getText().toString());
            cv.put("nombre_pais",nombrePais.getText().toString());
            db.insert("pais",null,cv);
            Toast.makeText(getApplicationContext(),"registro Insertado",Toast.LENGTH_SHORT).show();

        }
    });

    Volver.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent I = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(I);

        }
    });



    }
}