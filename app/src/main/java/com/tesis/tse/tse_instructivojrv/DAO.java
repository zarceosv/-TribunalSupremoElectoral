package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by cArLos on 29/5/2017.
 */

public class DAO extends SQLiteOpenHelper {
    /*Configuración de la base de datos*/
    private static final Integer version_baseDatos = 1;
    private static final String nombre_baseDatos = "tseBD";
    private final Context miContexto;
    String ruta_baseDatos = null;

    /*Metodos para acceder a los datos*/
    public Cursor consultaSQL(String query){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(query,null);
        return res;
    }

    /*Inicializar base de datos*/
    public DAO(Context context) {
        super(context, nombre_baseDatos, null, version_baseDatos);
        this.miContexto = context;
        this.ruta_baseDatos = "/data/data/" + context.getPackageName() + "/" + "databases/";
    }

    /*Crear base de datos*/
    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    /*Verificar si existe base de datos*/
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = ruta_baseDatos + nombre_baseDatos;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    /*Hacer migrado de la base de datos*/
    private void copyDataBase() throws IOException {
        InputStream myInput = miContexto.getAssets().open(nombre_baseDatos);
        String outFileName = ruta_baseDatos + nombre_baseDatos;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    /*Si existe una nueva version de base de datos se relizara la actualizacion de base de datos*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}