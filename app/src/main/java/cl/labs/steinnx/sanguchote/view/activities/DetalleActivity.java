package cl.labs.steinnx.sanguchote.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CSharedPreferences;
import cl.labs.steinnx.sanguchote.model.adapter.DetalleCompraAdapter;
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

        tv_id_compra.setText(CSharedPreferences.getId_compra());

    }
}
