package com.tesis.tse.tse_instructivojrv;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

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

    /*--------- ENLACES EXTERNOS DE LA APP -------------*/
    public void onClickButtonWebTSE(View v){
        Uri uri = Uri.parse("http://www.tse.gob.sv/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickButtonAulaVirtual(View v){
        Uri uri = Uri.parse("http://consulta.tse.gob.sv/"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    /*--------- FIN DE ENLACES EXTERNOS DE LA APP ---------*/

    public void onClickButtonManual(View v){
        Intent i = new Intent(this, ActivityManual.class );
        startActivity(i);
    }

    public void onClickButtonAgenda(View v){
        Intent i = new Intent(this, ActivityAgenda.class );
        startActivity(i);
    }
}
