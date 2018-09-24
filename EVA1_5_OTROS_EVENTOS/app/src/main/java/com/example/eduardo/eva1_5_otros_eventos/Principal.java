package com.example.eduardo.eva1_5_otros_eventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Principal extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener/*CADA VEZ QUE SELECCIONA UN RADIOBUTTON DIFERENTE*/

{

    RadioGroup rdGrpOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        rdGrpOpciones = findViewById(R.id.rdGrpOpciones);//Vinculamos
        rdGrpOpciones.setOnCheckedChangeListener(this);
    }

    @Override                   //RADIO BUTTON QUE GENERA EL EVENTO
                                //int i --> radio button seleccionado
    public void onCheckedChanged(RadioGroup group, int i) {
        String sMensa;

        switch(i){
            case R.id.rdButtonTacos:
                sMensa = "Tacos";
                break;
            case R.id.rdButtonChilesRellenos:
                sMensa = "Chiles Rellenos";
                break;
            case R.id.rdButtonMontados:
                sMensa = "montados";
                break;
            case R.id.rdButtonTamales:
                sMensa = "Tamales";
                break;
            case R.id.rdButtonTortas:
                sMensa = "Tortas";
                break;
                default:
                    sMensa = "Otra opcion";
        }

        Toast.makeText(this, sMensa, Toast.LENGTH_SHORT).show();
    }
}
