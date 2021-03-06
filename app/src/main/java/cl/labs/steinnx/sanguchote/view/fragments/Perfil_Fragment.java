package cl.labs.steinnx.sanguchote.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cl.labs.steinnx.sanguchote.R;
import cl.labs.steinnx.sanguchote.model.CSharedPreferences;
import cl.labs.steinnx.sanguchote.model.Usuario;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Perfil_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Perfil_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Usuario user = CSharedPreferences.getUsuario();
    private TextView tv_user,tv_nombre,tv_apellido;

    public Perfil_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_perfil, container, false);
        tv_user = (TextView) view.findViewById(R.id.tv_frag_perf_user);
        tv_nombre = (TextView) view.findViewById(R.id.tv_frag_perf_nom);
        tv_apellido = (TextView) view.findViewById(R.id.tv_frag_perf_apell);

        tv_user.setText(user.getUser());
        tv_nombre.setText(user.getNombre());
        tv_apellido.setText(user.getApellido());

        return view;
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
