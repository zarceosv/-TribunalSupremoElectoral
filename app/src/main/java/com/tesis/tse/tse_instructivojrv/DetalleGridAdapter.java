package com.tesis.tse.tse_instructivojrv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tesis.tse.tse_instructivojrv.modelo.Detalle;

/**
 * Created by Neophyte Coder on 20/12/16.
 */
public class DetalleGridAdapter extends RecyclerView.Adapter<DetalleGridHolder> {
    private int[] items2;
    private String[] fruitsName;
    private Detalle[] items;

    private Context mContext;

    public DetalleGridAdapter(Context context, Detalle[] items) {
        this.items = items;

        int[] items2 = { R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
                R.drawable.logo_tse,
        };


        String[] fruitsName = {"Apota", "Apple", "Banana", "Grapes", "Guava", "Lemon", "Orange",
                "Papaya", "Pineapple", "Pomegranate", "Pomegranate", "Watermelon"};
        this.items2 = items2;
        this.fruitsName = fruitsName;

        mContext = context;

    }

    @Override
    public DetalleGridHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalle_grid_item, parent, false);
        return new DetalleGridHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(DetalleGridHolder holder, int position) {
        holder.populateItems(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}
