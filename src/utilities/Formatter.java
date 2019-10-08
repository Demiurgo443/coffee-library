package utilities;


public class Formatter {
	
//formatto la stringa in modo che la prima lettera sia maiuscola, tutto il resto minuscolo
public static String formatString(String string) {
	string = string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
	return string;
}


public static String deleteWhiteSpace(String string) {
	string = string.replaceAll("\\s+", "");
	return string;
}

//prendo in input una stringa e tolgo tutto ciò che è diverso dalle semplici lettere dell'alfabeto e ritorno la stringa modificata
public static String soloLettere(String string) {
	string = string.replaceAll("[^A-Za-z]", "");
	return string;
}

//metodo che permette di "forzare" un valore double a mettere due cifre decimali
public static String formatNumeri(double value) {
	String doubleFormat = "%.2f";
	String output = String.format(doubleFormat, value);
	return output;
}

public static boolean stringaVuota(String string) {
	if (string.isEmpty()) {
		System.out.println("Attenzione, non puoi lasciare vuoto il campo!");
		return true;
	}return false;
}

public static String checkInt (String string) {
	string = string.replaceAll("[^\\d]", "");
	return string;
}

public static boolean sceltaErrata (String scelta) {
	scelta = soloLettere(scelta);
	while(!stringaVuota(scelta)) {
		scelta=scelta.toUpperCase();
		if(!scelta.equals("Y") && !scelta.equals("N")) {
			System.out.println("Errore input. Riprova.");
			return true;
		}return false;
	}return true;
}

public static String formatPassword(String password) {
	password = deleteWhiteSpace(password);
	if (password.length()<7) {
		System.out.println("Errore: la password deve essere lunga almeno 7 caratteri (alfanumerici e/o speciali)");
		password="";
		return password;
	}return password;
}


}
