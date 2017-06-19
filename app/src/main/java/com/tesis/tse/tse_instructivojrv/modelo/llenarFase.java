package com.tesis.tse.tse_instructivojrv.modelo;

import android.content.Context;
import android.database.Cursor;

import com.tesis.tse.tse_instructivojrv.DAO;

import java.util.ArrayList;

/**
 * Created by cArLos on 18/6/2017.
 */

public class llenarFase {
    private static DAO myDb;

    public static Fase[] getFase(Context context, int fase_id) {
        ArrayList<Fase> faseLista = new ArrayList();
        Fase[] faseArreglo = null;
        try {
            myDb = new DAO(context);
            myDb.createDataBase();
            Cursor res = myDb.consultaSQL("SELECT f.nombre, f.nombre_imgico, f.fase_id, f.nombre_tab  FROM tse_fase f INNER JOIN tse_actividad a ON f.fase_id = a.fase_id WHERE f.fase_id="+fase_id+" GROUP BY f.fase_id");
            if (res.getCount() == 0) {
                return null;
            }
            while (res.moveToNext()) {
                Fase fase = new Fase(
                        res.getString(0),
                        context.getResources().getIdentifier(res.getString(1), "drawable",context.getPackageName()),
                        Integer.parseInt(res.getString(2)),
                        res.getString(3)
                ); //la pos 5 me entrega el count de detalles al ser diferente de 0 es true
                faseLista.add(fase);
            }
            res.close();
            faseArreglo = faseLista.toArray(new Fase[faseLista.size()]);
        } catch (Exception e) {
        }
        return faseArreglo;
    }
}
