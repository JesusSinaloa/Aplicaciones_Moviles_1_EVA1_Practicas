package com.example.eduardo.eva1_6_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity
implements ListView.OnItemClickListener
//SOLO RESPONDE SI ES¡XISTE LA LISTA

{
    TextView txtMostrar;//DECLARAMOS
    ListView lstViewDatos;

    //ARREGLO PARA LLENAR LISTA

    final String[] sResta = {"Dominos Pizza","Los mejores tacos", "Mariscos supersabrosos", "superbolas de arroz", "hamburgesas francesas", "perros mostasas", "la hacienda", "Nestro restaurant", "Tripitas asadas", "menuderia don ramon", "Super caldazo"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtMostrar = findViewById(R.id.txtMostrar);//Vinculamos
        lstViewDatos = findViewById(R.id.lstviewDatos);//Vinculamos

        //NECESITAMOS UN ADAPTADOR
        //ES COMO UN INTERMEDIARIO PARA EL ORIGEN DE DATOS

        lstViewDatos.setAdapter(

                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sResta)//CONTRUIR LISTA PARA MOSTRARLA  DATOS CONTEXTO, COMO SE MUESTRA LA LISTA Y LA LISTA

        );
        lstViewDatos.setOnItemClickListener(this);//EL EVENTO ES NUESTRA CLASE PRINCIPAL, ASI LE DECIMOS
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        txtMostrar.setText(sResta[position]);//MOSTRAR  CONTENIDO DEL ARREGLO EN LA POSICION QUE SE DIO CLICK, POR ESO SE LE PASA LA POSICION AL SETTEXT.
    }
}
