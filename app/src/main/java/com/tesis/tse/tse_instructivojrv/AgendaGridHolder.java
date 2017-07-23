package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

        String hora_inicio = "";
        String hora_fin = "";
        String enter = "";
        Log.e("hora",items.getHora_inicio().toString());
        if(!items.getHora_inicio().toString().trim().matches(""))
            hora_inicio = "I: "+items.getHora_inicio();
        if(!items.getHora_fin().toString().trim().matches(""))
            hora_fin = "F: "+items.getHora_fin();
        if(hora_fin != "" && hora_inicio != "")
            enter = "\n";

        hora.setText(hora_inicio + enter + hora_fin);
        detalle.setText(items.getTitulo());
        fase.setText("  "+items.getNombre_fase().toUpperCase());
    }
}
