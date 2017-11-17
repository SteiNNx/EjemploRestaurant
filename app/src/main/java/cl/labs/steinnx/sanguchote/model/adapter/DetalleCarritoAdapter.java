package cl.labs.steinnx.sanguchote.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;

/**
 * Created by DUOC on 15-11-2017.
 */

public class DetalleCarritoAdapter extends RecyclerView.Adapter<DetalleCarritoAdapter.DetalleCarritoViewHolder> {

    private ArrayList<DetalleCompra> dataSource;
    private Context context;

    public DetalleCarritoAdapter(ArrayList<DetalleCompra> detSource, Context context) {
        dataSource= detSource;
        this.context = context;
    }

    @Override
    public DetalleCarritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listar_detalle_carrito,parent,false);
        return new DetalleCarritoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(DetalleCarritoViewHolder holder, int position) {
        DetalleCompra detalleCompra = dataSource.get(position);
        holder.tv_nombre.setText(detalleCompra.getProducto().getNombre().toString());
        holder.tv_cantidad.setText(String.valueOf(detalleCompra.getCantidad()));
        holder.tv_precio.setText(String.valueOf(detalleCompra.getProducto().getPrecio()));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class DetalleCarritoViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_nombre,tv_cantidad,tv_precio;
        public DetalleCarritoViewHolder(View itemView) {
            super(itemView);
            tv_precio = (TextView) itemView.findViewById(R.id.tv_carrito_precio);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_carrito_nombre);
            tv_cantidad = (TextView) itemView.findViewById(R.id.tv_carrito_cantidad);
        }
    }
}
