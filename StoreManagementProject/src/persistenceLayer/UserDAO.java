package persistenceLayer;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import businessLayer.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO extends DAO<User> {
	
	public UserDAO() {
		super();
	}
	
	public ObservableList<User> selectAll()
	{   
		ObservableList<User> users=FXCollections.observableArrayList();
		try
		{
			ResultSet result=this.connect.getConn().createStatement().executeQuery("select * from User");
			while(result.next())
			{
				User user=new User(result.getString(1),result.getString(2),result.getString(3),result.getString(4));
				users.add(user);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return users;
	}
    public boolean create(User obj)
    {
    	String id=obj.getIdUser();
		String nomm=obj.getNom();
		String prenomm=obj.getPrenom();
		String mdpp=obj.getMotDePasse();
		
		
		try {
			Statement p = this.connect.getConn().createStatement();
			 p.executeUpdate("insert into User(id_user,nom,prenom,mdp) values('"+id+"','"+nomm+"','"+prenomm+"','"+mdpp+"');");
	         
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
    }
	
	
		
		public boolean delete(User user) {
			String idd=user.getIdUser();
			String sql= "DELETE FROM User WHERE id_user='"+idd+"';";
			try {
				Statement p = this.connect.getConn().createStatement();
	            p.executeUpdate(sql);

			} catch (Exception e) {
				e.fillInStackTrace();
				return false;
			}
			
			return true;
		}
			public boolean update(User user) {
				//String idd=user.getIdUser();
				try {
					 String sql = "update user set nom = '"+user.getNom()+"' , prenom = '"+user.getPrenom()+"', mdp = '"+user.getMotDePasse()+"' where id_user = '"+user.getIdUser()+"';";
				     Statement p = this.connect.getConn().createStatement();
				     p.executeUpdate(sql);
				     
				} catch (Exception e) {
					e.fillInStackTrace();
					return false;
				}
				return true;
			}
			
			
			public User search(String nom)
			{
				User user = new User();            
			    try {
			    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM User WHERE nom='"+ nom +"';");
			      if(result.first()){
			      user = new User(result.getString("id_user"),nom , result.getString("prenom"), result.getString("mdp"));
			       
			      }
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
				return user;
			}

			public User find(String id) {
				    User user = new User();            
				    try {
				    	 ResultSet result=this.connect.getConn().createStatement().executeQuery("Select * FROM User WHERE id_User='"+ id +"';");
				      if(result.first()){
				      user = new User(id, result.getString("nom"), result.getString("prenom"), result.getString("mdp"));
				       
				      }
				    } catch (SQLException e) {
				      e.printStackTrace();
				    }
				    return user;
				  }
			public User find(int id)
			{
				return null;
			}
			
			public int UserCount()
			{
				int count=0;
				try {
					ResultSet result=this.connect.getConn().createStatement().executeQuery("Select COUNT(*) from user;");
					if(result.first()){
						count=result.getInt(1);
					}
					
				}catch(SQLException e) {
				      e.printStackTrace();
				    }
				
				return count;
			}
			
	
	}
		


