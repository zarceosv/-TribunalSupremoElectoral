package com.tesis.tse.tse_instructivojrv;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ActivityMain extends AppCompatActivity {
    DAO myDb;
    String url_btn3 = "";
    String url_btn4 = "";
    String url_play_store = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        /*--------- CREO LA INSTANCIA Y COPIO LA BASE DE DATOS-------------*/
        crearInstanciaDB();
        configurarPrincipal();

        /*--------- BOTÓN DE ACTUALIZAR APP -------------*/
        FloatingActionButton actualizar_app = (FloatingActionButton) findViewById(R.id.floatingActionButton_actualizar_app);
        actualizar_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reemplazar con el paquete de nuestra aplicacion al estar en la PlayStore
                try {
                    Uri uri = Uri.parse(url_play_store);
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }catch (Exception ex){
                    Log.e("Error",ex.toString());
                }
            }
        });
        /*--------- FIN BOTÓN ACTUALIZAR APP ---------*/
    }

    public void configurarPrincipal(){
        Cursor res;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int AnchoPantalla = size.x;
        int AltoPantalla = size.y;
        int btn_Alto = AltoPantalla/5;
        float dp = 20;
        float px = dp * getResources().getDisplayMetrics().density;
        float img_Alto = btn_Alto/2  - px;

        // tbn1 nombre
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn1_main_nombre'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            Button btn1 = (Button) findViewById(R.id.button_manual_paso_a_paso);
            btn1.setText(res.getString(0));
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            btn1.setLayoutParams (params);
        }
        // tbn1 icono
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn1_main_icono'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            int imagen = getResources().getIdentifier(res.getString(0), "drawable", this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_paso_paso);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto);
        }
        // tbn2 nombre
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn2_main_nombre'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            Button btn2 = (Button) findViewById(R.id.button_agenda);
            btn2.setText(res.getString(0));
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            params.topToBottom = R.id.button_manual_paso_a_paso;
            btn2.setLayoutParams (params);
        }
        // tbn2 icono
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn2_main_icono'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            int imagen = getResources().getIdentifier(res.getString(0), "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_agenda);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto+btn_Alto);
        }
        // tbn3 nombre
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn3_main_nombre'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            Button btn3 = (Button) findViewById(R.id.button_aula_virtual);
            btn3.setText(res.getString(0));
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            params.topToBottom = R.id.button_agenda;
            btn3.setLayoutParams(params);
        }
        // tbn3 icono
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn3_main_icono'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            int imagen = getResources().getIdentifier(res.getString(0), "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_aula_virtual);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto+btn_Alto*2);

        }
        // tbn3 link
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn3_main_link'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            url_btn3 = res.getString(0);
        }
        // tbn4 nombre
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn4_main_nombre'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            Button btn4 = (Button) findViewById(R.id.button_web_tse);
            btn4.setText(res.getString(0));
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            params.topToBottom = R.id.button_aula_virtual;
            btn4.setLayoutParams(params);
        }
        // tbn4 icono
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn4_main_icono'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            int imagen = getResources().getIdentifier(res.getString(0), "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_sitio_web_tse);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto+btn_Alto*3);
        }
        // tbn4 link
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'btn4_main_link'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            url_btn4 = res.getString(0);
        }

        // tbn5 link
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE activo = 1 and abreviatura = 'app_link'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            url_play_store = res.getString(0);
        }
        res.close();
    }


    /*--------- ENLACES EXTERNOS DE LA APP -------------*/
    public void onClickButtonWebTSE(View v){
        Uri uri = Uri.parse(url_btn4); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickButtonAulaVirtual(View v){
        Uri uri = Uri.parse(url_btn3); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    /*--------- FIN DE ENLACES EXTERNOS DE LA APP ---------*/

    /*--------- ENLACES INTERNOS DE LA APP -------------*/
    public void onClickButtonManual(View v){
        Intent i = new Intent(this, ActivityManual.class );
        startActivity(i);
    }

    public void onClickButtonAgenda(View v){
        Intent i = new Intent(this, ActivityAgenda.class );
        startActivity(i);
    }

    public void onClickButtonAcercade(View v){
        Intent i = new Intent(this, ActivityAcecade.class );
        startActivity(i);
    }
    /*--------- FIN DE ENLACES INTERNOS DE LA APP -------------*/

    /*--------- CREO LA INSTANCIA DE BASE DE DATOS ---------*/
    public void crearInstanciaDB(){
        try{
            myDb = new DAO(this);
            myDb.createDataBase();
        }catch (Exception e){

        }
    }
}
