package com.tesis.tse.tse_instructivojrv;

import android.database.Cursor;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class ActivityAcecade extends AppCompatActivity {
    DAO myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acecade);
        myDb = new DAO(this);
        Cursor res;
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'acercade_descripcion'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            TextView acercade_descripcion = (TextView) findViewById(R.id.acercade_descripcion);
            acercade_descripcion.setText(res.getString(0));
        }
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'acercade_telefono'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            TextView acercade_telefono = (TextView) findViewById(R.id.acercade_telefono);
            acercade_telefono.setText(res.getString(0));
            int mask = Linkify.PHONE_NUMBERS;
            Linkify.addLinks(acercade_telefono, mask);
        }
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'acercade_correo'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            TextView acercade_correo = (TextView) findViewById(R.id.acercade_correo);
            acercade_correo.setText(res.getString(0));
            int mask = Linkify.EMAIL_ADDRESSES;
            Linkify.addLinks(acercade_correo, mask);
        }
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'acercade_ext'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            TextView acercade_ext = (TextView) findViewById(R.id.acercade_ext);
            acercade_ext.setText(res.getString(0));
        }
        res.close();
    }
}
