package principal;

public class Evento {
	
	private String intervalo;  

    public Evento(String intervalo) {
    	super();
        this.intervalo = intervalo;
    }

    public void modificarEvento(String nuevoIntervalo) {
        this.intervalo = nuevoIntervalo;
        System.out.println("Evento modificado: " + intervalo);
    }

    public void cancelarEvento() {
        System.out.println("Evento cancelado: " + intervalo);
        this.intervalo = null;
    }

    public String getIntervalo() {
        return intervalo;
    }

}
