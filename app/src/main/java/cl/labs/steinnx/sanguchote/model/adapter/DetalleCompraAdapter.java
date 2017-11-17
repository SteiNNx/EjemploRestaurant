package cl.labs.steinnx.sanguchote.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;

/**
 * Created by SteinnxLabs on 17/11/2017.
 */

public class DetalleCompraAdapter extends RecyclerView.Adapter<DetalleCompraAdapter.DetalleCompraViewHolder> {

    private ArrayList<DetalleCompra> dataSource;
    private Context context;

    public DetalleCompraAdapter(Context context) {
        dataSource= new ArrayList<>();
        this.context = context;
    }

    @Override
    public DetalleCompraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listar_detalle_compra,parent,false);
        return new DetalleCompraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetalleCompraViewHolder holder, int position) {
        DetalleCompra detalleCompra = dataSource.get(position);
        holder.tv_nombre.setText("Producto: "+detalleCompra.getProducto().getNombre());
        holder.tv_precio.setText("Precio: "+detalleCompra.getProducto().getPrecio());
        holder.tv_cantidad.setText("Cantidad: "+detalleCompra.getCantidad());
        Picasso.with(context).load(detalleCompra.getProducto().getUrlImagen()).into(holder.iv_logo);
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class DetalleCompraViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_logo;
        private TextView tv_nombre,tv_cantidad,tv_precio;
        public DetalleCompraViewHolder(View itemView) {
            super(itemView);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_detalle_compra);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_detalle_compra_nom_pro);
            tv_cantidad = (TextView) itemView.findViewById(R.id.tv_detalle_compra_cant);
            tv_precio = (TextView) itemView.findViewById(R.id.tv_detalle_compra_precio);
        }
    }
}
