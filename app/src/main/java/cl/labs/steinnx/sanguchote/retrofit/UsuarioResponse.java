package cl.labs.steinnx.sanguchote.retrofit;

import com.google.gson.annotations.SerializedName;

import cl.labs.steinnx.sanguchote.model.Usuario;

/**
 * Created by DUOC on 14-11-2017.
 */

public class UsuarioResponse {

    @SerializedName("estado")
    private int estado;
    @SerializedName("usuario")
    Usuario usuario;

    public UsuarioResponse(int estado, Usuario getUsuarios) {
        this.estado = estado;
        this.usuario = getUsuarios;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
