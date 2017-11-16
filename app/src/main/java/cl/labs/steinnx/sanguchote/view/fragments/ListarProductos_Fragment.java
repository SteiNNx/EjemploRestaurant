package cl.labs.steinnx.sanguchote.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.Producto;
import cl.labs.steinnx.sanguchote.model.adapter.ProductosAdapter;
import cl.labs.steinnx.sanguchote.retrofit.API_Usuario_Interface;
import cl.labs.steinnx.sanguchote.retrofit.Instance;
import cl.labs.steinnx.sanguchote.retrofit.ProductosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListarProductos_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ListarProductos_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    //Declaro Objetos que Usare
    private RecyclerView rv_listarProductos;
    private ProductosAdapter productosAdapter;
    private Retrofit retrofit= new Instance().getConexion();

    public ListarProductos_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_listar_productos, container, false);

        rv_listarProductos = (RecyclerView) view.findViewById(R.id.rv_frag_listar_product);
        productosAdapter = new ProductosAdapter(getContext());
        rv_listarProductos.setAdapter(productosAdapter);
        rv_listarProductos.setHasFixedSize(true);
        final GridLayoutManager glm= new GridLayoutManager(container.getContext(),1);
        rv_listarProductos.setLayoutManager(glm);
        llenarRecicler();
        return view;
    }

    private void llenarRecicler() {
        API_Usuario_Interface services = retrofit.create(API_Usuario_Interface.class);
        Call<ProductosResponse> peliculasCall = services.listaProductos();
        peliculasCall.enqueue(new Callback<ProductosResponse>() {
            @Override
            public void onResponse(Call<ProductosResponse> call, Response<ProductosResponse> response) {
                if (response.isSuccessful()){
                    ProductosResponse productos = response.body();
                    Log.d("asdsd",""+productos.getEstado());
                    List<Producto> lista = productos.getListaProductos();
                    productosAdapter.adiccionarProductos(lista);
                }
            }

            @Override
            public void onFailure(Call<ProductosResponse> call, Throwable t) {

            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
