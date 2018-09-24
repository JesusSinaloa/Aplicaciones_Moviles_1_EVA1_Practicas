package com.example.eduardo.eva1_4_eventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity

implements View.OnClickListener {





        TextView txtVwMensa; //Estes es un objeto de tipo TextView
        Button btnInterfaz;//Objeto de tipo Button
    Button btnClaseAnonima;
    Button btnPorClase;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwMensa = findViewById(R.id.txtVwMensa);//se inicializa se manda a encontrar el widget y se iguala a la variable para poder usarlo. con .R
        txtVwMensa.setText("Hola mundo cruel!!");
        /*POR INTERFAZ*/
        btnInterfaz = findViewById(R.id.btnInterfaz);//Encontrar segundo btn asociar al btn
        btnInterfaz.setOnClickListener(this);//Se asocia el evento OnClick
        btnPorClase.findViewById(R.id.btnPorClase);

        /*POR CLASE ANONIMA*/
            final Context ctnApp = getApplicationContext();
             btnClaseAnonima = findViewById(R.id.btnClaseAnonima);//Vinvulamos el botton



        btnClaseAnonima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctnApp, "EVENTO POR CLASE ANONIMA", Toast.LENGTH_SHORT).show();
            }
        });
        /*FIN CLASE ANONIMA*/

        /*POR CLASE*/
        ClickListener miClickLis = new ClickListener();
        btnPorClase.setOnClickListener(miClickLis);

        /*FIN POR CLASE*/

    }
        /*POR XML*/
        public void MiClick (View v){//EVENTO CLICK O TOUCH
        Toast.makeText(this, "hola mundo cruel", Toast.LENGTH_LONG).show();
    }
    /*POR INTERFAZ*/
        @Override
        public void onClick (View view){
        Toast.makeText(this, "Hola mundo 2", Toast.LENGTH_LONG).show();
    }



    }
