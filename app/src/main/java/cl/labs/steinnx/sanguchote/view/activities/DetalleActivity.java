package cl.labs.steinnx.sanguchote.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CSharedPreferences;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;
import cl.labs.steinnx.sanguchote.model.adapter.DetalleCompraAdapter;
import cl.labs.steinnx.sanguchote.retrofit.API_Usuario_Interface;
import cl.labs.steinnx.sanguchote.retrofit.DetalleComprasResponse;
import cl.labs.steinnx.sanguchote.retrofit.Instance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetalleActivity extends AppCompatActivity {

    private DetalleCompraAdapter detalleCompraAdapter;
    private RecyclerView rv_listar;
    private Retrofit retrofit;
    private TextView tv_id_compra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tv_id_compra = (TextView) findViewById(R.id.tv_detalle_act_id_compr);
        rv_listar = (RecyclerView) findViewById(R.id.rv_det_compr_activ);

        tv_id_compra.setText("Productos de la Compra: "+String.valueOf(CSharedPreferences.getId_compra()));
        detalleCompraAdapter = new DetalleCompraAdapter(getApplicationContext());
        rv_listar.setAdapter(detalleCompraAdapter);
        rv_listar.setHasFixedSize(true);
        final GridLayoutManager glm = new GridLayoutManager(getApplicationContext(),1);
        rv_listar.setLayoutManager(glm);
        llenarRecycler();
    }

    private void llenarRecycler() {
        retrofit = new Instance().getConexion();
        API_Usuario_Interface serv = retrofit.create(API_Usuario_Interface.class);
        Call<DetalleComprasResponse> responseCall = serv.listadoDetalle(String.valueOf(CSharedPreferences.getId_compra()));
        responseCall.enqueue(new Callback<DetalleComprasResponse>() {
            @Override
            public void onResponse(Call<DetalleComprasResponse> call, Response<DetalleComprasResponse> response) {
                if (response.isSuccessful()){
                    DetalleComprasResponse det = response.body();
                    List<DetalleCompra> list = det.getDetalleCompras();
                    detalleCompraAdapter.addiccionarDatos(list);
                }
            }
            @Override
            public void onFailure(Call<DetalleComprasResponse> call, Throwable t) {
            }
        });
    }
}
