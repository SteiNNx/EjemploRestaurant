package cl.labs.steinnx.sanguchote.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUOC on 15-11-2017.
 */

public class CL_Compra {

    @SerializedName("id_compra")
    private int id_compra;
    @SerializedName("id_usuario")
    private CL_Usuario usuario;
    @SerializedName("fecha_compra")
    private String fecha_compra;
    @SerializedName("total_pago")
    private int pago;

    public CL_Compra() {
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public CL_Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(CL_Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }
}