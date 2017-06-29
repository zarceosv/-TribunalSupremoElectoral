package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tesis.tse.tse_instructivojrv.modelo.Actividad;
import com.tesis.tse.tse_instructivojrv.modelo.Detalle;

/**
 * Created by Neophyte Coder on 20/12/16.
 */
public class AgendaGridHolder extends RecyclerView.ViewHolder {
    private TextView hora;
    private TextView detalle;
    private TextView fase;

    private Context mContext;

    public AgendaGridHolder(View itemView, Context context) {
        super(itemView);

        mContext = context;

        hora = (TextView) itemView.findViewById(R.id.txt_hora_agenda);
        detalle = (TextView) itemView.findViewById(R.id.txt_detalle_agenda);
        fase = (TextView) itemView.findViewById(R.id.txt_nombre_fase_agenda);
    }

    public void populateItems(Actividad items) {

        hora.setText("I: "+items.getHora_inicio()+"\n"+"F: "+items.getHora_fin());
        detalle.setText(items.getTitulo()+items.getDescripcion());
        fase.setText(items.getNombre_fase().toUpperCase());
    }
}
