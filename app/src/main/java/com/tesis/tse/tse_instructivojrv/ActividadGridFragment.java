package com.tesis.tse.tse_instructivojrv;

import com.tesis.tse.tse_instructivojrv.modelo.*;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class ActividadGridFragment extends Fragment {
    /**
     * Argumento que representa el número sección al que pertenece
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    // variable to hold context
    private Context context;

    //save the context recievied via constructor in a local variable
    public void setContexto(Context context){
        this.context=context;
    }
    /**
     * Creación prefabricada de un {@link ActividadGridFragment}
     */
    public static ActividadGridFragment newInstance(int sectionNumber) {
        ActividadGridFragment fragment = new ActividadGridFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ActividadGridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.actividad_fragment_main, container, false);
        // Obtención del grid view plugin compile 'in.srain.cube:grid-view-with-header-footer:1.0.12'
        GridViewWithHeaderAndFooter grid = (GridViewWithHeaderAndFooter) rootView.findViewById(R.id.gridview);

        // Inicializar el grid view
        setUpGridView(grid);

        return rootView;
    }

    /**
     * Infla el grid view del fragmento dependiendo de la sección
     *
     * @param grid Instancia del grid view
     */
    private void setUpGridView(GridViewWithHeaderAndFooter grid) {
        int section_number = getArguments().getInt(ARG_SECTION_NUMBER);
        grid.addHeaderView(createHeaderView(llenarFase.getFase(getActivity(),section_number)));
        grid.setAdapter(new ActividadGridAdapter(getActivity(), llenarActividad.getActividadFase(getActivity(),section_number)));
    }

    /**
     * Crea un view de cabecera para mostrarlo en el principio del grid view.
     *
     *
     * @param items    Array de productos
     * @return Header View
     */
    private View createHeaderView(Fase[] items) {

        View view;

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.actividad_grid_header, null, false);

        Fase item = items[0];

        // Seteando Imagen
        ImageView image = (ImageView) view.findViewById(R.id.imagen);
        Glide.with(image.getContext()).load(item.getImagen()).into(image);

        // Seteando Nombre
        TextView name = (TextView) view.findViewById(R.id.nombre);
        name.setText(item.getNombre());

        return view;
    }
}

