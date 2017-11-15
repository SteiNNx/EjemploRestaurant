package cl.labs.steinnx.sanguchote.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import cl.labs.steinnx.sanguchote.model.CL_Usuario;

/**
 * Created by DUOC on 14-11-2017.
 */

public class UsuarioResponse {

    @SerializedName("estado")
    private int estado;
    @SerializedName("usuario")
    CL_Usuario usuario;

    public UsuarioResponse(int estado, CL_Usuario getUsuarios) {
        this.estado = estado;
        this.usuario = getUsuarios;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public CL_Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(CL_Usuario usuario) {
        this.usuario = usuario;
    }
}
