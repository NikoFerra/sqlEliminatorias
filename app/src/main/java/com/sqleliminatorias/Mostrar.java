package com.sqleliminatorias;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {
    ListView Lv_paisess;
    ArrayList<String> Arr_paises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        Lv_paisess = (ListView) findViewById(R.id.lv_paisesss);
        Arr_paises = new ArrayList<String>();
        //-----------Traer la info de la base de datos------------
        SQLiteDatabase db;
        Dbhelper conn =  new Dbhelper(getApplicationContext());
        //db = conn.getWritableDatabase();// si queremos traer la informacion para manipilarla la traemos como ecritura
        db = conn.getReadableDatabase();// aca la taemos como lectura para solo verla
        Cursor c =db.query("pais",null,null,null,null,null,null);// aca traemos toda la informacion de la base de datos
        if(c!= null)
        {
            if(c.moveToFirst())
            {
                do{
                    String NombrePais = c.getString(1);// la posicion 1 --- aca traemos informacion de la base de datos
                    Arr_paises.add(NombrePais);
                    //int codigoPais = c.getInt(0);
                }
                while(c.moveToNext());
            }
        }
        //-----------------
        ArrayAdapter<String> adaptador= new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Arr_paises);
          Lv_paisess.setAdapter(adaptador);
    }
}