package businessLayer;
import java.util.Date;


public class Produit {
	// attributs
	private int id;
	private Fournisseur fournisseur;
	private double prixAchat;
	private double prixVente;
	private Date dateAchat;
	private int quantite;
	private String nom;
	private String description;
	private int quantiteInitiale;
	
	// Constructeur
	public Produit(int id,Fournisseur fournisseur,String nom,Date dateAchat,double prixAchat,int quantiteInitiale,double prixVente,String description)
	{
		this.id=id;
		this.fournisseur=fournisseur;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.dateAchat=dateAchat;
		this.quantite=quantiteInitiale;
		this.nom=nom;
		this.description=description;
		this.quantiteInitiale=quantiteInitiale;
	}
	public Produit(int id,Fournisseur fournisseur,String nom,Date dateAchat,double prixAchat,int quantiteInitiale,int quantite,double prixVente,String description)
	{
		this.id=id;
		this.fournisseur=fournisseur;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.dateAchat=dateAchat;
		this.quantite=quantite;
		this.nom=nom;
		this.description=description;
		this.quantiteInitiale=quantiteInitiale;
	}
	
	public Produit(Fournisseur fournisseur,String nom,Date dateAchat,double prixAchat,int quantite,double prixVente,String description)
	{
		//this.id=id;
		this.fournisseur=fournisseur;
		this.prixAchat=prixAchat;
		this.prixVente=prixVente;
		this.dateAchat=dateAchat;
		this.quantite=quantite;
		this.nom=nom;
		this.description=description;
		this.quantiteInitiale=quantite;
	}
	
	public Produit()
	{
		
	}
	
	// getters 
	public int getQuantiteInitiale()
	{
		return this.quantiteInitiale;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public Fournisseur getFournisseur()
	{
		return this.fournisseur;
	}
	public String getFournisseurNom()
	{
		return this.getFournisseur().getNom();
	}
	
	public double getPrixAchat()
	{
		return this.prixAchat;
	}
	
	public double getPrixVente()
	{
		return this.prixVente;
	}
	
	public Date getDateAchat()
	{
		return this.dateAchat;
	}
	
	public int getQuantite()
	{
		return this.quantite;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	

	
	// setters
	public void setId(int input)
	{
		this.id=input;
	}

	public void setPrixAchat(double input)
	{
		this.prixAchat=input;
	}
	
	public void setIdFournisseur(Fournisseur input)
	{
		this.fournisseur=input;
	}
	
	public void setPrixVente(double input)
	{
		this.prixVente=input;
	}
	
	public void setQuantite(int input)

	{
		this.quantite=input;
	}
	
	public void setDescription(String input)
	{
		this.description=input;
	}


	public void setNom(String input)
	{
		this.nom=input;
	}
	
	public void setDateAchat(Date input)
	{
		this.dateAchat=input;
	}
	
	public void setQuantiteInitiale(int input)
	{
		this.quantiteInitiale=input;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
