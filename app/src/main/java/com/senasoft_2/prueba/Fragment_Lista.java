package com.senasoft_2.prueba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Lista.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Lista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Lista extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView  listaartistas;
    private OnFragmentInteractionListener mListener;
    String [][] arregloData= new String[][]{{"Jose luis pintor","Luisa maria pintor","Carlos Peres Pintor"},
                                            {"Jose luis escritor ","Luisa maria escritor","Carlos Peres escritor"},
                                            {"Jose luis escultor","Luisa maria escultor","Carlos Peres escultor"}};


    public Fragment_Lista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Fragment_Lista.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Lista newInstance(int param1) {
        Fragment_Lista fragment = new Fragment_Lista();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaLista = inflater.inflate(R.layout.fragment_fragment__lista, container, false);
        addIds(vistaLista);

        ArrayAdapter <String> adapterSiemple;

        switch (getArguments().getInt(ARG_PARAM1)){
            case 0:
                addArraySimple(arregloData[0]);
                break;
            case 1:
                addArraySimple(arregloData[1]);

            case 2:
                addArraySimple(arregloData[2]);
        }

        listaartistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFragmentInteraction(arregloData[getArguments().getInt(ARG_PARAM1)][position]);
            }
        });


    return vistaLista;


    }

    private void addArraySimple(String[] datos) {
        ArrayAdapter<String> adapterSiemple = new ArrayAdapter<>(getContext(),
        android.R.layout.simple_expandable_list_item_1, datos);
        listaartistas.setAdapter(adapterSiemple);

    }

    private void addIds(View vista) {
        listaartistas = (ListView) vista.findViewById(R.id.idListaUsarios);
    }





    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

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
        void onFragmentInteraction(String infoUsuario);
    }

}