package com.tesis.tse.tse_instructivojrv;

import com.tesis.tse.tse_instructivojrv.modelo.Actividad;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * {@link BaseAdapter} personalizado para el gridview
 */
public class ActividadGridAdapter extends BaseAdapter {

    private final Context mContext;
    private final Actividad[] items;

    public ActividadGridAdapter(Context c, Actividad[] items) {
        mContext = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        // Decremento en 1, para no contar el header view
        return items.length;
    }

    @Override
    public Actividad getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.actividad_grid_item, viewGroup, false);
        }

        final Actividad item = getItem(position);

        // Seteando Imagen
        ImageView image = (ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getImagen()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getTitulo());

        // Seteando Descripción
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getDescripcion());

        // Seteando Leermas
        TextView Leermas = (TextView) view.findViewById(R.id.leermas);
        if(item.isDetalle()) {
            Leermas.setText("Leer más...");
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mContext, ActivityDescripcion.class );
                    i.putExtra("id_actividad", item.getId());
                    mContext.startActivity(i);
                }
            });
        }else {
            Leermas.setText("");
        }
        return view;
    }
}
