package src;
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos 
 * Francisco Avila
 * Carnet 21705
 */
import java.util.HashMap;
public class Grafo {
	private int tama�o;
    private boolean mod;
    private HashMap<String, Integer> Nombre = new HashMap<>();
    private HashMap<Integer, String> Id = new HashMap<>();
    private Matriz mat;
   
    private Matriz t;
    private Matriz camino;
   
    Grafo(){
        tama�o=0;
        mod=false;
        mat = new Matriz();
    }
    public void nNodo(String n) {
        if (!Nombre.containsKey(n)) {
            tama�o++; Nombre.put(n, tama�o); Id.put(tama�o, n);
            agregar(n, n, 0); mod= true; mat.Agregando();
        }


    } 

    public void agregar(String o, String d, float dist) {
        nNodo(o); nNodo(d);
        int or = Nombre.get(o); //origen
        int des = Nombre.get(d); //destino
        if (mat.get(or, des) > dist) {
            mat.Set(or, des, dist);
            mod = true;
        }
    }

    public void Floyd() {
        t = mat.Copia();
        camino = new Matriz(tama�o, true);

        for (int k=1; k<=tama�o; k++) {
            for (int i=1; i<=tama�o; i++) {
                for (int j=1; j<=tama�o; j++) {
                    if (t.get(i, j) > t.get(i, k) + t.get(k, j)) {
                        t.Set(i, j, t.get(i, k) + t.get(k, j));
                        if (i != j) {
                            camino.Set(i, j, k);
                        }
                    }
                }
            }
        }
        mod = false;
    }
    

    public String Centro() {
        if (mod) { Floyd();}
        int id = t.Minimo(); String lugar= Id.get(id);
        if (lugar == null) {
            String mensaje= "No se ha podido encontrar el centro";
            return mensaje;
        }
        return "El centro es " + lugar;
    }

    public String Ruta(String origen, String destino) {
        int from = Nombre.get(origen); int to = Nombre.get(destino);
        if (mod) {Floyd();}

        if (t.get(from, to) == t.g) {
            return "Actualmente no hay un camino entre" + origen + " y " + destino;
        }
        String txt = "La distancia" + t.get(from, to).toString() + "\n";

        return (txt + via(from, to, origen) + "->" + destino);


    }
    private String via(int i, int j, String txt) {
        if (camino.get(i, j) != 0) {
            txt = via(i, (int) camino.get(i, j).floatValue(), txt);
            txt += Id.get((int) camino.get(i, j).floatValue()) + "->";
            txt = via((int) camino.get(i, j).floatValue(), j, txt);
            return txt;
        }
        return txt;
    }

    public String toString() {
        String txt = "";
        for (int i=1; i<tama�o+1; i++) {
            txt += Id.get(i) + ", ";
        }
        return txt.substring(0, txt.length() - 2) + "\n" + mat.toString();
    }


}
}
