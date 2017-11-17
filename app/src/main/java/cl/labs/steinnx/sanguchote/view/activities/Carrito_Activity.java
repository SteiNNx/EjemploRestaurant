package cl.labs.steinnx.sanguchote.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CSharedPreferences;
import cl.labs.steinnx.sanguchote.model.Compra;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;
import cl.labs.steinnx.sanguchote.model.ColeccionCarrito;
import cl.labs.steinnx.sanguchote.model.adapter.DetalleCarritoAdapter;
import cl.labs.steinnx.sanguchote.retrofit.API_Usuario_Interface;
import cl.labs.steinnx.sanguchote.retrofit.ComprasResponse;
import cl.labs.steinnx.sanguchote.retrofit.DetalleCompraResponse;
import cl.labs.steinnx.sanguchote.retrofit.Instance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Carrito_Activity extends AppCompatActivity implements View.OnClickListener {

    private DetalleCarritoAdapter carritoAdapter;
    private Button btn_finalizar;
    private RecyclerView rv_carrito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);
        rv_carrito = (RecyclerView) findViewById(R.id.rv_detalle_detalle_compra);
        btn_finalizar = (Button) findViewById(R.id.btn_finalizar);

        ArrayList<DetalleCompra> listaCarrito= ColeccionCarrito.obtenerProductos();
        if (listaCarrito!=null){
            carritoAdapter = new DetalleCarritoAdapter(listaCarrito,getApplicationContext());
            rv_carrito.setAdapter(carritoAdapter);
            rv_carrito.setHasFixedSize(true);
            final GridLayoutManager glm= new GridLayoutManager(getApplicationContext(),1);
            rv_carrito.setLayoutManager(glm);
        }else{
            Toast.makeText(this, "Añada Productos", Toast.LENGTH_SHORT).show();
        }

        btn_finalizar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_finalizar){
            RealizarCompra();
        }
    }

    private void RealizarCompra() {
        if (!ColeccionCarrito.obtenerProductos().isEmpty()) {
            Compra compra = new Compra();
            compra.setUsuario(CSharedPreferences.getUsuario());
            int precio = 0;
            for (DetalleCompra pro : ColeccionCarrito.obtenerProductos()) {
                precio += (pro.getCantidad() * pro.getProducto().getPrecio());
            }
            compra.setPago(precio);

            final Retrofit retrofit = new Instance().getConexion();
            final API_Usuario_Interface servicio = retrofit.create(API_Usuario_Interface.class);
            Call<ComprasResponse> responseCall = servicio.insertarCompra(compra);
            responseCall.enqueue(new Callback<ComprasResponse>() {
                @Override
                public void onResponse(Call<ComprasResponse> call, Response<ComprasResponse> response) {
                    if (response.isSuccessful()) {
                        ComprasResponse comprasResponse = response.body();
                        Log.e("INSERTAR CARIIITO", "INSERTAR: " + comprasResponse.getEstado());
                        if (comprasResponse.getEstado() == 1) {
                            Toast.makeText(Carrito_Activity.this, "Compro", Toast.LENGTH_SHORT).show();
                            for (DetalleCompra det : ColeccionCarrito.obtenerProductos()) {
                                Call<DetalleCompraResponse> detalleCompraResponseCall = servicio.insertarDetalleCompra(det);
                                detalleCompraResponseCall.enqueue(new Callback<DetalleCompraResponse>() {
                                    @Override
                                    public void onResponse(Call<DetalleCompraResponse> call, Response<DetalleCompraResponse> response) {
                                        if (response.isSuccessful()) {
                                            DetalleCompraResponse detalleCompraResponse = response.body();
                                        } else {
                                            Log.e("ERRORRRRR!!!!!!!!!!!!!!", "onResponeseeeeeeeeeeee: " + response.errorBody());
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<DetalleCompraResponse> call, Throwable t) {
                                        Log.e("ERRORRRRR!!!!!!!!!!!!!!", "onFailureeeeeeeeeee: " + t.getMessage());
                                    }
                                });
                            }
                            ColeccionCarrito.obtenerProductos().clear();
                        } else if (comprasResponse.getEstado() == 2) {
                            Toast.makeText(Carrito_Activity.this, "No Compro", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.e("ERRORRRRR!!!!!!!!!!!!!!", "onResponeseeeeeeeeeeee: " + response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<ComprasResponse> call, Throwable t) {
                    Log.e("ERRORRRRR!!!!!!!!!!!!!!", "onFailureeeeeeeeeee: " + t.getMessage());
                }
            });
        }else {
            Toast.makeText(this, "Agrege Productos al Carrito :)", Toast.LENGTH_SHORT).show();
        }
    }
}
