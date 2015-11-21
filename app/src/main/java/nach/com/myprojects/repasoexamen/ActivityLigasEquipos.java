package nach.com.myprojects.repasoexamen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityLigasEquipos extends Activity {

    private static int REQUEST_CODE=1;

    Spinner ligasSP,equiposSP;
    ArrayAdapter<String> adap_ligas,adap_equipos;
    ArrayList<String> aListEquipos;
    String liga="";
    String equipo="";
    Button jugadoresBoton;
    TextView ligaTexto,equipoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ligas_equipos);

        //Declaramos los objetos que vamos a necesitar.

        ligasSP = (Spinner)findViewById(R.id.spinnerLigas);
        equiposSP = (Spinner)findViewById(R.id.spinnerEquipos);
        jugadoresBoton = (Button) findViewById(R.id.btnJugadores);

        //Métodos
        crearSpinners();
        comprobarBoton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void crearSpinners(){
        //Creamos un array e introducimos el contenido del array xml en nuestro array.
        String array_ligas[]=getResources().getStringArray(R.array.ligas);
        //Creamos el Adaptador de Ligas para llenar nuestro spinner del array_ligas.
        adap_ligas = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,array_ligas);
        //Establecemos nuestro adaptador al spinner Ligas.
        ligasSP.setAdapter(adap_ligas);

        //Creamos el Adaptador de Equipos para llenar nuestro spinner de algunos de nuestros arrays.
        adap_equipos = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        //Método listener que coge el item seleccionado.
        ligasSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://Posición 0
                        aListEquipos = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ligaBBVA)));
                        break;
                    case 1://Posición 1
                        aListEquipos = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.barclaysPL)));
                        break;
                    case 2://Posición 2
                        aListEquipos = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.serieA)));
                        break;
                    case 3://Posición 3
                        aListEquipos = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ligue1)));
                        break;
                }
                adap_equipos.clear();
                adap_equipos.addAll(aListEquipos);
                equiposSP.setAdapter(adap_equipos);

                liga = ligasSP.getSelectedItem().toString();
                equipo = equiposSP.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    public void comprobarBoton(){
        jugadoresBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityLigasEquipos.this,ActivityJugadores.class);
                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }
}
