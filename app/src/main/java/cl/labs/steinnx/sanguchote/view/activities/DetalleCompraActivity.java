package cl.labs.steinnx.sanguchote.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import cl.labs.steinnx.sanguchote.R;

public class DetalleCompraActivity extends AppCompatActivity {
    private String idCompra;
    private RecyclerView rv_listar_detComp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra2);
        Bundle extras = getIntent().getExtras();
        idCompra= extras.getString("id_compra");
        rv_listar_detComp= (RecyclerView) findViewById(R.id.rv_act_det_comp);
        

    }
}
