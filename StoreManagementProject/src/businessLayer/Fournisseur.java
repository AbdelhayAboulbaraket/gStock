package businessLayer;

public class Fournisseur {
	//attributs
	private int idFournisseur;
	private String nom;
	private String numero;
	private String email;
	private String adresse;

	
	//Constructeur
	public Fournisseur(int idFournisseur,String nom,String numero,String email,String adresse)
	{
		this.idFournisseur=idFournisseur;
		this.nom=nom;
		this.numero=numero;
		this.email=email;
		this.adresse=adresse;

	}
	
	public Fournisseur(String nom,String numero,String email,String adresse)
	{
		
		this.nom=nom;
		this.numero=numero;
		this.email=email;
		this.adresse=adresse;
	}
	
	public Fournisseur()
	{
		
	}

	//getters
	public int getIdFournisseur()
	{
		return this.idFournisseur;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String getNumero()
	{
		return this.numero;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getAdresse()
	{
		return this.adresse;
	}
	

	//setters
	
	public void setIdFournisseur(int input)
	{
		this.idFournisseur=input;
	}
	
	public void setNom(String input)
	{
		this.nom=input;
	}
	
	public void setNumero(String input)
	{
		this.numero=input;
	}
	
	public void setEmail(String input)
	{
		this.email=input;
	}
	
	public void setAdresse(String input)
	{
		this.adresse=input;
	}
	
	
}
