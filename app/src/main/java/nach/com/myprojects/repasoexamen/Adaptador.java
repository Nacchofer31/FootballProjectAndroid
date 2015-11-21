package nach.com.myprojects.repasoexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nach on 21/11/2015.
 */
public class Adaptador extends BaseAdapter {

    Context c;
    ArrayList<Jugador> jugadores;

    public Adaptador(Context c,ArrayList<Jugador> jugadores){
        this.c=c;
        this.jugadores=jugadores;
    }

    @Override
    public int getCount() {
        return jugadores.size();
    }

    @Override
    public Object getItem(int position) {
        return jugadores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            convertView=inflater.inflate(R.layout.jugador,parent,false);
        }

        ImageView img= (ImageView) convertView.findViewById(R.id.imageJugador);
        TextView nombre = (TextView) convertView.findViewById(R.id.nombreJugador);

        img.setImageResource(jugadores.get(position).getImg());
        nombre.setText(jugadores.get(position).getNombre());

        return convertView;
    }
}
