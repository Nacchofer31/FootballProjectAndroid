package nach.com.myprojects.repasoexamen;

/**
 * Created by Nach on 21/11/2015.
 */
public class Jugador {
    private String nombre;
    private int img;

    public Jugador(String nombre,int img){
        this.img=img;
        this.nombre=nombre;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
