package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tesis.tse.tse_instructivojrv.modelo.Actividad;
import com.tesis.tse.tse_instructivojrv.modelo.Fase;

/**
 * Created by Neophyte Coder on 20/12/16.
 */
public class AgendaGridHeaderAdapter extends RecyclerView.Adapter<AgendaGridHeaderHolder> {


    private Fase[] items;

    private Context mContext;

    public AgendaGridHeaderAdapter(Context context, Fase[] items) {
        this.items = items;

        mContext = context;

    }

    @Override
    public AgendaGridHeaderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agenda_grid_header_item, parent, false);
        return new AgendaGridHeaderHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(AgendaGridHeaderHolder holder, int position) {
        holder.populateItems(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
