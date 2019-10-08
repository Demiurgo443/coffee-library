//creo la classe Libro
public class Libro {

//campi di esemplare
	private String titolo;
	private String autore;
	private boolean disponibilit�;
	private int codice;
	
//creo il costruttore
	public Libro(String n_titolo, String n_autore, boolean n_disponibilit�, int n_codice){
		titolo=n_titolo;
		autore=n_autore;
		disponibilit�=n_disponibilit�;
		codice=n_codice;
	}

//creo i metodi
	public String getTitolo(){
		return this.titolo;
	}
	
	public String getAutore() {
		return this.autore;
	}
	
	public boolean getDisponibilit�(){
		return this.disponibilit�;
	}
	public int getCodice(){
		return this.codice;
	}
	
	public void setCodice(int n_codice) {
		this.codice = n_codice;
	}
	public void setAutore(String n_autore) {
		this.autore = n_autore;
	}
	
	public void setTitolo(String n_titolo) {
		this.titolo = n_titolo;
	}
	
	public void setDisponibilit�(boolean n_disponibilit�){
		this.disponibilit� = n_disponibilit�;
	}


}
