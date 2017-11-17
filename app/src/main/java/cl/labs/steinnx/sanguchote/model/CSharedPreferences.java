package cl.labs.steinnx.sanguchote.model;

/**
 * Created by DUOC on 15-11-2017.
 */

public class CSharedPreferences {
    private static Usuario usuario;
    private static int id_compra;
    public CSharedPreferences() {
    }

    public static int getId_compra() {
        return id_compra;
    }

    public static void setId_compra(int id_compra) {
        CSharedPreferences.id_compra = id_compra;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        CSharedPreferences.usuario = usuario;
    }
}
