package com.tesis.tse.tse_instructivojrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tesis.tse.tse_instructivojrv.modelo.llenarDetalle;

public class ActivityDescripcion extends AppCompatActivity {
    private static DAO myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        Bundle datos = this.getIntent().getExtras();
        Integer id_actividad = datos.getInt("id_actividad");
        Integer id_imagen_actividad = datos.getInt("imagen_actividad");
        String Titulo = datos.getString("titulo_actividad");
        String Descripcion = datos.getString("descripcion_actividad");

        TextView titulo_text = (TextView) findViewById(R.id.titulo_actividad_d);
        titulo_text.setText(Titulo);

        TextView descripcion_text = (TextView) findViewById(R.id.descripcion_actividad_d);
        descripcion_text.setText(Descripcion);

        ImageView image = (ImageView) findViewById(R.id.imagen_actividad_d);
        Glide.with(image.getContext()).load(id_imagen_actividad).into(image);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerSetup(recyclerView,id_actividad);
    }

    private void recyclerSetup(RecyclerView recyclerView,int id_actividad) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(new DetalleGridAdapter(this, llenarDetalle.getDetalle(this, id_actividad)));
    }
}
