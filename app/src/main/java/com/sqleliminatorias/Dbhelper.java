package com.sqleliminatorias;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Dbhelper extends SQLiteOpenHelper {

    public static String  Nombre_db = "eliminatorias.db";
    public static int Version_db=1;
    public static String Tabla_Paises="create table pais(id_pais integer primary key, nombre_pais text not null)";


    public Dbhelper(Context context) {
        super(context,Nombre_db, null, Version_db);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {// la primera ves que c habra la base de datos , c cointruira en esta clse
    sqLiteDatabase.execSQL(Tabla_Paises);// crea la tabla
        sqLiteDatabase.execSQL("insert into pais (id_pais,nombre_pais)values (1,'CHile')");
        sqLiteDatabase.execSQL("insert into pais (id_pais,nombre_pais)values (2,'brasil')");
        sqLiteDatabase.execSQL("insert into pais (id_pais,nombre_pais)values (3,'argentina')");
        sqLiteDatabase.execSQL("insert into pais (id_pais,nombre_pais)values (4,'uruguay')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//
       // sqLiteDatabase.execSQL("drop table if exists pais");
        //sqLiteDatabase.execSQL(Tabla_Paises);
    }
}
