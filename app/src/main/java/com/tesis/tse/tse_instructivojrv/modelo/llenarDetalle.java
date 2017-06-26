package com.tesis.tse.tse_instructivojrv.modelo;

import android.content.Context;
import android.database.Cursor;

import com.tesis.tse.tse_instructivojrv.DAO;

import java.util.ArrayList;

/**
 * Created by cArLos on 25/6/2017.
 */

public class llenarDetalle {
    private static DAO myDb;

    public static Detalle[] getDetalle(Context context, int actividad_id) {
        ArrayList<Detalle> detalleLista = new ArrayList();
        Detalle[] detalleArreglo = null;
        try {
            myDb = new DAO(context);
            myDb.createDataBase();
            Cursor res = myDb.consultaSQL("\n" +
                    "SELECT d.detalle_id, d.texto, d.nombre_imgico, d.orden FROM tse_detalle d INNER JOIN tse_actividad_x_detalle axd ON axd.detalle_id = d.detalle_id WHERE axd.actividad_id = "+actividad_id);
            if (res.getCount() == 0) {
                return null;
            }
            while (res.moveToNext()) {
                Detalle fase = new Detalle(
                        Integer.parseInt(res.getString(0)),
                        res.getString(1),
                        context.getResources().getIdentifier(res.getString(2), "drawable",context.getPackageName()),
                        Integer.parseInt(res.getString(3))
                ); //la pos 5 me entrega el count de detalles al ser diferente de 0 es true
                detalleLista.add(fase);
            }
            res.close();
            detalleArreglo = detalleLista.toArray(new Detalle[detalleLista.size()]);
        } catch (Exception e) {

        }
        return detalleArreglo;
    }
}
