import java.util.ArrayList;

import utilities.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Biblio_Caffetteria {
	
	
	public static Menu MenuCaffetteria;
	public static Catalogo CatalogoCaffetteria;
	public static Soci ElencoSoci;
	public static Ordine OrdineProdotti;
	static ArrayList <Ordine> ListaOrdini;
	
	
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	
//metodo che permette l'autenticazione o la registrazione di un utente	
	public static void autenticazione()throws IOException{
		
		//dichiaro le variabili
		String nome;
		String cognome;
		String mail;
		String password;
		String sceltaAccount1; // variabile serve all'utente per dire se è nuovo utente o meno
		String sceltaAccount2; // variabile serve all'utente per dire se è utente già registrato o meno
		String retryAccount; //variabile serve all'utente per dire se vuole ritentare la procedura di registrazione/autenticazione.
		boolean riprova = false; //variabile che serve per far concludere o meno "autenticazione()"
		
		do {
			//chiedo se si è già registrati oppure no, in caso la risposta non corrisponda continua a chiedere
			do {
				System.out.println("Sei un nuovo utente? (Y/N)");
			}while(utilities.Formatter.sceltaErrata(sceltaAccount1=br.readLine()));
			
			//procedura di registrazione
			if (sceltaAccount1.toUpperCase().equals("Y")){
 
				riprova = false;//una volta registrato non ho motivo di ricominciare "autenticazione()"
				

				//inserisco tutti i parametri per la creazione di un nuovo utente. Se uno non è "valido" continua a richiederlo.
				do {
					System.out.println("Inserisci il nome: ");
				}while(utilities.Formatter.stringaVuota(nome = utilities.Formatter.soloLettere(br.readLine())));
				
				do {
					System.out.println("Inserisci il cognome: ");
				}while(utilities.Formatter.stringaVuota(cognome = utilities.Formatter.soloLettere(br.readLine())));
				
				do {
					do {
						System.out.println("Inserisci la mail (se inserisci spazi vuoti non verranno memorizzati!): ");
					}while(utilities.Formatter.stringaVuota(mail = utilities.Formatter.deleteWhiteSpace(br.readLine())));
				}while(ElencoSoci.doppioUtente(mail));
				
				do {
					System.out.println("Inserisci la password: ");
				}while(utilities.Formatter.stringaVuota(password = utilities.Formatter.formatPassword(br.readLine())));

				
				//viene creato l'utente passandogli i precedenti parametri e formattando il "nome" e il "cognome"
				ElencoSoci.aggiungiUtente(utilities.Formatter.formatString(nome), utilities.Formatter.formatString(cognome), mail, password);
				System.out.println("\nNuovo utente registrato\n------------------------------------\n");
//				ElencoSoci.stampaElencoSoci(); //si lancia questa funzione solo se si vuole verificare i soci registrati (preimpostati e nuovi)
				
				//creo nuovo ordine e lo aggiungo alla lista ordini
				ListaOrdini.add(NuovoOrdine(mail));
				//chiamo la funzione che mi permetterà di prendere/restituire i libri.
				prestitoLibri(mail);
				
			}
			
			else if (sceltaAccount1.toUpperCase().equals("N")){
				do {
					System.out.println("Sei già un utente registrato? (Y/N)");
				}while(utilities.Formatter.sceltaErrata(sceltaAccount2=br.readLine()));
				
				//procedura di login utente già registrato
					if (sceltaAccount2.toUpperCase().equals("Y")) {
						
						do {
							System.out.println("Inserisci la mail: ");
						}while(utilities.Formatter.stringaVuota(mail = utilities.Formatter.deleteWhiteSpace(br.readLine())));
						
						do {
							System.out.println("Inserisci la password: ");
						}while(utilities.Formatter.stringaVuota(password = utilities.Formatter.deleteWhiteSpace(br.readLine())));
						
						
						if(ElencoSoci.checkUtente(mail, password) == true) {
							riprova = false;
							prestitoLibri(mail);
							ListaOrdini.add(NuovoOrdine(mail));
							
						}else {
							
							do {
							System.out.println("Errore. Vuoi ritentare il login? (Y/N)");
							}while(utilities.Formatter.sceltaErrata(retryAccount=br.readLine()));
							
							if (retryAccount.toUpperCase().equals("Y")) {
								riprova = true;
							}
							else if (retryAccount.toUpperCase().equals("N")) {
								System.out.println("Per usufruire dei servizi hai l'obbligo di registrazione.");
								riprova = true;
							}
						}
					}else if(sceltaAccount2.toUpperCase().equals("N")) {
						System.out.println("Per usufruire dei servizi hai l'obbligo di registrazione.");
						riprova = true;
						
						}
				}
				
		}while(riprova != false);
	}

	
	
// funzione che permette di creare l'ordine scegliendo uno o più prodotti dal menu.
	public static void creaOrdine() throws IOException {
		System.out.println("Ecco la lista prodotti\n");
		MenuCaffetteria.stampaMenu();
		String sceltaProdotto;
		String sceltaFinale;
		String codString;
		int cod;
		
//		vado a scegliere il/i prodotti
		do{
			do{
				
				do {
					do {
						System.out.println("Scegli un prodotto (inserisci codice numerico)");	
					}while(utilities.Formatter.stringaVuota(codString=utilities.Formatter.checkInt(br.readLine())));//eseguo finché la stringa non avrà dei numeri
					cod=Integer.parseInt(codString);
				}while(!OrdineProdotti.prendiProdotto(cod, MenuCaffetteria));//eseguo finché effettivamente non prendo un prodotto valido
				OrdineProdotti.stampaElencoProdotti();
				
				do {
					System.out.println("Vuoi scegliere un altro prodotto? (Y/N)");
				}while(utilities.Formatter.sceltaErrata(sceltaProdotto = br.readLine())); 
				
			}while(!sceltaProdotto.toUpperCase().equals("N"));
			
			do {
				System.out.println("Vuoi concludere l'ordine? (Y/N)");
			}while(utilities.Formatter.sceltaErrata(sceltaFinale=br.readLine()));
			
			if(sceltaFinale.toUpperCase().equals("Y")){
				OrdineProdotti.riepilogoOrdine();
			}
			
		}while(!sceltaFinale.toUpperCase().equals("Y"));

	}
	
	
	public static boolean effettuaPrestito (int cod, String mail) {
		while(CatalogoCaffetteria.prendiLibro(cod)) {
			ElencoSoci.prestaLibro(cod, mail);
			return true;
		}
		return false;
	}

	public static void effettuaRestituzione (String mail) {
		CatalogoCaffetteria.ritornaLibro(ElencoSoci.restituisciLibro(mail));
	}

	
	
// funzione che permette il prestito dei libri	
	public static void prestitoLibri(String mail) throws IOException {

		String sceltaLibro;
		String codString;
		int cod;
		
		do {
			System.out.println("\nVuoi prendere in prestito un libro? (Y/N)");
			}while(utilities.Formatter.sceltaErrata(sceltaLibro=br.readLine()));
		
		//se vuoi prendere il libro in prestito e non ne hai altri
		if ((sceltaLibro.toUpperCase().equals("Y")) && (ElencoSoci.prestitoLibro(mail) == false)){
			System.out.println("Ecco l'elenco di libri disponibili:\n");
			CatalogoCaffetteria.stampaDisponibili();
			do {
				do {
					System.out.println("\n\nQuale libro vuoi? (inserisci codice numerico)");
				}while(utilities.Formatter.stringaVuota(codString=utilities.Formatter.checkInt(br.readLine())));
				cod=Integer.parseInt(codString);
			}while(!effettuaPrestito(cod, mail));
		}
		//se non vuoi prendere il libro in prestito e non ne hai altri
		else if ((sceltaLibro.toUpperCase().equals("N")) && (ElencoSoci.prestitoLibro(mail) == false)){
			System.out.println();
		}
		//se vuoi prendere il libro in prestito ma ne hai già uno in prestito
		else if ((sceltaLibro.toUpperCase().equals("Y")) && ElencoSoci.prestitoLibro(mail) == true){
			
			do {
				System.out.println("Hai già un libro in prestito");
				System.out.println("Vuoi restituire il libro? (Y/N)");
			}while(utilities.Formatter.sceltaErrata(sceltaLibro=br.readLine()));
			
			if (sceltaLibro.toUpperCase().equals("Y")) {
				
				effettuaRestituzione(mail);
				
				System.out.println("Ecco l'elenco di libri disponibili:\n");
				CatalogoCaffetteria.stampaDisponibili();
				
				do {
					do {
						System.out.println("\n\nQuale libro vuoi? (inserisci codice numerico)");
					}while(utilities.Formatter.stringaVuota(codString=utilities.Formatter.checkInt(br.readLine())));
					cod = Integer.parseInt(codString);
				}while(!effettuaPrestito(cod, mail));
			}
			if (sceltaLibro.toUpperCase().equals("N")) {
				System.out.println("Non puoi prendere un libro se ne hai già uno in prestito.");
			}
		}
		//se non vuoi prendere il libro in prestito ma ne hai già uno
		else if ((sceltaLibro.toUpperCase().equals("N")) && ElencoSoci.prestitoLibro(mail) == true){
			
			do {
				System.out.println("Vuoi restituire il libro?(Y/N)");
			}while(utilities.Formatter.sceltaErrata(sceltaLibro=br.readLine()));

			if (sceltaLibro.toUpperCase().equals("Y")) {
				effettuaRestituzione(mail);
			}
			if (sceltaLibro.toUpperCase().equals("N")) {
				System.out.println();//mettere tipo una frase come "non hai restituito il libro"
			}
		}
	}
	
	
	
	//il main
	public static void main(String[] args) throws IOException
	{
		CaricaCatalogo();
		CaricaMenu();
		CaricaSoci();
		ListaOrdini = new ArrayList <Ordine>();

		while(true) {
			System.out.format("+----------------------------------------+%n");
			System.out.format("| Benvenuti nella mio Biblio-Caffetteria |%n");
			System.out.format("+----------------------------------------+%n");
	
			autenticazione();
			creaOrdine();
		}

	}

	
	
	public static Ordine NuovoOrdine(String mail){
		OrdineProdotti = new Ordine(utilities.GetCurrentDateTime.data(), utilities.GetCurrentDateTime.time(), ListaOrdini.size(), ElencoSoci.getUtente(mail));
		return OrdineProdotti;
	}

	public static void CaricaSoci(){
		ElencoSoci = new Soci();
		ElencoSoci.aggiungiUtente("Some", "One", "some.one@unknown.com", "hacker");
//		ElencoSoci.aggiungiUtente(nome, cognome, mail, password);
	}
	
	public static void CaricaCatalogo(){
		CatalogoCaffetteria = new Catalogo();
		CatalogoCaffetteria.aggiungiLibro("1984", "George Orwell");
		CatalogoCaffetteria.aggiungiLibro("Addio alle Armi", "Ernest Hemingway");
		CatalogoCaffetteria.aggiungiLibro("Cecità", "Josè Saramago");
		CatalogoCaffetteria.aggiungiLibro("La Tregua", "Primo Levi");
		CatalogoCaffetteria.aggiungiLibro("Uno, nessuno e centomila", "Luigi Pirandello");
		CatalogoCaffetteria.aggiungiLibro("Qualcuno con cui correre", "David Grossman");
		CatalogoCaffetteria.aggiungiLibro("La nave delle anime perdute", "Alberto Cavanna");
//		CatalogoCaffetteria.aggiungiLibro(titolo, autore);
	}
	
	public static void CaricaMenu(){
		MenuCaffetteria=new Menu();
		MenuCaffetteria.aggiungiProdotto("caffè", 0.5, 1);
		MenuCaffetteria.aggiungiProdotto("cappuccino", 1.5, 1.25);
		MenuCaffetteria.aggiungiProdotto("latte", 1, 0.5);
		MenuCaffetteria.aggiungiProdotto("caffè corretto", 0.75, 1.5);
		MenuCaffetteria.aggiungiProdotto("spremuta d'arancia", 0.75, 0.5);
		MenuCaffetteria.aggiungiProdotto("thé", 0.5, 2.5);
		MenuCaffetteria.aggiungiProdotto("cioccolata calda", 3.5, 2);
//		MenuCaffetteria.aggiungiProdotto(nome, prezzo, tempo);
	}
	

}
