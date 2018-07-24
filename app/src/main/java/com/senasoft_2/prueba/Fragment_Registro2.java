package com.senasoft_2.prueba;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.senasoft_2.prueba.Base_datos.Sqlite;
import com.senasoft_2.prueba.Utilidades.Utilidades;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Registro2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Registro2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Registro2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText nombre, biografia;
    RadioButton radioEscritor,radioPintor,radioEscultor;
    RadioGroup radioGroup;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment_Registro2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Fragment_Registro2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Registro2 newInstance() {
        Fragment_Registro2 fragment = new Fragment_Registro2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__registro2, container, false);

        nombre =(EditText) view.findViewById(R.id.nombre);
        biografia =(EditText) view.findViewById(R.id.biografia);
        radioEscritor =(RadioButton) view.findViewById(R.id.radioEscritor);
        radioEscultor =(RadioButton) view.findViewById(R.id.radioEscultor);
        radioPintor =(RadioButton) view.findViewById(R.id.radioPintor);
        radioGroup =(RadioGroup) view.findViewById(R.id.radioGroup);


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

    public void onClick(View view){
        registrarUsuario();

    }

    private void registrarUsuario() {

        Sqlite conn= new Sqlite(getContext(), "db_usuarios", null,1);
        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(Utilidades.nombre,nombre.getText().toString());
        values.put(Utilidades.biografia,biografia.getText().toString());
        values.put(Utilidades.radioEscritor,radioEscritor.getText().toString());
        values.put(Utilidades.radioEscultor,radioEscritor.getText().toString());
        values.put(Utilidades.radioPintor,radioPintor.getText().toString());


        long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.ID,values);



    }
}
