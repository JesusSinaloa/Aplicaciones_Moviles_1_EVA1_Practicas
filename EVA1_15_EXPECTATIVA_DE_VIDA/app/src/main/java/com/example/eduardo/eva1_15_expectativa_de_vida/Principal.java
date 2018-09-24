package com.example.eduardo.eva1_15_expectativa_de_vida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    //DECLARACION DE OBJETOS
    EditText FechaNacimiento;
    RadioGroup Regiones;
    RadioGroup Generos;
    TextView Expectativa;
    TextView Deceso;
    RadioButton radioH;
    RadioButton radioM;
    RadioButton radioAF;
    RadioButton radioAL;
    RadioButton radioAS;
    RadioButton radioRD;

    int fecha = 0;
    int item = 0;

    int ExpVida = 0;
    int difGen = 0;
    int ResulExpVida = 0;

    //DECLARACIONES DE ARRAY

    // int matrizFechas[][] = new int[6][5];
                                //1950          //1960          //1970          //1980          //1990          //2000
    int matrizFechas [][] = {{75,60,45,35,10},{75,65,50,45,9},{80,70,65,55,8},{80,75,65,60,7},{85,75,60,55,6},{90,70,65,60,4}};
                         //Desarrollados, AmericaLatina, Asia, Africa, DifDeGenero
   /* final int[] A1950 = {75,60,45,35,10};
    final int[] A1960 = {75,65,50,45,9};
    final int[] A1970 = {80,70,65,55,8};
    final int[] A1980 = {80,75,65,60,7};
    final int[] A1990 = {85,75,60,55,6};
    final int[] A2000 = {90,70,65,60,4};*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //VINCULACIONES
        FechaNacimiento = findViewById(R.id.editTextAñoNacimiento);
        Regiones = findViewById(R.id.radioGroupRegion);
        Generos = findViewById(R.id.radioGroupGenero);
        Expectativa = findViewById(R.id.textViewResultadoEV);
        Deceso = findViewById(R.id.textViewResultadoFD);
        radioH = findViewById(R.id.radioButtonH);
        radioM = findViewById(R.id.radioButtonM);
        radioAF = findViewById(R.id.radioButtonAF);
        radioAL = findViewById(R.id.radioButtonAL);
        radioAS = findViewById(R.id.radioButtonAS);
        radioRD = findViewById(R.id.radioButtonRD);

        FechaNacimiento.addTextChangedListener(new TextWatcher() {//EVENTO APRA QUE CAPTE INMEDIATAMENTE CUNADO SE ACABA DE ESCRIBIR LA FECHA DE NACIMIENTO
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (radioH.isChecked() || radioM.isChecked()){
                    fecha = Integer.parseInt(FechaNacimiento.getText().toString());
                    Expectativa.setText((ExpVida - difGen) + " AÑOS");
                    Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                }else {
                    if (FechaNacimiento.getText().length() >= 0) {
                        //Expectativa.setText(FechaNacimiento.getText().toString());

                        fecha = Integer.parseInt(FechaNacimiento.getText().toString());



                    }
                    else{
                        fecha = 0;
                    }
                }

            }

        });

        Regiones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//EVENTO PARA EXPECTATATIVAS SEGUN LA POBLACION
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if((FechaNacimiento.getText().toString().isEmpty())){
                    Toast.makeText(getApplicationContext(), "LLENA EL CAMPO DE TEXTO FECHA" , Toast.LENGTH_SHORT).show();//VERIFICA QUE EL CMAPO TEXTO ESTE LLENO
                }else {
                    switch (checkedId) {
                        case R.id.radioButtonRD:
                            item = 0;//OBTIENEN LA 2da POSICION DE LA MATRIZ

                            break;
                        case R.id.radioButtonAL:
                            item = 1;
                            break;
                        case R.id.radioButtonAS:
                            item = 2;
                            break;
                        case R.id.radioButtonAF:
                            item = 3;
                            break;

                    }
                }


                if(fecha>=1950 && fecha < 1960) {//SE VERIFICA LO QUE SE INTRODUCJO EN EL EDIT TEXT Y SE CHECA A QUE AÑO PERTENECE
                    int posicionAño = 0;//SE ASIGANA LA PRIMER POSICIOND EL ARRAY SEGUN EL AÑO

                    ExpVida = matrizFechas[posicionAño][item];//SE OBTINE LA EXPECTATIVA
                    difGen = (matrizFechas[posicionAño][4])/(2);//SE OBTINE LA DIFERENCIA DE GENERO



                    if(radioM.isChecked()){//SI YA SE TIENE SELECCIOANDO UN GENERO SE VERIFICA Y SE HACE LA OPERACION CORRESPONDIENTE SEGUN EL GENERO


                        Expectativa.setText((ExpVida + difGen)+ " AÑOS");//SE IMPRIME EN LAS ETIQUETAS CORRESPINDIENTES
                        Deceso.setText(String.valueOf((ExpVida + difGen)+ fecha));
                    } else {

                        if (radioH.isChecked()) {


                            Expectativa.setText((ExpVida - difGen) + " AÑOS");
                            Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                        } else {
                            Expectativa.setText("");
                        }
                    }
                }
                if(fecha>=1960 && fecha < 1970) {
                    int posicionAño = 1;

                    ExpVida = matrizFechas[posicionAño][item];
                    difGen = (matrizFechas[posicionAño][4])/(2);


                    Expectativa.setText((ExpVida + difGen)+ " AÑOS");
                    if(radioM.isChecked()){


                        Expectativa.setText((ExpVida + difGen)+ " AÑOS");
                        Deceso.setText(String.valueOf((ExpVida + difGen) + fecha));
                    }
                    else {

                        if (radioH.isChecked()) {


                            Expectativa.setText((ExpVida - difGen) + " AÑOS");
                            Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                        } else {
                            Expectativa.setText("");
                        }
                    }


                }
                if(fecha>=1970 && fecha < 1980) {
                    int posicionAño = 2;

                    ExpVida = matrizFechas[posicionAño][item];
                    difGen = (matrizFechas[posicionAño][4])/(2);


                    if(radioM.isChecked()){


                        Expectativa.setText((ExpVida + difGen)+ " AÑOS");
                        Deceso.setText(String.valueOf((ExpVida + difGen) + fecha));
                    }
                    else {

                        if (radioH.isChecked()) {


                            Expectativa.setText((ExpVida - difGen) + " AÑOS");
                            Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                        } else {
                            Expectativa.setText("");
                        }
                    }


                }
                if(fecha>=1980 && fecha < 1990) {
                    int posicionAño = 3;

                    ExpVida = matrizFechas[posicionAño][item];
                    difGen = (matrizFechas[posicionAño][4])/(2);



                    if(radioM.isChecked()){


                        Expectativa.setText((ExpVida + difGen)+ " AÑOS");
                        Deceso.setText(String.valueOf((ExpVida + difGen) + fecha));
                    }
                    else {

                        if (radioH.isChecked()) {


                            Expectativa.setText((ExpVida - difGen) + " AÑOS");
                            Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                        } else {
                            Expectativa.setText("");
                        }
                    }
                }
                if(fecha>=1990 && fecha < 2000) {
                    int posicionAño = 4;

                    ExpVida = matrizFechas[posicionAño][item];
                    difGen = (matrizFechas[posicionAño][4])/(2);


                    if(radioM.isChecked()){


                        Expectativa.setText((ExpVida + difGen)+ " AÑOS");
                        Deceso.setText(String.valueOf((ExpVida + difGen) + fecha));
                    }
                    else {

                        if (radioH.isChecked()) {

                            Expectativa.setText((ExpVida - difGen) + " AÑOS");
                            Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                        } else {
                            Expectativa.setText("");
                        }
                    }
                }
                if(fecha>=2000) {
                    int posicionAño = 5;

                    ExpVida = matrizFechas[posicionAño][item];
                    difGen = (matrizFechas[posicionAño][4])/(2);


                    if(radioM.isChecked()){


                        Expectativa.setText((ExpVida + difGen)+ " AÑOS");
                        Deceso.setText(String.valueOf((ExpVida + difGen) + fecha));
                    }
                    else {

                        if (radioH.isChecked()) {


                            Expectativa.setText((ExpVida - difGen) + " AÑOS");
                            Deceso.setText(String.valueOf((ExpVida - difGen) + fecha));
                        } else {
                            Expectativa.setText("");
                        }
                    }
                }

            }
        });

        Generos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {//EVENTO APRA LOS RADIOS DE GENERO
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if ((FechaNacimiento.getText().toString().isEmpty()) ) {
                    Toast.makeText(getApplicationContext(), "LLENA EL CAMPO DE TEXTO FECHA", Toast.LENGTH_SHORT).show();//VERIFICA QUE EL CMXAPO TEXTO ESTE LLENO Y ALLA UNA REGION SELECCIOANDA

                } else {
                    switch (checkedId) {
                        case R.id.radioButtonH:

                            ResulExpVida = ExpVida - difGen;//SE OBTINE EL RESULTADO FINAL
                            break;
                        case R.id.radioButtonM:
                            ResulExpVida = ExpVida + difGen;
                            break;

                    }

                    Toast.makeText(getApplicationContext(), "Expectativa:" + ResulExpVida, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST
                    Expectativa.setText(ResulExpVida + " AÑOS");
                    Deceso.setText(String.valueOf(ResulExpVida + fecha));//SE IMPRIME EN LAS ETIQUETAS CORRESPINDIENTES
                }
            }
        });


    }
}
