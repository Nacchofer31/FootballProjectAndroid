package nach.com.myprojects.repasoexamen;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityJugadores extends Activity {
    GridView gV;
    String[] nombres={"DeGea","Rojo","Jones","Smalling","Darmian","Schweinsteiger","Mata","Schneiderlin","Memphis",
            "Martial","Rooney","Lingard","Young","Felaini","Herrera","Bolt"};
    int[] images={R.drawable.degea,R.drawable.rojo,R.drawable.jones,R.drawable.smalling,R.drawable.darmian,R.drawable.schweins,
            R.drawable.mata,R.drawable.schneiderlin,R.drawable.memphis,R.drawable.martial,R.drawable.rooney,R.drawable.lingard,
            R.drawable.young,R.drawable.fellaini,R.drawable.herrera,R.drawable.bolt};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_jugadores);

        gV = (GridView)findViewById(R.id.gridView);

        Adaptador adaptador = new Adaptador(this,getJugadores());
        gV.setAdapter(adaptador);

        gV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),nombres[position],Toast.LENGTH_SHORT);
            }
        });

    }

    private ArrayList<Jugador> getJugadores(){
        ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
        for(int i =0;i<nombres.length;i++){
            jugadores.add(new Jugador(nombres[i],images[i]));
        }
        return jugadores;
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
