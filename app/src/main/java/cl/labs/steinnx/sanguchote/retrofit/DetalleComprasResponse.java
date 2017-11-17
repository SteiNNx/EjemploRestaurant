package cl.labs.steinnx.sanguchote.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import cl.labs.steinnx.sanguchote.model.DetalleCompra;

/**
 * Created by SteinnxLabs on 17/11/2017.
 */

public class DetalleComprasResponse {
    @SerializedName("estado")
    private int estado;
    @SerializedName("detalles")
    private List<DetalleCompra> detalleCompras;

    public DetalleComprasResponse(int estado, List<DetalleCompra> detalleCompras) {
        this.estado = estado;
        this.detalleCompras = detalleCompras;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<DetalleCompra> getDetalleCompras() {
        return detalleCompras;
    }

    public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }
}
