import java.util.ArrayList;

public class Catalogo {
	
	ArrayList<Libro> CatalogoLibri;
	
	public Catalogo(){
		CatalogoLibri = new ArrayList<Libro>();
	}
	
	public void aggiungiLibro(String n_titolo, String n_autore){
		Libro nuovoLibro = new Libro (n_titolo, n_autore, true, CatalogoLibri.size());
		CatalogoLibri.add(nuovoLibro);
	}
	
/*	//controllo che stampa tutti i libri indipendentemente che siano in prestito o meno
	public void stampaLibri(){
		System.out.println("COD.\tTITOLO");
		for (Libro l: CatalogoLibri){
			System.out.println(l.getCodice()+"\t"+l.getTitolo());
		}
		
	}
*/	
	public void stampaDisponibili(){
		System.out.println("Libri disponibili per il prestito");
		String leftAlignmentFormat = "| %-6d | %-33s | %-26s |%n";
		System.out.format("+--------+-----------------------------------+----------------------------+%n");
		System.out.format("| CODICE | TITOLO                            | AUTORE                     |%n");
		System.out.format("+--------+-----------------------------------+----------------------------+%n");
		for (Libro l: CatalogoLibri){
			if (l.getDisponibilità() == true)
				System.out.format(leftAlignmentFormat, l.getCodice(), l.getTitolo(), l.getAutore());
		}
		System.out.format("+--------+-----------------------------------+----------------------------+%n");
	}
	
	//dopo aver controllato l'effettiva esistenza del libro, identificato quale libro e verificato che sia disponibile, lo prendo in prestito settando la sua disponibilità a false
	public boolean prendiLibro(int n_codice){
		if(n_codice <= CatalogoLibri.size()){
			for (Libro l: CatalogoLibri){
				if(l.getCodice()== n_codice)
					if(l.getDisponibilità()==true){
						l.setDisponibilità(false);
						System.out.println("Hai preso in prestito il libro: "+l.getTitolo()+"\nDi: "+l.getAutore()+"\n");
						return true;
					}
			}
		}
		System.out.println("Il codice inserito non corrisponde ad alcun libro presente nel catalogo.");
		return false;	
	}
	
	public boolean ritornaLibro(int n_codice){
		if(n_codice <= CatalogoLibri.size()){
			for(Libro l: CatalogoLibri){
				if(l.getCodice()== n_codice){
					if(l.getDisponibilità() == false){
						l.setDisponibilità(true);
						System.out.println("Hai restituito: "+l.getTitolo());
						return true;
					}
				}
			}
		}return false;
	}

}
