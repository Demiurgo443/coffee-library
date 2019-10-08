//creo la classe Libro
public class Libro {

//campi di esemplare
	private String titolo;
	private String autore;
	private boolean disponibilitā;
	private int codice;
	
//creo il costruttore
	public Libro(String n_titolo, String n_autore, boolean n_disponibilitā, int n_codice){
		titolo=n_titolo;
		autore=n_autore;
		disponibilitā=n_disponibilitā;
		codice=n_codice;
	}

//creo i metodi
	public String getTitolo(){
		return this.titolo;
	}
	
	public String getAutore() {
		return this.autore;
	}
	
	public boolean getDisponibilitā(){
		return this.disponibilitā;
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
	
	public void setDisponibilitā(boolean n_disponibilitā){
		this.disponibilitā = n_disponibilitā;
	}


}
