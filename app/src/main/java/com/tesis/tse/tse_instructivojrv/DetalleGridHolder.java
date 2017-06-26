package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tesis.tse.tse_instructivojrv.modelo.Detalle;

/**
 * Created by Neophyte Coder on 20/12/16.
 */
public class DetalleGridHolder extends RecyclerView.ViewHolder {
    private ImageView imagen_d;
    private TextView texto_d;

    private Context mContext;

    public DetalleGridHolder(View itemView, Context context) {
        super(itemView);

        mContext = context;

        imagen_d = (ImageView) itemView.findViewById(R.id.imagen_d);
        texto_d = (TextView) itemView.findViewById(R.id.texto_d);
    }

    public void populateItems(Detalle items) {
        if(items.getImagen()!=0) {
            Glide.with(mContext).load(items.getImagen()).into(imagen_d);
        }else{
            imagen_d.setVisibility(View.GONE);
        }
        texto_d.setText(" - "+items.getTexto());
    }
}
