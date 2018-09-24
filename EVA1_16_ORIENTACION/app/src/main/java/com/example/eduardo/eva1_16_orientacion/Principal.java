package com.example.eduardo.eva1_16_orientacion;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity

{

    EditText editTextNombre, editTextApellido, editTextEdad, editTextOrganizacion, editTextEmail;
    TextView textViewResultado;
    RadioGroup rdGroupSexo;
    RadioButton rdButtonH;
    RadioButton rdButtonM;
    Button btnAgregar;

    //VARIABLES GLOBALES
    String sexo = "";
    int cantidadRegistros = 0;

    List<Registro> registros = new ArrayList<Registro>();//LISTA PARA ALAMCENAR REGISTROS

    int registrosLista = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //VINCULANDO
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextEdad = findViewById(R.id.editTextEdad);
        editTextOrganizacion = findViewById(R.id.editTextOrganizacion);
        editTextEmail = findViewById(R.id.editTextCorreoElectronico);
        textViewResultado = findViewById(R.id.textViewResultado);

        rdGroupSexo = findViewById(R.id.rdGroupSexo);
        rdButtonH = findViewById(R.id.radioButtonH);
        rdButtonM = findViewById(R.id.radioButtonM);
        btnAgregar = findViewById(R.id.buttonAgregar);

          mostrarEditText();



        Toast.makeText(getApplicationContext(), "Registros en lista:" + registrosLista, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/



        //EVENTO CLICK DEL BOTON AGGREGAR
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            //VARIABLES PARA DATOS
            String nombre, apellido, organizacion, email;
            int edad;

            @Override
            public void onClick(View v) {
                //OBTENIENDO DATOS
                nombre = editTextNombre.getText().toString();
                apellido = editTextApellido.getText().toString();
                organizacion = editTextOrganizacion.getText().toString();
                email = editTextEmail.getText().toString();
                edad = Integer.parseInt(editTextEdad.getText().toString());



                Registro registroActual = new Registro(nombre, apellido, organizacion, email, edad, sexo);//SE CREA OBJETO DE REGISTROACTUAL

                if(registros.isEmpty()){//SE VERIFICA SI LA LISTA ESTA VACIA SI ES ASI SE AÑADE EL PRIMER REGISTRO
                    registros.add(registroActual);
                    Toast.makeText(getApplicationContext(), "Agregado Correctamente", Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/
                    editTextNombre.setText("");
                    editTextApellido.setText("");
                    editTextOrganizacion.setText("");
                    editTextEmail.setText("");
                    editTextEdad.setText("");
                    rdGroupSexo.clearCheck();
                    registrosLista = registros.size();
                    Toast.makeText(getApplicationContext(), "Registros en lista:" + registrosLista, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/

                }else{//SI LA LISTA NO ESTA VACIA  SE COMPRUEBA QUE EL CORREO NO ESTE REPETIDO SI ESTA REPETIDO ERRO Y SI NO SE AGREGA A LA LISTA
                    if(comprobacion(registros,registroActual)){//SE MANDA LLAMAR EL METODO COMPROBACION Y S ELE PASA LAS LSITA Y EL REGISTRO ACTUAL

                        Toast.makeText(getApplicationContext(), "Correo repetido", Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/
                    }else {


                        if(registrosLista >= cantidadRegistros){
                            Toast.makeText(getApplicationContext(), "Ya no puedes agregar mas registros", Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/
                        }else {
                            registros.add(registroActual);
                            Toast.makeText(getApplicationContext(), "Agregado Correctamente", Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/
                            editTextNombre.setText("");
                            editTextApellido.setText("");
                            editTextOrganizacion.setText("");
                            editTextEmail.setText("");
                            editTextEdad.setText("");
                            rdGroupSexo.clearCheck();

                            registrosLista = registros.size();
                            Toast.makeText(getApplicationContext(), "Registros en lista:" + registrosLista, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/


                        }
                    }

                }



            }

        });

        rdGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButtonH:
                        sexo = "Hombre";

                        break;
                    case R.id.radioButtonM:
                        sexo = "Mujer";
                        break;

                }


            }
        });

    }


    public boolean comprobacion(List<Registro> registros, Registro registroActual){//RECIBE UNA LISTA Y UN BOJETO DE TIPO REGISTRO

        for (Registro r : registros) {
            if (r.getCorreoelectronico().equals(registroActual.getCorreoelectronico())) {//SI EXISTE EL CORREO DEVUELVE VERDADERO SI NO FALSO

               return true;
            }
        }
        return false;
    }

    public void mostrarEditText() {//METODO PARA MOSTRAR CUADO DE DIALOGO EMERGENTE

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cuantos registros quieres agregar");//TITULO

        final EditText input = new EditText(this);//INPUT TIPO EDIT TEXT QUE SE VA A MOSTRAR
        builder.setView(input);//COLOCAR INPUT
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {//BOTON DE CONFIMACION AQUI SE REALIZA ALGO CON EL REUSLTADO
            @Override
            public void onClick(DialogInterface dialog, int which) {
               cantidadRegistros = Integer.parseInt(input.getText().toString());


                    //Toast.makeText(getApplicationContext(), "cantidad:" + cantidad, Toast.LENGTH_SHORT).show();// SE IMPRIME EL TOTAL EN UNA TOAST*/
            }



        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {//BOTON DE CANCELACIOND EL CUADRO DE DIALOGO
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();

    }






}
