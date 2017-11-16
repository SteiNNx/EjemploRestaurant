package cl.labs.steinnx.sanguchote.model.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;

/**
 * Created by LC1300XXXX on 15/11/2017.
 */

public class DetallePedidoAdapter extends RecyclerView.Adapter<DetallePedidoAdapter.DetallePedidoViewHolder> {

    private ArrayList<DetalleCompra> dataSource;
    private Context context;

    public DetallePedidoAdapter(Context context) {
        dataSource=new ArrayList<>();
        this.context = context;
    }

    @Override
    public DetallePedidoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listar_compra,parent,false);
        return new DetallePedidoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetallePedidoViewHolder holder, int position) {

        final  DetalleCompra detalleCompra = dataSource.get(position);
        holder.tv_id_compra.setText(String.valueOf(detalleCompra.getCompra().getId_compra()));
        holder.tv_nombre.setText(detalleCompra.getCompra().getUsuario().getNombre()+" "+detalleCompra.getCompra().getUsuario().getApellido());
        holder.tv_fecha.setText(detalleCompra.getCompra().getFecha_compra());
        holder.tv_precio.setText(String.valueOf(detalleCompra.getCompra().getPago()));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class DetallePedidoViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_id_compra,tv_nombre,tv_fecha,tv_precio;
        public DetallePedidoViewHolder(View itemView) {
            super(itemView);
            tv_id_compra = (TextView) itemView.findViewById(R.id.tv_frag_pedido_idped);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_frag_pedido_nombre_completo);
            tv_fecha = (TextView) itemView.findViewById(R.id.tv_frag_pedido_fecha);
            tv_precio= (TextView) itemView.findViewById(R.id.tv_frag_pedido_precio);
        }
    }
}
