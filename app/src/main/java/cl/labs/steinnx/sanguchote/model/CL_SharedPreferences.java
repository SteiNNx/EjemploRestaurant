package cl.labs.steinnx.sanguchote.model;

/**
 * Created by DUOC on 15-11-2017.
 */

public class CL_SharedPreferences {
    private static CL_Usuario usuario;

    public CL_SharedPreferences() {
    }

    public static CL_Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(CL_Usuario usuario) {
        CL_SharedPreferences.usuario = usuario;
    }
}
