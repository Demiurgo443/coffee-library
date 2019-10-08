//creo la classe
public class Prodotto {
	
//creo i campi di esemplari
	private String nome_prodotto;
	private double prezzo;
	private double tempo_preparazione;
	private int codice_prodotto;
	


//creo il costruttore
	public Prodotto(String n_prodotto, double n_prezzo, double t_preparazione, int p_codice){
		nome_prodotto=n_prodotto;
		prezzo=n_prezzo;
		tempo_preparazione=t_preparazione;
		codice_prodotto=p_codice;
	}
	
//creo i metodi
	public String getNomeProdotto(){
		return this.nome_prodotto;
	}
	public double getPrezzo(){
		return this.prezzo;
	}
	public double getTempoPreparazione(){
		return this.tempo_preparazione;
	}
	
	public int getCodiceProdotto(){
		return this.codice_prodotto;
	}
	
	
	public void setCodiceProdotto(int p_codice){
		this.codice_prodotto=p_codice;
	}
	
	public void setNomeProdotto(String n_prodotto){
		this.nome_prodotto=n_prodotto;
	}
	public void setPrezzo(double n_prezzo){
		this.prezzo=n_prezzo;
	}
	public void setTempoPreparazione(double t_preparazione){
		this.tempo_preparazione=t_preparazione;
	}

}

