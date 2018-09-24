package com.example.eduardo.eva1_8_recursos_idioma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Principal extends AppCompatActivity
implements  RadioGroup.OnCheckedChangeListener//IMPLEMENTO EL EVENTO
{
    RadioGroup rdGrpIdiomas;//DECLARO EL OBJETO TIPO RADIOGROUP
    RadioButton radioButtonEspañol, radioButtonIngles ;
    TextView txtViewNombre, txtViewApellido, txtViewEdad;
    EditText editTextNombre, editTextApellido, editTextEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        rdGrpIdiomas = findViewById(R.id.rdGroupSelect);//ASOCIO RDGROUP
        rdGrpIdiomas.setOnCheckedChangeListener(this);//PARA QUE EL RADIOGROUP RESPONDA AL EVENTO

        //VINCULACIONES
        radioButtonEspañol = findViewById(R.id.radioButtonEspañol);
        radioButtonIngles = findViewById(R.id.radioButtonIngles);

        txtViewNombre  = findViewById(R.id.textViewNombre);
        txtViewApellido  = findViewById(R.id.textViewApellido);
        txtViewEdad  = findViewById(R.id.textViewEdad);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEdad = findViewById(R.id.editTextEdad);
        //FIN VINCULACIONES
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {//METODO DEL EVENTO

        if(checkedId == R.id.radioButtonEspañol){
            radioButtonEspañol.setText(R.string.rd_espa_es);
            radioButtonIngles.setText(R.string.rd_ingles_es);

            txtViewNombre.setText(R.string.tv_nombre_es);
            editTextNombre.setText(R.string.et_nombre_es);

        }else {

            radioButtonEspañol.setText(R.string.rd_espa_en);
            radioButtonIngles.setText(R.string.rd_ingles_en);

            txtViewNombre.setText(R.string.tv_nombre_en);
            editTextNombre.setText(R.string.et_nombre_en);

        }

    }
}
