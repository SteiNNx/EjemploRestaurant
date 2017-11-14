package cl.labs.steinnx.sanguchote.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DUOC on 14-11-2017.
 */

public interface API_Usuario_Interface {

    @GET("Usuario/obtener_usuario.php")
    Call<UsuarioResponse> listaUsuarios();


    @GET("Usuario/obtener_usuario.php")
    Call<UsuarioResponse> loginUsuario(@Query("usuario") String p_nombre, @Query("contrasena") String p_pass);
}
