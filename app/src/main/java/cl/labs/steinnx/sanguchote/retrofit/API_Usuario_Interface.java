package cl.labs.steinnx.sanguchote.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DUOC on 14-11-2017.
 */

public interface API_Usuario_Interface {

    //Metodos USUARIO
    //Lista de usuarios
    @GET("Usuario/obtener_usuario.php")
    Call<UsuarioResponse> listaUsuarios();
    //objeto usuario por user y pass
    @GET("Usuario/obtener_usuario_login.php")
    Call<UsuarioResponse> loginUsuario(@Query("usuario") String p_nombre, @Query("contrasena") String p_pass);

    //Metodos Productos
    @GET("Producto/obtener_productos.php")
    Call<ProductosResponse> listaProductos();
}
