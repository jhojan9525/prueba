package com.senasoft_2.prueba;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.senasoft_2.prueba.Base_datos.Sqlite;

public class MainActivity extends AppCompatActivity implements Fragment_Lista.OnFragmentInteractionListener {

    FragmentRegistro fragment=new FragmentRegistro();
    FragmentList fragmentList=new FragmentList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void addFragmentRegis(android.support.v4.app.Fragment fragmento){

        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framHome,fragmento);
        fragmentTransaction.commit();

    }

    public void addFragmentList(android.support.v4.app.Fragment fragmentoL){

        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framHome,fragmentoL);
        fragmentTransaction.commit();

    }

    public void botones(View view) {

        switch (view.getId()){
            case R.id.formuregistro:
                addFragmentRegis(fragment);
                break;

            case R.id.escritor:
                addFragmentList(Fragment_Lista.newInstance(0));
                break;
            case R.id.pintor:
                addFragmentList(Fragment_Lista.newInstance(1));
                break;
            case R.id.escultor:
                addFragmentList(Fragment_Lista.newInstance(2));
                break;

        }

    }


    @Override
    public void onFragmentInteraction(String infoUsuario) {
        Intent detalles =new Intent(this,DatosArtista.class );
        detalles.putExtra("datosArtista", infoUsuario);
        startActivity(detalles);

    }


    Sqlite conn= new Sqlite(this, "db_usuarios", null,1);
}
