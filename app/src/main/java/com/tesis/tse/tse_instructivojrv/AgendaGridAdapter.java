package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tesis.tse.tse_instructivojrv.modelo.Actividad;
import com.tesis.tse.tse_instructivojrv.modelo.Detalle;

/**
 * Created by Neophyte Coder on 20/12/16.
 */
public class AgendaGridAdapter extends RecyclerView.Adapter<AgendaGridHolder> {


    private Actividad[] items;

    private Context mContext;

    public AgendaGridAdapter(Context context, Actividad[] items) {
        this.items = items;

        mContext = context;

    }

    @Override
    public AgendaGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agenda_grid_item, parent, false);
        return new AgendaGridHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(AgendaGridHolder holder, int position) {
        holder.populateItems(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
