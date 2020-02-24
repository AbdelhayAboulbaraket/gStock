package persistenceLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import businessLayer.Fournisseur;
import businessLayer.Vente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VenteDAO extends DAO<Vente>{
	public VenteDAO() {
	    super();
	  }
	
	public ObservableList<Vente> selectAll()
	{  ObservableList<Vente> ventes=FXCollections.observableArrayList();

	   ProduitDAO prod=new ProduitDAO();
	   Vente vente;
	   ClientDAO client=new ClientDAO();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * from vente");
			
			while(result.next())
			{
				vente=new Vente(result.getInt(1),prod.find(result.getInt(2)),client.find(result.getInt(3)),result.getInt(4),result.getDate(5),result.getInt(6));
				ventes.add(vente);
			}
			
		}catch( SQLException e )
		{
			e.printStackTrace();
		}
		return ventes;
		
	}
	
	public boolean create(Vente obj)
	{  
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

	   String currentTime = sdf.format(obj.getDateVente());
		try
		{
			 
			 this.connect.getConn().createStatement().executeUpdate(
					 "INSERT INTO vente(id_produit,id_client,quantite,date_vente,total) VALUES("+obj.getProduit().getId()+","+obj.getClient().getId()+
					 ","+obj.getQuantite()+",'"+currentTime+"',"+obj.getTotal()+");"
					 );
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(Vente obj)
	  {
		  try {
			Statement req=this.connect.getConn().createStatement();
			String sql="Delete from Vente where id_vente="+obj.getIdVente()+";";
			req.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		  return true;
	  }
	
	public boolean update(Vente obj)
	  {

		try {
			
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

			  String currentTime = sdf.format(obj.getDateVente());
			  System.out.println(currentTime);
			
			Statement req = this.connect.getConn().createStatement();
			 String sql="update vente set id_produit="+obj.getProduit().getId()+", id_client="+obj.getClient().getId()+", quantite="+obj.getQuantite()
			 +", date_vente="+currentTime+" , total="+obj.getTotal()+" where id_vente="+obj.getIdVente()+";";
			  req.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		  
		  return true;
	  }

	 public Vente find(int id) 
	  {
		  Vente vente=null;
		  ProduitDAO produitDAO= new ProduitDAO();
		  ClientDAO clientDAO = new ClientDAO();
		  try {
			  Statement req=this.connect.getConn().createStatement();
			  String sql="Select * from vente where id_vente="+id+";";
			  ResultSet result=req.executeQuery(sql);
			  if(result.first())
			  {
				  vente=new Vente(
						  result.getInt(1),
						  produitDAO.find(result.getInt(2)),
						  clientDAO.find(result.getInt(3)),
						  result.getInt(4),
						  result.getDate(5),
						  result.getInt(6)
						  );
			  }
			  
			 
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return vente;
		  
	  }
	

}
