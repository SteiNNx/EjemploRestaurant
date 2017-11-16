package cl.labs.steinnx.sanguchote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUOC on 15-11-2017.
 */

public class DetalleCompra {

    @SerializedName("idCompra")
    private Compra compra;
    @SerializedName("idProducto")
    private Producto producto;
    @SerializedName("cantidad")
    private int cantidad;

    public DetalleCompra() {

    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
