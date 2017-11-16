package cl.labs.steinnx.sanguchote.model;

import java.util.ArrayList;

/**
 * Created by DUOC on 15-11-2017.
 */

public class ColeccionCarrito
{
    private static ArrayList<DetalleCompra> listaProductos = new ArrayList<>();

    public static void agregarPelicula(DetalleCompra pro)
    {
        if (listaProductos.isEmpty()){
            listaProductos.add(pro);
            return;
        }else{

        for (DetalleCompra det:listaProductos) {
            if (det.getProducto().getIdProducto()==pro.getProducto().getIdProducto()){
                int cant=pro.getCantidad()+det.getCantidad();
                pro.setCantidad(cant);
                listaProductos.remove(det);
                listaProductos.add(pro);
                return;
            }
            else{
                listaProductos.add(pro);
                return;
            }
        }
        }
    }

    public static ArrayList<DetalleCompra> obtenerProductos(){
        return listaProductos;
    }

}
