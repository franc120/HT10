package src;

public class edge {
	String PuntoPartida;
    String PuntoFinal;
    int magnitud;

	 public Edge(String PuntoPartida, String PuntoFinal, int magnitud) {
	        this.PuntoPartida = PuntoPartida;
	        this.PuntoFinal = PuntoFinal;
	        this.magnitud = magnitud;
	    }

	    public String getPuntoPartida() {
	        return PuntoPartida;
	    }

	    public String getPuntoFinal() {
	        return PuntoFinal;
	    }

	    public int getMagnitud() {
	        return magnitud;
	    }
}
