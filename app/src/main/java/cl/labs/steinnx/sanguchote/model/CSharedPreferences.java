package cl.labs.steinnx.sanguchote.model;

/**
 * Created by DUOC on 15-11-2017.
 */

public class CSharedPreferences {
    private static Usuario usuario;

    public CSharedPreferences() {
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        CSharedPreferences.usuario = usuario;
    }
}
