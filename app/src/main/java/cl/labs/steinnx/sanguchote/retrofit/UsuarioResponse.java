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
    @SerializedName("usuarios")
    List<CL_Usuario> getUsuarios;

    public UsuarioResponse(int estado, List<CL_Usuario> getUsuarios) {
        this.estado = estado;
        this.getUsuarios = getUsuarios;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<CL_Usuario> getGetUsuarios() {
        return getUsuarios;
    }

    public void setGetUsuarios(List<CL_Usuario> getUsuarios) {
        this.getUsuarios = getUsuarios;
    }
}
