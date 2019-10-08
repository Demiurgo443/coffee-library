import java.util.ArrayList;


public class Menu {
	
	ArrayList <Prodotto> menu;
	
	public Menu(){
		menu = new ArrayList<Prodotto>();
	}
	
	public void stampaMenu () {
			String leftAlignmentFormat = "| %-6d | %-21s | %-6.2f | %-21.2f |%n";
			System.out.format("+--------+-----------------------+--------+-----------------------+%n");
			System.out.format("| CODICE | NOME PRODOTTO         | PREZZO | TEMPO DI PREPARAZIONE |%n");
			System.out.format("+--------+-----------------------+--------+-----------------------+%n");
			for (Prodotto p: menu){
				System.out.format(leftAlignmentFormat, p.getCodiceProdotto(), p.getNomeProdotto(), p.getPrezzo(), p.getTempoPreparazione());
	}
			System.out.format("+--------+-----------------------+--------+-----------------------+%n");
	}
	
	public void aggiungiProdotto(String n_prodotto, double n_prezzo, double t_preparazione){
		Prodotto nuovoProdotto = new Prodotto (n_prodotto, n_prezzo, t_preparazione, menu.size());
		menu.add(nuovoProdotto);
	//	System.out.println("Un nuovo prodotto è stato aggiunto al menu");

	}
	
	public int dimensioneMenu(){
		return menu.size();
	}
	
	public ArrayList <Prodotto> getMenu(){
		return menu;
	}
	
	public Prodotto OrdineProdotto(int cod){
		for(Prodotto pr: menu){
			if (pr.getCodiceProdotto()==cod){
				return pr;
			}
		}return null;
	}
	
		
}
