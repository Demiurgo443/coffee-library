import java.util.ArrayList;

import utilities.Formatter;

public class Ordine {
	
//creo campi di esemplari
	private String data;
	private String time;
	private int numero_ordine;
	private Utente cliente;
	ArrayList<Prodotto> OrdineProdotti;

//creo il costruttore
	public Ordine(String n_data, String n_time, int num_ordine, Utente n_cliente){
	time=n_time;
	data=n_data;
	numero_ordine=num_ordine;
	cliente=n_cliente;
	OrdineProdotti= new ArrayList <Prodotto> ();
	}

//creo i metodi
	public void aggiungiProdotto(Prodotto nuovoProdotto){
		OrdineProdotti.add(nuovoProdotto);
		System.out.println("Un nuovo prodotto è stato ordinato e aggiunto all'ordine");
	
	}
	
	public void stampaElencoProdotti(){
		System.out.println("\n\nElenco prodotti\n");
		String leftAlignmentFormat = "| %-21s | %-6.2f | %-5.2f |%n";
		System.out.format("+-----------------------+--------+-------+%n");
		System.out.format("| NOME PRODOTTO         | PREZZO | TEMPO |%n");
		System.out.format("+-----------------------+--------+-------+%n");
		for(Prodotto p: OrdineProdotti){
			System.out.format(leftAlignmentFormat, p.getNomeProdotto(), p.getPrezzo(), p.getTempoPreparazione());
		}
		System.out.format("+-----------------------+--------+-------+%n");
	}
	
	public double tempoDiPreparazione(){
		double tempo_massimo=0;
		for(Prodotto p: OrdineProdotti){
			if (p.getTempoPreparazione() >= tempo_massimo){
				tempo_massimo=p.getTempoPreparazione();
			}
		}
		return tempo_massimo;
	}
	public double costoOrdine() {
		double costo_totale=0;
		for(Prodotto p: OrdineProdotti) {
				costo_totale+=p.getPrezzo();
		}
		return costo_totale;
	}
	
	public boolean prendiProdotto(int n_codice, Menu menuCorrente){
		if(n_codice <= menuCorrente.dimensioneMenu()){
			for (Prodotto p: menuCorrente.getMenu()){
				if(p.getCodiceProdotto()== n_codice){
					aggiungiProdotto(menuCorrente.OrdineProdotto(n_codice));
					return true;
				}
			}
		}
		System.out.println("Il codice inserito non corrisponde ad alcun prodotto presente nel menu.");
		return false;	
	}
	
	public void riepilogoOrdine() {
		System.out.println("Riepilogo Ordine");
		System.out.println("------------------------------------------\n");
		System.out.println("L'ordine è stato effettuato da: "+ this.getCliente().getNome());
		System.out.println("In data: " + this.getData());
		System.out.println("Alle ore: "+ this.getTime());
		System.out.println("Clienti in attesa: "+this.getNumeroOrdine());
		System.out.println("Tempo di preparazione dell'ordine: " +Formatter.formatNumeri(this.tempoDiPreparazione())+"min.");
		System.out.println("Totale da pagare: "+ Formatter.formatNumeri(this.costoOrdine()) +"€" );
		System.out.println("\n------------------------------------------\n\n");
	}
	
	
	
	public String getData(){
		return this.data;
	}
	public String getTime(){
		return this.time;
	}
	public int getNumeroOrdine(){
		return this.numero_ordine;
	}
	
	public Utente getCliente(){
		return this.cliente;
	}

	public void setData(String n_data){
		this.data=n_data;
	}
	public void setTime(String n_time){
		this.time=n_time;
	}
	public void setNumeroOrdine(int num_ordine){
		this.numero_ordine=num_ordine;
	}

	public void setCliente (Utente n_cliente){
		this.cliente=n_cliente;
	}
	
}
