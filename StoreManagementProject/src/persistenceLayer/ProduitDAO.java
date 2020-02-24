package persistenceLayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import businessLayer.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ProduitDAO extends DAO<Produit>{
	public ProduitDAO() {
	    super();
	  }
	
	public Produit find(String s)
	{
		Produit produit=null; 
	      FournisseurDAO fournisseurDAO=new FournisseurDAO();
	    try 
	    {
	      
	      ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM Produit WHERE nom='"+s+"';");
	      if(result.first())
	      {
	    	 //result.getMetaData().getColumnCount();
	    	 produit=new Produit(
	    			 result.getInt(1),
	    			 fournisseurDAO.find(result.getInt(2)),
	    			 result.getString(3),
	    			 result.getDate(4),
	    			 result.getDouble(5),
	    			 result.getInt(6),
	    			 result.getInt(7),
	    			 result.getDouble(8),
	    			 result.getString(9)
	    			 );
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return produit;
	  }
	
      public ObservableList<Produit> selectAll()
      {
    	  ObservableList<Produit> returndiali=FXCollections.observableArrayList();
    	  FournisseurDAO fournisseur=new FournisseurDAO();
    	 try
    	 {
    		 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * from PRODUIT;");
    		 
    		 while(result.next())
    		 {

    				 
    				 
    				 Produit prod=new Produit(
    		    			 result.getInt(1),
    		    			 fournisseur.find(result.getInt(2)),
    		    			 result.getString(3),
    		    			 result.getDate(4),
    		    			 result.getDouble(5),
    		    			 result.getInt(6),
    		    			 result.getInt(7),
    		    			 result.getDouble(8),
    		    			 result.getString(9)
    		    			 );
    				 returndiali.add(prod);
    		      
    			 
    		 }
    		 return returndiali;
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	  return returndiali;
    	  
      }
      
      public ObservableList<String> selectAllNames()
      {
    	  ObservableList<String> returndiali=FXCollections.observableArrayList();
    	  
    	 try
    	 {
    		 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select nom from PRODUIT;");
    		 
    		 while(result.next())
    		 {

    		    			 
    				 returndiali.add(result.getString(1));
    		      
    		 }
    	 }
    	 catch(SQLException e)
    	 {
    		 e.printStackTrace();
    	 }
    	  return returndiali;
    	  
      }
          
	  public boolean create(Produit obj) {
		  try 
		    {
			  java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
			 
			  String currentTime = sdf.format(obj.getDateAchat());
		      this.connect.getConn().createStatement().executeUpdate("INSERT INTO Produit(`id_fournisseur`,`nom`,`date_achat`,`prix_achat`,`quantite`,`reste`,`prix_vente`,`description`)"
		      		+ "values("+obj.getFournisseur().getIdFournisseur()+",'"+obj.getNom()+"','"+currentTime+"' ,"
		      				+obj.getPrixAchat()+","+obj.getQuantite()+","+obj.getQuantite()+","+obj.getPrixVente()+",'"+obj.getDescription()+"');");
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }
	    return true;
	  }

	  public boolean update(Produit obj) {
		  try 
		    {
			  java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

			  String currentTime = sdf.format(obj.getDateAchat());
			  System.out.println(currentTime);
		      int tjriba=this.connect.getConn().createStatement().executeUpdate("UPDATE PRODUIT set id_fournisseur="+obj.getFournisseur().getIdFournisseur()+","
		      		+ " nom='"+obj.getNom()+"', date_achat='"+currentTime+"', prix_achat="+obj.getPrixAchat()+","
		      				+ " quantite="+obj.getQuantiteInitiale()+", reste="+obj.getQuantite()+", prix_vente="+obj.getPrixVente()+" "
		      						+ ",description='"+obj.getDescription()+"' WHERE id_produit="+obj.getId()+";"
		      		);
		      System.out.println(tjriba);
		    } catch (SQLException e) {
		    	System.out.println("laaah");
		      e.printStackTrace();
		      return false;
		    }
	    return true;
	  }

	  public boolean delete(Produit obj) {
		  try 
		    {
			  //done
		      this.connect.getConn().createStatement().executeUpdate("DELETE FROM Produit WHERE id_produit="+ obj.getId() +";");
		    } catch (SQLException e) {
		      e.printStackTrace();
		      return false;
		    }
	    return true;
	  }
	   
	  public Produit find(int id) {
		  Produit produit=null; 
	      FournisseurDAO fournisseurDAO=new FournisseurDAO();
	    try 
	    {
	      
	      ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM Produit WHERE id_produit="+ id +";");
	      if(result.first())
	      {
	    	 //result.getMetaData().getColumnCount();
	    	 produit=new Produit(
	    			 id,
	    			 fournisseurDAO.find(result.getInt(2)),
	    			 result.getString(3),
	    			 result.getDate(4),
	    			 result.getDouble(5),
	    			 result.getInt(6),
	    			 result.getInt(7),
	    			 result.getDouble(8),
	    			 result.getString(9)
	    			 );
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return produit;
	  }

}
