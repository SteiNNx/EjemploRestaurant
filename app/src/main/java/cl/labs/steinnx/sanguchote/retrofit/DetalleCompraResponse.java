package cl.labs.steinnx.sanguchote.retrofit;

import com.google.gson.annotations.SerializedName;

import cl.labs.steinnx.sanguchote.model.DetalleCompra;

/**
 * Created by LC1300XXXX on 16/11/2017.
 */

public class DetalleCompraResponse {

    @SerializedName("estado")
    private int estado;
    private DetalleCompra detalleCompra;

    public DetalleCompraResponse(int estado, DetalleCompra detalleCompra) {
        this.estado = estado;
        this.detalleCompra = detalleCompra;
    }

    public DetalleCompra getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(DetalleCompra detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
