package cl.labs.steinnx.sanguchote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUOC on 15-11-2017.
 */

public class CL_DetalleCompra {

    @SerializedName("idCompra")
    private CL_Compra compra;
    @SerializedName("idProducto")
    private CL_Producto producto;
    @SerializedName("cantidad")
    private int cantidad;

    public CL_DetalleCompra() {

    }

    public CL_Compra getCompra() {
        return compra;
    }

    public void setCompra(CL_Compra compra) {
        this.compra = compra;
    }

    public CL_Producto getProducto() {
        return producto;
    }

    public void setProducto(CL_Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
