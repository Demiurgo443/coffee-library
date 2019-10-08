import java.util.ArrayList;

public class Soci {
	
	ArrayList <Utente> ListaSoci;

		public Soci(){
			ListaSoci = new ArrayList<Utente>();
		}
		public ArrayList<Utente> getElenco() {
			return ListaSoci;
		}
		public void aggiungiUtente(String n_nome, String n_cognome, String n_mail, String n_password){
			Utente nuovoUtente = new Utente(n_nome, n_cognome, n_mail, n_password, -1);
			ListaSoci.add(nuovoUtente);
		}
		
	//serve nel riepilogo dell'ordine	
		public Utente getUtente(String n_mail){
			for(Utente s: ListaSoci){
				if(s.getMail().equals(n_mail))
					return s;
			}
			return null;
		}
		
		public boolean doppioUtente(String n_mail) {
			for(Utente s: ListaSoci) {
				if(s.getMail().equals(n_mail)) {
					System.out.println("Questa mail esiste già. Riprova.");
					return true;
				}
			}return false;
		}
		
	//check per vedere se esiste già l'utente
		public boolean checkUtente(String n_mail, String n_password) {
			for(Utente s: ListaSoci) {
				if(s.getMail().equals(n_mail) && s.getPassword().equals(n_password)) {
					System.out.println("è un piacere rivederti "+s.getNome()+"!");
					return true;
				}
			}
			return false;
		}
		
	//stampa a video l'elenco dei soci attualmente registrati
		public void stampaElencoSoci(){
			System.out.println("\nElenco soci\n");
			String leftAlignmentFormat = "| %-12s | %-12s | %-35s |%n";
			System.out.format("+--------------+--------------+-------------------------------------+%n");
			System.out.format("| NOME         | COGNOME      | MAIL                                |%n");
			System.out.format("+--------------+--------------+-------------------------------------+%n");
			for(Utente s: ListaSoci){
				System.out.format(leftAlignmentFormat, s.getNome(), s.getCognome(), s.getMail());
			}
			System.out.format("+--------------+--------------+-------------------------------------+%n");
		}

		// metodo che associa il libro all'utente nel momento del prestito (sempre che esso non ne abbia già uno in prestito)
		public void prestaLibro(int cod, String mail) {
			for(Utente s: ListaSoci) {
				if(s.getMail().equals(mail)) {
					if(s.getLibro()== -1) {
						s.setLibro(cod);
					}
				}
			}
		}
		
		//metodo che estrapola dall'utente il libro che aveva in prestito restituendone il codice (viene invocato alla restituzione) e porta l'utente alla condizione di default
		public int restituisciLibro(String mail) {
			for(Utente s: ListaSoci) {
				if(s.getMail().equals(mail)) {
					int cod = s.getLibro();
					s.setLibro(-1);
					return cod;
					
				}
			}
			return 0;// non importa che sia 0 o -1 etc... non verrà mai eseguito perché controlli di metodi precedenti garantiscono il return cod
		}
		
	//metodo che serve per verificare se l'utente ha in prestito un libro
		public boolean prestitoLibro(String n_mail){
			for(Utente s: ListaSoci){
				if(s.getMail().equals(n_mail)){
					if(s.getLibro()!= -1){
//					System.out.println("hai già un libro in prestito");
					return true;
					}
				}
			}
			return false;
		}

}
