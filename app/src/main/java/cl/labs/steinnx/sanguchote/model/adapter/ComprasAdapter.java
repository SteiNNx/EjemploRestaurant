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
import cl.labs.steinnx.sanguchote.model.Compra;
import cl.labs.steinnx.sanguchote.model.DetalleCompra;
import cl.labs.steinnx.sanguchote.retrofit.ComprasResponse;

/**
 * Created by LC1300XXXX on 16/11/2017.
 */

public class ComprasAdapter extends RecyclerView.Adapter<ComprasAdapter.ComprasViewHolder>{

    private ArrayList<Compra> dataSource;
    private Context context;

    public ComprasAdapter(Context context) {
        dataSource=new ArrayList<>();
        this.context = context;
    }
    @Override
    public ComprasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listar_compra,parent,false);
        return new ComprasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComprasViewHolder holder, int position) {

        final Compra compra = dataSource.get(position);
        holder.tv_id_compra.setText(String.valueOf(compra.getId_compra()));
        holder.tv_fecha.setText(compra.getFecha_compra());
        holder.tv_nombre.setText(compra.getUsuario().getNombre()+" "+compra.getUsuario().getApellido());
        holder.tv_precio.setText(String.valueOf(compra.getPago()));

    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public void addiccionarDatos(List<Compra> list) {
        dataSource.addAll(list);
        notifyDataSetChanged();
    }

    public class ComprasViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_id_compra,tv_nombre,tv_fecha,tv_precio;
        public ComprasViewHolder(View itemView) {
            super(itemView);
            tv_id_compra = (TextView) itemView.findViewById(R.id.tv_frag_pedido_idped);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_frag_pedido_nombre_completo);
            tv_fecha = (TextView) itemView.findViewById(R.id.tv_frag_pedido_fecha);
            tv_precio= (TextView) itemView.findViewById(R.id.tv_frag_pedido_precio);
        }
    }
}
