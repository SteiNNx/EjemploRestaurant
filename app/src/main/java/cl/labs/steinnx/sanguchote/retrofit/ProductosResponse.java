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
    @SerializedName("usuario")
    private List<CL_Producto> listaUsuarios;

    public ProductosResponse(List<CL_Producto> listaUsuarios, int estado) {
        this.listaUsuarios = listaUsuarios;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<CL_Producto> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<CL_Producto> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
