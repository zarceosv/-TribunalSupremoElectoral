package com.tesis.tse.tse_instructivojrv;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class ActivityMain extends AppCompatActivity {
    Button btn;
    DAO mi_baseDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        /*--------- Instanciando base de datos ----------*/
        mi_baseDatos = new DAO(this);
        verDataBase();
        /*--------- Fin Instanciando base de datos ------*/

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

    /*--------- Verifica si existe si no la crea ------*/
    public void verDataBase(){
        try {
            mi_baseDatos.createDataBase();
        } catch (IOException e) {
        }
    }
    /*--------- Fin Verifica si existe si no la crea --*/

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

    public void pasoPaso(View view) {
        Intent i = new Intent(this, manual_paso_paso.class );
        startActivity(i);

    }


    /*--------- Esto se va a borrar -----------------------*/
    public void comprobarConsultaSQL(){
        try{
            Cursor res = mi_baseDatos.consultaSQL("SELECT f.nombre, a.titulo, a.descripcion, d.texto\n" +
                    "FROM tse_fase f\n" +
                    "LEFT JOIN tse_actividad a ON a.fase_id = f.fase_id \n" +
                    "LEFT JOIN tse_actividad_x_detalle axd ON axd.actividad_id = a.actividad_id\n" +
                    "LEFT JOIN tse_detalle d ON axd.detalle_id = d.detalle_id\n");
            if(res.getCount() == 0){
                showMessage("Error","Nothing foind");
                return;
            }

            StringBuffer buffer = new StringBuffer();
            while (res.moveToNext()){
                buffer.append("Fase:"+res.getString(0)+"\n");
                buffer.append("Titulo:"+res.getString(1)+"\n");
                buffer.append("Actividad:"+res.getString(2)+"\n");
                buffer.append("Descripción:"+res.getString(3)+"\n");
                buffer.append("------------------\n");
            }

            showMessage("Data",buffer.toString());
        }catch (Exception e){
            showMessage("Data","error en leer los datos");
        }
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    /*--------- Fin Esto se va a borrar -------------------*/
}
