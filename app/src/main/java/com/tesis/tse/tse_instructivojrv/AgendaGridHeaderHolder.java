package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tesis.tse.tse_instructivojrv.modelo.Actividad;
import com.tesis.tse.tse_instructivojrv.modelo.Fase;

/**
 * Created by Neophyte Coder on 20/12/16.
 */
public class AgendaGridHeaderHolder extends RecyclerView.ViewHolder {
    private TextView nombre_fase;


    private Context mContext;

    public AgendaGridHeaderHolder(View itemView, Context context) {
        super(itemView);

        mContext = context;

        nombre_fase = (TextView) itemView.findViewById(R.id.txt_fase_nombre);
    }

    public void populateItems(Fase items) {
        nombre_fase.setText(items.getNombre());

    }
}
