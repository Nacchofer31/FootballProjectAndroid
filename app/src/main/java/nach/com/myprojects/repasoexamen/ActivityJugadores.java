package nach.com.myprojects.repasoexamen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityJugadores extends Activity {
    GridView gV;
    Button boton;
    String equipo, liga, jugador;
    String[]jug;

    int[] images={R.drawable.degea,R.drawable.rojo,R.drawable.jones,R.drawable.smalling,R.drawable.darmian,R.drawable.schweins,
            R.drawable.mata,R.drawable.schneiderlin,R.drawable.memphis,R.drawable.martial,R.drawable.rooney,R.drawable.lingard,
            R.drawable.young,R.drawable.fellaini,R.drawable.herrera,R.drawable.bolt};

    @Override
    public void finish() {
        Intent i = new Intent();
        i.putExtra("jugadorIntent",jugador);
        i.putExtra("equipoIntent",equipo);
        i.putExtra("ligaIntent", liga);
        setResult(RESULT_OK, i);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_jugadores);
        ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
        jug=getResources().getStringArray(R.array.jugadores);
        for(int i=0;i<jug.length;i++){
            jugadores.add(new Jugador(jug[i],images[i]));
            Log.i("Sip",jug[i]+": AÑADIDO");
        }
        Bundle b =getIntent().getExtras();
        if(b!=null){
            liga = b.getString("ligaIntent");
            equipo = b.getString("equipoIntent");
            Toast t=Toast.makeText(getApplicationContext(),"Liga: "+liga+" Equipo: "+equipo,Toast.LENGTH_SHORT);
            t.show();
        }

        boton = (Button)findViewById(R.id.buttonEquipos);
        gV = (GridView)findViewById(R.id.gridView);

        gV.setAdapter(new Adaptador(this, R.layout.jugador, jugadores) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    ImageView img = (ImageView) view.findViewById(R.id.imageJugador);
                    TextView nombre = (TextView) view.findViewById(R.id.nombreJugador);
                    if(img!=null){
                        img.setImageResource(((Jugador) entrada).getImg());
                    }
                    if(nombre!=null){
                        nombre.setText(((Jugador)entrada).getNombre());
                    }
                }
            }}
        );


        gV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast t = Toast.makeText(getApplicationContext(), jug[position], Toast.LENGTH_SHORT);
                t.show();
                jugador = jug[position];
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(camposVacios()) {
                    finish();
                }else{
                    Toast t=Toast.makeText(getApplicationContext(), "Estás en la mierda, compañero, no has elegido ningún jugador", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }

    public boolean camposVacios(){
        if(jugador==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_jugadores, menu);
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

}
