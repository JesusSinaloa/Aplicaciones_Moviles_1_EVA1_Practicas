package com.example.eduardo.eva1_11_listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends AppCompatActivity
implements ListView.OnItemClickListener

{

    ListView lstView;
    TextView txtViewMuestra;

    //ARREGLO PARA LLENAR LISTA
    //ARREGLO TITULOS LIBROS
    final String[] libros = {

    "La Biblia",
    "Harry Potter",
    "El Señor de los Anillos",
     "El Alquimista",
    "El Código da Vinci",
    "Crepúsculo",
    "Lo que el viento se llevó"

    };
    //ARREGLO SINOPSIS LIBROS
    final String[] sinopsis = {

      "La Biblia es el conjunto de libros canónicos del judaísmo y el cristianismo. La canonicidad de cada libro varía dependiendo de la tradición adoptada. Según las religiones judía y cristiana, transmite la palabra de Dios.",
      "Harry Potter es una heptalogía de novelas fantásticas escrita por la autora británica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de mago Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los siete años que pasan en el Colegio Hogwarts de Magia y Hechicería. El argumento se centra en la lucha entre Harry Potter y el malvado mago Lord Voldemort, quien mató a los padres de Harry en su afán de conquistar el mundo mágico.",
      "El Señor de los Anillos es una novela de fantasía épica escrita por el filólogo y escritor británico J. R. R. Tolkien. Su historia se desarrolla en la Tercera Edad del Sol de la Tierra Media, un lugar ficticio poblado por hombres y otras razas antropomorfas como los hobbits, los elfos o los enanos, así como por muchas otras criaturas reales y fantásticas. La novela narra el viaje del protagonista principal, el hobbit Frodo Bolsón, para destruir el Anillo Único y la consiguiente guerra que provocará el enemigo para recuperarlo, ya que es la principal fuente de poder de su creador, el Señor oscuro Sauron.",
      "El alquimista es un libro escrito por el escritor brasileño Paulo Coelho que ha sido traducido a más de 63 lenguas y publicado en 150 países, y que ha vendido un total de 65 millones de copias en todo el mundo.1 El libro trata sobre los sueños y los medios que utilizamos para alcanzarlos, sobre el azar en nuestra vida y las señales que se presentan a lo largo de esta.",
      "El código Da Vinci es una novela de misterio escrita por Dan Brown. […] Al combinar los géneros de suspenso detectivesco y esoterismo Nueva Era, con una teoría de conspiración relativa al Santo Grial y al papel de María Magdalena en el cristianismo, la novela espoleó el difundido interés (sobre todo en los Estados Unidos de América) por ciertas teorías de complots «urdidos en la sombra por poderes ocultos», un fenómeno definido por Brown como el «auge conspiranoico».",
      "Crepúsculo es una novela romántica de vampiros dirigida al público adolescente, escrita por Stephenie Meyer y publicada en 2005. Es la primera parte de una serie de cuatro libros, de la que están publicados, además de Crepúsculo, Luna nueva, Eclipse, y Amanecer. Sol de medianoche es un proyecto aparte, sin finalizar, en el que Stephenie lleva trabajando desde hace tiempo; en el cual se repite la historia de Crepúsculo pero narrada por Edward Cullen, este proyecto ha sido suspendido indefinidamente por la autora, debido a la distribución ilegal de los primeros 12 capítulos.",
      "Lo que el viento se llevó es una novela escrita por la autora Margaret Mitchell; es uno de los libros más vendidos de la historia, un clásico de la literatura de los Estados Unidos y debido a su adaptación al cine es uno de los más grandes iconos o mitos de la cultura popular contemporánea."

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        lstView = findViewById(R.id.listVwTitu);
        txtViewMuestra = findViewById(R.id.textViewMuestra);

        lstView.setAdapter(//CREAR ADAPTADOR
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, libros)


        );

        lstView.setOnItemClickListener(this);//RESPONDER AL EVENTO
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//EVENTO DEL LISTENER
    txtViewMuestra.setText(sinopsis[position]);
    }
}
