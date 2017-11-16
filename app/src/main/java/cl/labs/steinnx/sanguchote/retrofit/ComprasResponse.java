package cl.labs.steinnx.sanguchote.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import cl.labs.steinnx.sanguchote.model.Compra;

/**
 * Created by LC1300XXXX on 15/11/2017.
 */

public class ComprasResponse {
    @SerializedName("estado")
    private int estado;
    @SerializedName("compras")
    private List<Compra> listadoCompras;

    public ComprasResponse(int idEstado, List<Compra> listadoCompras) {
        this.estado = idEstado;
        this.listadoCompras = listadoCompras;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int idEstado) {
        this.estado = idEstado;
    }

    public List<Compra> getListadoCompras() {
        return listadoCompras;
    }

    public void setListadoCompras(List<Compra> listadoCompras) {
        this.listadoCompras = listadoCompras;
    }
}
