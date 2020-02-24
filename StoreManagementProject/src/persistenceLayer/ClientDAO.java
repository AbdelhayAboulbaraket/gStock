package persistenceLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import businessLayer.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClientDAO extends DAO<Client> {
	

	public ClientDAO() {
		super();
	}
	
	public Client find(String s )
	{
		Client client=null;         
	    try {
	    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM Client WHERE nom='"+s+"';");
	      if(result.first()){
	      client = new Client (result.getInt(1), result.getString("nom"), result.getString("email"),result.getString("tel"),result.getString("adresse"));
	       
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return client;
	  }
		
	
	public ObservableList<Client> selectAll()
	{
		ObservableList<Client> clients=FXCollections.observableArrayList();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("select * from Client");
			while(result.next())
			{
				Client client=new Client(result.getInt("id_client"),result.getString("nom"),result.getString("email"),result.getString("tel"),result.getString("adresse"));
				clients.add(client);
			}
			
		}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		return clients;
	}

	@Override
	public boolean create(Client client) {
		 //int id1=client.getId();
		 String nom1=client.getNom();
		 String email1=client.getEmail();
		 String adresse1=client.getAdresse();
		 String tel=client.getTel();
			try {
				 this.connect.getConn().createStatement().executeUpdate("insert into Client(tel,nom,email,adresse) values("+tel+",'"+nom1+"','"+email1+"','"+adresse1+"');");
		         return true;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public boolean delete(Client client) {
		int id2=client.getId();
		String sql= "DELETE FROM Client WHERE id_client="+id2+" ";
		try {
			PreparedStatement p = this.connect.getConn().prepareStatement(sql);
            p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Client obj) {
		//int id3=obj.getId();
		try {
			 String query = "update client set nom = '"+obj.getNom()+"' , email = '"+obj.getEmail()+"', tel='"+obj.getTel()+
					 "' , adresse='"+obj.getAdresse()+"'where id_client = '"+obj.getId()+"';";
		     PreparedStatement preparedStmt = this.connect.getConn().prepareStatement(query);
		     preparedStmt.executeUpdate();
		     return true;
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return false;
	}

	@Override
	public Client find(int id) {
	    Client client=null;         
	    try {
	    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM Client WHERE id_Client="+ id +";");
	      if(result.first()){
	      client = new Client (id, result.getString("nom"), result.getString("email"),result.getString("tel"),result.getString("adresse"));
	       
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return client;
	  }
	
	
	public ObservableList<String> selectAllNames()
	  {
		  ObservableList<String> clients=FXCollections.observableArrayList();
		  try {
			  
			  Statement req =this.connect.getConn().createStatement();
			  String sql="Select nom from client;";
			  ResultSet result=req.executeQuery(sql);
			  while(result.next())
			  {
				  String client=result.getString(1);
				  clients.add(client);
			  }
			  
			  
		  }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  
		  
		  return clients;
		  
	  }
	
	
	
	
	
	
}
