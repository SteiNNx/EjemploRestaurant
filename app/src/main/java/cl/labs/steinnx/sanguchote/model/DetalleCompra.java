package cl.labs.steinnx.sanguchote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUOC on 15-11-2017.
 */

public class DetalleCompra {

    @SerializedName("idCompra")
    private Compra idCompra;
    @SerializedName("idProducto")
    private Producto idProducto;
    @SerializedName("cantidad")
    private int cantidad;

    public DetalleCompra() {

    }

    public Compra getCompra() {
        return idCompra;
    }

    public void setCompra(Compra compra) {
        this.idCompra = compra;
    }

    public Producto getProducto() {
        return idProducto;
    }

    public void setProducto(Producto producto) {
        this.idProducto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
