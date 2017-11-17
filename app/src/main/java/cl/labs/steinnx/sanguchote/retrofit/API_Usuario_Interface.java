package cl.labs.steinnx.sanguchote.retrofit;

import cl.labs.steinnx.sanguchote.model.Compra;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    //Metodos Compra
    @GET("Compra/obtener_compras_usuario.php")
    Call<ComprasResponse> listadoCompras_usuario(@Query("id_usuario") String p_id);
    @POST("Compra/insertar_compra.php")
    Call<ComprasResponse> insertarCompra(@Body Compra compra);


    //Metodos DetalleCompra
    @POST("Pedido/insertar_detalle.php")
    Call<DetalleCompraResponse> insertarDetalleCompra(@Body DetalleCompra detalleCompra);

}
