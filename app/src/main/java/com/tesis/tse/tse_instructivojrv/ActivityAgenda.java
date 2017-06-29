package com.tesis.tse.tse_instructivojrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.tesis.tse.tse_instructivojrv.modelo.llenarActividad;
import com.tesis.tse.tse_instructivojrv.modelo.llenarDetalle;
import com.tesis.tse.tse_instructivojrv.modelo.llenarFase;

import java.io.IOException;

public class ActivityAgenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_actividades);
        recyclerSetup(recyclerView,1);


    }

    private void recyclerSetup(RecyclerView recyclerView, Integer id_actividad) {
        try {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            recyclerView.setAdapter(new AgendaGridAdapter(this, llenarActividad.getActividadAgendaXFase(this, id_actividad)));
        }catch (Exception e){
            Log.d("men","no se q"+e.getMessage());
        }

    }

}
