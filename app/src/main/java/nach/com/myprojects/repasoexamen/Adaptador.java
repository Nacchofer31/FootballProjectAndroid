package nach.com.myprojects.repasoexamen;

import android.content.Context;
import android.util.Log;
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
public abstract class Adaptador extends BaseAdapter {
    private Context c;
    private int layout;
    private ArrayList<?> jugadores;

    public Adaptador(Context c,int layout,ArrayList<?> jugadores){
        super();
        this.c=c;
        this.jugadores=jugadores;
        this.layout=layout;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);
        }
        onEntrada(jugadores.get(position),convertView);
        return convertView;
    }

    public abstract void onEntrada(Object entrada, View view);
}

