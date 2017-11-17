package cl.labs.steinnx.sanguchote.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CSharedPreferences;
import cl.labs.steinnx.sanguchote.model.Compra;
import cl.labs.steinnx.sanguchote.model.adapter.ComprasAdapter;
import cl.labs.steinnx.sanguchote.retrofit.API_Usuario_Interface;
import cl.labs.steinnx.sanguchote.retrofit.ComprasResponse;
import cl.labs.steinnx.sanguchote.retrofit.Instance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListarPedidos_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ListarPedidos_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView rv_listar_pedido;
    private ComprasAdapter comprasAdapter;
    private Retrofit retrofit= new Instance().getConexion();


    public ListarPedidos_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_listar_pedidos, container, false);
        rv_listar_pedido = (RecyclerView) view.findViewById(R.id.rv_frag_listar_pedidos);
        comprasAdapter=new ComprasAdapter(getContext());
        rv_listar_pedido.setAdapter(comprasAdapter);
        rv_listar_pedido.setHasFixedSize(true);
        final GridLayoutManager glm = new GridLayoutManager(container.getContext(),1);
        rv_listar_pedido.setLayoutManager(glm);
        llenarRecycler();
        return view;
    }

    private void llenarRecycler() {
        API_Usuario_Interface serv = retrofit.create(API_Usuario_Interface.class);
        Call<ComprasResponse> responseCall = serv.listadoCompras_usuario(String.valueOf(CSharedPreferences.getUsuario().getId_usuario()));
        responseCall.enqueue(new Callback<ComprasResponse>() {
            @Override
            public void onResponse(Call<ComprasResponse> call, Response<ComprasResponse> response) {
                if (response.isSuccessful()){
                    ComprasResponse comprasResponse = response.body();
                    List<Compra> list = comprasResponse.getListadoCompras();
                    comprasAdapter.addiccionarDatos(list);
                }
            }

            @Override
            public void onFailure(Call<ComprasResponse> call, Throwable t) {

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
