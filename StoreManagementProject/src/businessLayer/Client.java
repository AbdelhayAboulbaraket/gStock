package businessLayer;

public class Client {
	private int idClient;
	private String nom;
	private String email;
	private String tel;
	private String adresse;
	
	//Constructeur
	public Client(int idClient,String nom,String email,String tel,String adresse)
	{
		this.idClient=idClient;
		this.nom=nom;
		this.email=email;
		this.tel=tel;
		this.adresse=adresse;
	}
	
	public Client(String nom,String email,String tel,String adresse)
	{
		this.nom=nom;
		this.email=email;
		this.tel=tel;
		this.adresse=adresse;
	
	}
	
	public Client()
	{
		
	}
	
	//getters
	public int getId()
	{
		return this.idClient;
	}
    public String getTel()
    {
    	return this.tel;
    }
    public String getAdresse()
    {
    	return this.adresse;
    }
    
	public String getNom()
	{
		return this.nom;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	//setters
	
	public void setId(int input)
	{
		this.idClient=input;
	}
	
	public void setNom(String input)
	{
		this.nom=input;
	}
	
	public void setEmail(String input)
	{
		this.email=input;
	}
	
	public void setTel(String input)
	{
		this.tel=input;
	}
	public void setAdresse(String input)
	{
		this.adresse=input;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
