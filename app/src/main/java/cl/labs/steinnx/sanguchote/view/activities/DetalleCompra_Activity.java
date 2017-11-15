package cl.labs.steinnx.sanguchote.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CL_DetalleCompra;
import cl.labs.steinnx.sanguchote.model.ColeccionCarrito;
import cl.labs.steinnx.sanguchote.model.adapter.DetalleCarritoAdapter;
import cl.labs.steinnx.sanguchote.model.adapter.ProductosAdapter;

public class DetalleCompra_Activity extends AppCompatActivity {

    private DetalleCarritoAdapter carritoAdapter;
    private Button btn_finalizar;
    private RecyclerView rv_carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);
        rv_carrito = (RecyclerView) findViewById(R.id.rv_detalle_detalle_compra);
        btn_finalizar = (Button) findViewById(R.id.btn_finalizar);

        ArrayList<CL_DetalleCompra> listaCarrito= ColeccionCarrito.obtenerProductos();
        if (listaCarrito!=null){
            carritoAdapter = new DetalleCarritoAdapter(listaCarrito,getApplicationContext());
            rv_carrito.setAdapter(carritoAdapter);
            rv_carrito.setHasFixedSize(true);
            final GridLayoutManager glm= new GridLayoutManager(getApplicationContext(),1);
            rv_carrito.setLayoutManager(glm);
        }else{
            Toast.makeText(this, "Añada Productos", Toast.LENGTH_SHORT).show();
        }


    }

}
