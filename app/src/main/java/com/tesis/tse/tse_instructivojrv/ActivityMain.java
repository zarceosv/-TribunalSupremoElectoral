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
                Uri uri = Uri.parse("market://details?id=sv.gob.tse.app1&hl=es");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
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
        int img_Alto = btn_Alto/3;

        // tbn1
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE abreviatura = 'btn1_main'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            String[] valor = res.getString(0).split(",");

            Button btn1 = (Button) findViewById(R.id.button_manual_paso_a_paso);
            btn1.setText(valor[0]);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            btn1.setLayoutParams (params);

            int imagen = getResources().getIdentifier(valor[1], "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_paso_paso);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto);
        }
        // tbn2
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE abreviatura = 'btn2_main'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            String[] valor = res.getString(0).split(",");
            Button btn2 = (Button) findViewById(R.id.button_agenda);
            btn2.setText(valor[0]);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            params.topToBottom = R.id.button_manual_paso_a_paso;
            btn2.setLayoutParams (params);

            int imagen = getResources().getIdentifier(valor[1], "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_agenda);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto+btn_Alto);
        }
        // tbn3
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE abreviatura = 'btn3_main'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            String[] valor = res.getString(0).split(",");
            Button btn3 = (Button) findViewById(R.id.button_aula_virtual);
            btn3.setText(valor[0]);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            params.topToBottom = R.id.button_agenda;
            btn3.setLayoutParams (params);
            int imagen = getResources().getIdentifier(valor[1], "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_aula_virtual);
            Glide.with(this).load(imagen).into(imagen_d);
            imagen_d.setY(img_Alto+btn_Alto*2);
            url_btn3 = valor[2];
        }
        // tbn4
        res = myDb.consultaSQL("SELECT valor FROM tse_parametro_sistema WHERE abreviatura = 'btn4_main'");
        if (res.getCount() == 0) {
            return ;
        }
        while (res.moveToNext()) {
            String[] valor = res.getString(0).split(",");
            Button btn4 = (Button) findViewById(R.id.button_web_tse);
            btn4.setText(valor[0]);
            ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                    AnchoPantalla,
                    btn_Alto
            );
            params.topToBottom = R.id.button_aula_virtual;
            btn4.setLayoutParams (params);
            int imagen = getResources().getIdentifier(valor[1], "drawable",this.getPackageName());
            ImageView imagen_d = (ImageView) findViewById(R.id.imageView_sitio_web_tse);
            Glide.with(this).load(imagen).into(imagen_d);
            url_btn4 = valor[2];
            imagen_d.setY(img_Alto+btn_Alto*3);
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
