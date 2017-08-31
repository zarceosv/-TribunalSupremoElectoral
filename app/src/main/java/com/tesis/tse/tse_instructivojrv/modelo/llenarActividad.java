package com.tesis.tse.tse_instructivojrv.modelo;

import com.tesis.tse.tse_instructivojrv.DAO;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cArLos on 11/6/2017.
 */

public class llenarActividad {
    private static DAO myDb;

    public static Actividad[] getActividadFase(Context context,Integer id_fase) {
        ArrayList<Actividad> actividadesLista = new ArrayList();
        Actividad[] actividadesArreglo = null;
        try {
            myDb = new DAO(context);
            Cursor res = myDb.consultaSQL("SELECT f.nombre,a.titulo, a.descripcion,a.nombre_imgico,a.orden,COUNT(d.detalle_id),a.actividad_id, a.hora_inicio, a.hora_fin FROM tse_fase f INNER JOIN tse_actividad a ON f.fase_id = a.fase_id LEFT JOIN tse_actividad_x_detalle axd ON axd.actividad_id = a.actividad_id LEFT JOIN tse_detalle d ON d.detalle_id = axd.detalle_id AND d.activo = 1 WHERE a.activo = 1 AND f.fase_id = "+id_fase+" GROUP BY f.fase_id, a.actividad_id ORDER BY a.orden ASC");
            if (res.getCount() == 0) {
                return null;
            }
            while (res.moveToNext()) {
                Actividad actividad = new Actividad(
                        res.getString(0),
                        res.getString(1),
                        res.getString(2),
                        context.getResources().getIdentifier(res.getString(3), "drawable",context.getPackageName()),
                        Integer.parseInt(res.getString(4)),
                        !res.getString(5).equalsIgnoreCase("0"),
                        Integer.parseInt(res.getString(6)),
                        res.getString(7),
                        res.getString(8)
                        ); //la pos 5 me entrega el count de detalles al ser diferente de 0 es true
                actividadesLista.add(actividad);
            }
            res.close();
            actividadesArreglo = actividadesLista.toArray(new Actividad[actividadesLista.size()]);
        } catch (Exception e) {
        }
        return actividadesArreglo;
    }

    public static Actividad[] getActividadAgendaXFase(Context context,Integer id_fase) {

        ArrayList<Actividad> actividadesLista = new ArrayList();
        Actividad[] actividadesArreglo = null;
        try {
            myDb = new DAO(context);
            myDb.createDataBase();
            Cursor res = myDb.consultaSQL("SELECT f.nombre,a.titulo, a.descripcion,a.nombre_imgico,a.orden,COUNT(axd.actividad_x_detalle_id),a.actividad_id, a.hora_inicio, a.hora_fin FROM tse_fase f INNER JOIN tse_actividad a ON f.fase_id = a.fase_id LEFT JOIN tse_actividad_x_detalle axd ON axd.actividad_id = a.actividad_id WHERE a.activo = 1 and f.activo = 1 GROUP BY f.fase_id, a.actividad_id ORDER BY a.orden" );
            if (res.getCount() == 0) {
                return null;
            }
            while (res.moveToNext()) {
                Actividad actividad = new Actividad(
                        res.getString(0),
                        res.getString(1),
                        res.getString(2),
                        context.getResources().getIdentifier(res.getString(3), "drawable",context.getPackageName()),
                        Integer.parseInt(res.getString(4)),
                        !res.getString(5).equalsIgnoreCase("0"),
                        Integer.parseInt(res.getString(6)),
                        res.getString(7),
                        res.getString(8)
                ); //la pos 5 me entrega el count de detalles al ser diferente de 0 es true
                actividadesLista.add(actividad);
            }
            res.close();
            actividadesArreglo = actividadesLista.toArray(new Actividad[actividadesLista.size()]);
        } catch (Exception e) {

        }
        return actividadesArreglo;
    }
}
