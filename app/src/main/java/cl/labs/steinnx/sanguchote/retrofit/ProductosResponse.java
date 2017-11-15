package cl.labs.steinnx.sanguchote.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import cl.labs.steinnx.sanguchote.model.CL_Producto;

/**
 * Created by LC1300XXXX on 14/11/2017.
 */

public class ProductosResponse {

    @SerializedName("estado")
    private int estado;
    @SerializedName("usuarios")
    private List<CL_Producto> listaProductos;

    public ProductosResponse(List<CL_Producto> listaUsuarios, int estado) {
        this.listaProductos = listaUsuarios;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<CL_Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<CL_Producto> listaUsuarios) {
        this.listaProductos = listaUsuarios;
    }
}
