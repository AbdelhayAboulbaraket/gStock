package businessLayer;
import java.util.Date;


public class Vente {
	private int idVente;
	private Produit produit;
	private Client client;
	private int quantite;
	private Date dateVente;
	private double total;
	
	//Constructeur
	public Vente(int idVente,Produit produit,Client client,int quantite,Date dateVente,double total)
	{
		this.idVente=idVente;
		this.produit=produit;
		this.client=client;
		this.quantite=quantite;
		this.dateVente=dateVente;
		this.total=total;
	}
	
	public Vente(int idVente,Produit produit,Client client,int quantite,Date dateVente)
	{
		this.idVente=idVente;
		this.produit=produit;
		this.client=client;
		this.quantite=quantite;
		this.dateVente=dateVente;
		this.total=quantite*produit.getPrixVente();
	}
	
	public Vente(Produit produit,Client client,int quantite,Date dateVente,int total)
	{
		this.produit=produit;
		this.client=client;
		this.quantite=quantite;
		this.dateVente=dateVente;
		this.total=total;
	}
	public Vente(Produit produit,Client client,int quantite,Date dateVente)
	{
		this.produit=produit;
		this.client=client;
		this.quantite=quantite;
		this.dateVente=dateVente;
		this.total=quantite*produit.getPrixVente();
	}
	
	public Vente()
	{
		
	}
	
	// getters
	public int getIdVente()
	{
		return this.idVente;
	}
	
	public Produit getProduit()
	{
		return this.produit;
	}
	
	public Client getClient()
	{
		return this.client;
	}
	
	public Date getDateVente()
	{
		return this.dateVente;
	}
	
	public int getQuantite()
	{
		return this.quantite;
	}
	
	public double getTotal() {
		return total;
	}
	
	public String getProduitNom()
	{
		return this.getProduit().getNom();
	}
	
	public double getProduitPrixVente()
	{
		return this.getProduit().getPrixVente();
	}
	
	public String getClientNom()
	{
		return this.getClient().getNom();
	}
	
 

    // setters
    public void setIdVente(int input)
    {
    	this.idVente=input;
    }
	


    public void setDateVente(Date input)
    {
    	this.dateVente=input;
    }

    public void setClient(Client input)
    {
    	this.client=input;
    }
	
    public void setQuantite(int input)
    {
    	this.quantite=input;
    }

    public void setProduit(Produit input)
    {
    	this.produit=input;
    }


	public void setTotal(int input) {
		this.total = input;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
