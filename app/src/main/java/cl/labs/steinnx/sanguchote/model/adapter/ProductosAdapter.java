package cl.labs.steinnx.sanguchote.model.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CL_Producto;

/**
 * Created by LC1300XXXX on 14/11/2017.
 */

public class ProductosAdapter extends  RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder> {


    private ArrayList<CL_Producto> dataSource;
    private Context context;

    public ProductosAdapter(Context context) {
        dataSource= new ArrayList<>();
        this.context = context;
    }

    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listar_productos,parent,false);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductosViewHolder holder, int position) {
        final CL_Producto producto = dataSource.get(position);
        Picasso.with(context).load(producto.getUrlImagen()).into(holder.iv_logo);
        holder.tv_nombre.setText(producto.getNombre());
        holder.tv_stock.setText("Stock: "+producto.getStock());
        holder.tv_precio.setText("Precio: "+producto.getPrecio());

        //Click del Item del RV
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creo Dialog a partir del xml dialog_comprar
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(R.layout.dialog_comprar,null);
                builder.setView(view);
                //Instancio Componentes del Dialog
                final TextView tv_cantidad = (TextView) view.findViewById(R.id.tv_dialog_cantidad);
                tv_cantidad.setText("0");
                ImageView iv_mas = (ImageView) view.findViewById(R.id.iv_dialog_mas);
                ImageView iv_menos = (ImageView) view.findViewById(R.id.iv_dialog_menos);
                iv_mas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cantidad(1);
                    }

                    private void cantidad(int cantidad) {
                            if ((Integer.parseInt(tv_cantidad.getText().toString())+cantidad)>0&(Integer.parseInt(tv_cantidad.getText().toString())+cantidad)<11){
                                tv_cantidad.setText(""+(Integer.parseInt(tv_cantidad.getText().toString())+cantidad));
                            }
                    }
                });
                iv_menos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cantidad(-1);
                    }

                    private void cantidad(int cantidad) {
                        if ((Integer.parseInt(tv_cantidad.getText().toString())+cantidad)>0&(Integer.parseInt(tv_cantidad.getText().toString())+cantidad)<11){
                            tv_cantidad.setText(""+(Integer.parseInt(tv_cantidad.getText().toString())+cantidad));
                        }
                    }
                });
                Button btn_comprar = (Button) view.findViewById(R.id.btn_dialog_comprar);

                builder.create().show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public void adiccionarProductos(List<CL_Producto> lista) {
        dataSource.addAll(lista);
        notifyDataSetChanged();
    }


    //View Holder Del Adapter
    public class ProductosViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_logo;
        private TextView tv_nombre,tv_stock,tv_precio;

        public ProductosViewHolder(View itemView) {
            super(itemView);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_list_pro_logo);
            tv_nombre = (TextView) itemView.findViewById(R.id.tv_item_list_pro_nombre_pro);
            tv_precio = (TextView) itemView.findViewById(R.id.tv_item_list_pro_precio);
            tv_stock = (TextView) itemView.findViewById(R.id.tv_item_list_pro_stock);
        }
    }
}
