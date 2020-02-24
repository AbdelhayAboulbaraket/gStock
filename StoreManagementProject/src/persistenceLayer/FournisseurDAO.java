package persistenceLayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import businessLayer.Fournisseur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FournisseurDAO extends DAO<Fournisseur> {
		
	public FournisseurDAO()
	{
		super();
	}
	
	public boolean create(Fournisseur obj) 
	{
		try {
			Statement req= this.connect.getConn().createStatement();
			String sql="Insert into fournisseur(nom,tel,adresse,email) values('"+obj.getNom()+"','"+obj.getNumero()+"','"+obj.getAdresse()+"','"+obj.getEmail()+"');";
				req.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		 
		return true;
	}

	 
	  public boolean delete(Fournisseur obj)
	  {
		  try {
			Statement req=this.connect.getConn().createStatement();
			String sql="Delete from fournisseur where id_fournisseur="+obj.getIdFournisseur()+";";
			req.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		  return true;
	  }

	
	  public boolean update(Fournisseur obj)
	  {

		try {
			Statement req = this.connect.getConn().createStatement();
			 String sql="update fournisseur set nom='"+obj.getNom()+"', tel='"+obj.getNumero()+"', adresse='"+obj.getAdresse()+"', email='"+obj.getEmail()+"' where id_fournisseur="+obj.getIdFournisseur()+";";
			  req.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
		  
		  return true;
	  }

	  
	  public Fournisseur find(int id) 
	  {
		  Fournisseur fournisseur=null;
		  try {
			  Statement req=this.connect.getConn().createStatement();
			  String sql="Select * from fournisseur where id_fournisseur="+id+";";
			  ResultSet result=req.executeQuery(sql);
			  if(result.first())
			  {
				  fournisseur=new Fournisseur(
						  result.getInt(1),
						  result.getString(2),
						  result.getString(3),
						  result.getString(4),
						  result.getString(5)
						  );
			  }
			  
			 
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return fournisseur;
		  
	  }
	  
	  public Fournisseur find(String nom) 
	  {
		  Fournisseur fournisseur=null;
		  
		  try {
			  Statement req=this.connect.getConn().createStatement();
			  String sql="Select * from fournisseur where nom='"+nom+"';";
			  ResultSet result=req.executeQuery(sql);
			  if(result.next())
			  {
				  fournisseur=new Fournisseur(
						  result.getInt(1),
						  result.getString(2),
						  result.getString(3),
						  result.getString(4),
						  result.getString(5)
						  );
				  
			  }
			  
			 
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return fournisseur;
		  
	  }
	  
	  public ObservableList<Fournisseur> selectAll()
	  {
		  ObservableList<Fournisseur> fournisseurs=FXCollections.observableArrayList();
		  try {
			  
			  Statement req =this.connect.getConn().createStatement();
			  String sql="Select * from fournisseur;";
			  ResultSet result=req.executeQuery(sql);
			  while(result.next())
			  {
				  Fournisseur fournisseur=new Fournisseur(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
				  fournisseurs.add(fournisseur);
			  }
			  
			  
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  
		  
		  return fournisseurs;
		  
	  }
	  
	  public ObservableList<String> selectAllNames()
	  {
		  ObservableList<String> fournisseurs=FXCollections.observableArrayList();
		  try {
			  
			  Statement req =this.connect.getConn().createStatement();
			  String sql="Select nom from fournisseur;";
			  ResultSet result=req.executeQuery(sql);
			  while(result.next())
			  {
				  String fournisseur=result.getString(1);
				  fournisseurs.add(fournisseur);
			  }
			  
			  
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  
		  
		  return fournisseurs;
		  
	  }
	  
	  
	  
	  
	
	
}
