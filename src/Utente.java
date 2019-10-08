//creo la classe Utente
public class Utente {
	
//campi di esemplare
	private String nome;
	private String cognome;
	private String mail;
	private String password;
	private int libro;


//creo il costruttore
	public Utente(String n_nome, String n_cognome, String n_mail, String n_password, int p_libro){
	nome=n_nome;
	cognome=n_cognome;
	mail=n_mail;
	password=n_password;
	libro=p_libro;
	}

//creo metodi

 
	public String getNome(){
		return this.nome;
	}

	public void setNome(String n_nome){
		this.nome=n_nome;
	}
	
	public String getCognome(){
		return this.cognome;
	}
	
	public void setCognome(String n_cognome){
		this.cognome=n_cognome;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public void setMail(String n_mail){
		this.mail=n_mail;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setPassword(String n_password){
		this.password=n_password;
	}
	
	public int getLibro(){
		return this.libro;
	}
	
	public void setLibro(int p_libro){
		this.libro=p_libro;
	}
	

}
