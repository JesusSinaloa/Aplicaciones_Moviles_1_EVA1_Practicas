package com.example.eduardo.eva1_14_cafeteria;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity

implements RadioGroup.OnCheckedChangeListener //SE IMPLEMENTA EL EVENTO PARA EL RADIOGROUP


    {
        //DECLARACION DE OBJETOS
        RadioGroup radioGroupTipos;
        TextView txtViewResultadoTexto;

        TextView txtViewTotal;
        EditText editTextCantidad;
        Button btnTotal;
        CheckBox checkBoxAzucar;
        CheckBox checkBoxCrema;

        //DECLARACION DE VARIABLES

        int precioCafe = 0;
        int total = 0;
        int cantidadProducto = 1;
        int precioCrema = 0;
        int precioAzucar = 0;
        String tipo = "";
        String add1="";
        String add2="";



        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        radioGroupTipos = findViewById(R.id.rdGroupTipos);//ENCUENTRO LOS RADIO BUTTON
        radioGroupTipos.setOnCheckedChangeListener(this);//RESPONDE AL EVENTO DEL RADIO BUTTON
        //SE ENCUENTRAN LOS DE MAS ELEMENTOS
        txtViewResultadoTexto = findViewById(R.id.textViewResumenTipo);
        txtViewTotal = findViewById(R.id.textViewTotal);
        editTextCantidad = findViewById(R.id.editTextCantidad);
        checkBoxAzucar = findViewById(R.id.checkBoxAzucar);
        checkBoxCrema = findViewById(R.id.checkBoxCrema);

        final Context ctnAPP = getApplicationContext();
        btnTotal = findViewById(R.id.btnTotal);//ENCUENTRO BOTON
        btnTotal.setOnClickListener(new View.OnClickListener() {//EVENTO AL BOTON
            @Override
            public void onClick(View v) {
                if((editTextCantidad.getText().toString().isEmpty()) || precioCafe == 0){//COMPRUEBA SI SE SELECCIONO UN TIP DE CAFE Y UNA CANTIDAD
                    Toast.makeText(ctnAPP, "Debes seleccionar una cantidad y/o Producto", Toast.LENGTH_SHORT).show();
                }else {


                    cantidadProducto = Integer.parseInt(editTextCantidad.getText().toString());//SE OBTIENE LA CANTIDAD DEL EDIT TEXT

                    total = ((precioCafe * cantidadProducto) + precioAzucar + precioCrema);//SE CALCULA EL TOTAL DE LA COMPRA
                    Toast.makeText(ctnAPP, "TOTAL:" + total, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST

                    txtViewTotal.setText(String.valueOf(total));//SE IMPRIME EL TOTAL EN UNA LABEL
                }
            }
        });





    checkBoxAzucar.setOnClickListener(new View.OnClickListener() {//EVENTO PARA CHECBOX AZUCAR


        @Override
        public void onClick(View v) {
            if (checkBoxAzucar.isChecked())
            {
                add1 = ",Azucar";
                precioAzucar = 1;
                //txtViewResultadoAzucar.setText(add1);
                txtViewResultadoTexto.setText(tipo + add1 +add2);//SE IMPRIME RESULTADO
                Toast.makeText(getApplicationContext(), "Precio:" + precioAzucar, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST
            }
            else
            {
                add1 = "";
                txtViewResultadoTexto.setText(tipo + add2);//SE QUITO RESULTADO
                precioAzucar = 0;
            }
        }
    });

            checkBoxCrema.setOnClickListener(new View.OnClickListener() { //EVENTO PARA EL CHECKBOX CREMA


                @Override
                public void onClick(View v) {
                    if (checkBoxCrema.isChecked())
                    {
                        add2 = ",Crema";
                        precioCrema = 1;
                        //txtViewResultadoCrema.setText(add2);
                        txtViewResultadoTexto.setText(tipo + add1 +add2);//SE IMPRIME RESULTADO
                        Toast.makeText(getApplicationContext(), "Precio:" + precioCrema, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST
                    }
                    else
                    {
                        add2 = "";
                        txtViewResultadoTexto.setText(tipo +  add1);//SE QUITA RESULTADO
                        precioCrema = 0;
                    }
                }
            });

    }

        @Override
        public void onCheckedChanged (RadioGroup group,int checkedId){//EVENTO LOS RADIO BUTTON


        switch (checkedId) {
            case R.id.radioButtonAmericano:
                tipo = "Americano";
                precioCafe = 20;
                break;
            case R.id.radioButtonCapuchino:
                tipo = "Capuchino";
                precioCafe = 48;
                break;
            case R.id.radioButtonExpresso:
                tipo = "Expresso";
                precioCafe = 30;
                break;

        }

            Toast.makeText(getApplicationContext(), "Precio:" + precioCafe, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST

            txtViewResultadoTexto.setText(tipo + add1 +add2);//SE IMPRIME EL RESULTADO

    }

    }
