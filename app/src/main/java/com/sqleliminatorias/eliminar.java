package com.sqleliminatorias;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class eliminar extends AppCompatActivity {
    ListView lv_eliminar;

    ArrayList<String>Arr_paises;
    ArrayList<Integer> Arr_paises_pk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar);
        lv_eliminar = (ListView) findViewById(R.id.lv_eliminar);//asas
        LlenarListViewPaises();

        lv_eliminar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(eliminar.this);
                builder.setMessage("desea eliminar el pais")
                        .setPositiveButton("aceptar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Integer pk = Arr_paises_pk.get(i);
                                SQLiteDatabase db;
                                Dbhelper conn =  new Dbhelper(getApplicationContext());
                                db = conn.getReadableDatabase();
                                String[] Where={pk+""};
                                db.delete("pais","id_pais=?",Where);
                                lv_eliminar.setAdapter(null);
                                LlenarListViewPaises();
                            }
                        })
                        .setNegativeButton("cancelar ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                builder.create();
                builder.show();


            }
        });
    }

    public void LlenarListViewPaises()
    {
        Arr_paises =   new ArrayList<String>();
        Arr_paises_pk = new ArrayList<Integer>();
        SQLiteDatabase db;
        Dbhelper conn =  new Dbhelper(getApplicationContext());
        db = conn.getReadableDatabase();

        Cursor c =db.query("pais",null,null,null,null,null,null);
        if(c!= null)
        {
            if(c.moveToFirst())
            {
                do{
                    String NombrePais = c.getString(1);
                    Arr_paises_pk.add(c.getInt(0));
                    Arr_paises.add(NombrePais);
                }
                while(c.moveToNext());
            }
        }
        //-----------------
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Arr_paises);

        lv_eliminar.setAdapter(adaptador);

    }
}