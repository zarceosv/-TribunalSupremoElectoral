package com.tesis.tse.tse_instructivojrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tesis.tse.tse_instructivojrv.modelo.llenarDetalle;

public class ActivityDescripcion extends AppCompatActivity {
    private static DAO myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        Bundle datos = this.getIntent().getExtras();
        Integer id_actividad = datos.getInt("id_actividad");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        recyclerSetup(recyclerView,id_actividad);
    }

    private void recyclerSetup(RecyclerView recyclerView,int id_actividad) {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(new DetalleGridAdapter(this, llenarDetalle.getDetalle(this, id_actividad)));
    }
}
