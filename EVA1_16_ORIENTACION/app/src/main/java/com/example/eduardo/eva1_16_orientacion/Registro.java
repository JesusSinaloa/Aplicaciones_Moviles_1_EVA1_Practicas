package com.example.eduardo.eva1_16_orientacion;

import android.widget.Toast;

public class Registro {
    //DECLARACION DE ATRIBUTOS
    private String nombre, apellido, organizacion, correoelectronico;
    private int edad;
    private String sexo;

    //DECLARACION DE CONTRUCTOR CON LOS VALORE QUE VA A RECIBIR

    public Registro (String nombre, String apellido, String organizacion, String correoelectronico, int edad, String sexo){
        //LSO ATRIBUTOS DE ELA CLASE SON IGUAL A LO QUE RECIBIO
        this.nombre = nombre;
        this.apellido = apellido;
        this.organizacion = organizacion;
        this.correoelectronico = correoelectronico;
        this.edad = edad;
        this.sexo = sexo;
    }
    //DECLARACION DE METODOS
    public String getNombre(){

        return this.nombre;
    }
    public String getApellido(){

        return this.apellido;
    }
    public String getOrganizacion(){

        return this.organizacion;
    }
    public String getCorreoelectronico(){

        return this.correoelectronico;
    }
    public int getEdad(){

        return this.edad;
    }
    public String getSexo(){

        return this.sexo;
    }




}
