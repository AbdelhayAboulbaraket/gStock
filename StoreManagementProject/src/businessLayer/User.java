package businessLayer;

public class User {
	private String idUser;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	//constructeur
	public User(String idUser,String nom,String prenom,String motDePasse)
	{
		this.idUser=idUser;
		this.nom=nom;
		this.prenom=prenom;
		this.motDePasse=motDePasse;
	}
	
	public User()
	{
		
	}
	
	//Getters
	public String getIdUser()
	{
		return this.idUser;
	}

	public String getNom()
	{
		return this.nom;
	}
	
	public String getPrenom()
	{
		return this.prenom;
	}
	
	public String getMotDePasse()
	{
		return this.motDePasse;
	}
	
	//setters
	public void setIdUser(String input)
	{
		this.idUser=input;
	}
	
	public void setNom(String input)
	{
		this.nom=input;
	}
	
	public void setPrenom(String input)
	{
		this.prenom=input;
	}
	
	public void setMotDePasse(String input)
	{
		this.motDePasse=input;
	}
	
	
	
	
}
