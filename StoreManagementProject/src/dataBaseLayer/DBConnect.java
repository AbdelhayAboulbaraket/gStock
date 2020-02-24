package dataBaseLayer;

import java.sql.*;

public class DBConnect {
	private static DBConnect instance=null;
	Connection conn=null;
	
	public Connection getConn() 
	{
		return conn;
	}

	public void setConn(Connection conn) 
	{
		this.conn = conn;
	}

	 private DBConnect()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (Exception ex)
		//catch (ClassNotFoundException ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
		
		try 
		{
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306?allowMultiQueries=true","root","Rabiezaml.123");
			System.out.println("khdam2");
			Statement req = conn.createStatement();
			String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema='projet_java'";
			ResultSet rs = req.executeQuery(query);                  
			rs.next();
			boolean exists = rs.getInt("COUNT(*)") > 0;
			if(!exists) 
			{
				String sql="create database projet_java;" + 
						"use projet_java;" + 
						"create table fournisseur( id_fournisseur int(10) AUTO_INCREMENT, nom  varchar(30), tel varchar(10), adresse varchar(100), email varchar(100), primary key(id_fournisseur));" + 
						"create table produit( id_produit int(10) AUTO_INCREMENT, id_fournisseur int(10), nom  varchar(30), date_achat date, prix_achat float, quantite int(10), reste int(10), prix_vente float, description varchar(200), primary key(id_produit), foreign key(id_fournisseur) references fournisseur(id_fournisseur) );" +
						"create table client( id_client int(10) AUTO_INCREMENT, nom varchar(30), tel int(10), adresse varchar(100), email varchar(100), primary key(id_client));" +
						"create table vente( id_vente int(10) AUTO_INCREMENT, id_produit int(10),id_client int(10), quantite int(10), date_vente date,total float, primary key(id_vente),foreign key(id_client) references client(id_client), foreign key(id_produit) references produit(id_produit));" + 
						"create table user( id_user varchar(30), nom varchar(30), prenom varchar(30), mdp varchar(100), primary key(id_user));";
				req.executeUpdate(sql);
				
				
			}
			else
			{
				String sql="use projet_java;";
				req.executeUpdate(sql);
			}
				
			
			
		}
		
		catch(SQLException ex)
		{
			System.out.println("SQLException : "+ ex.getMessage());
			System.out.println("SQLState : "+ ex.getSQLState());
			System.out.println("VendorError : "+ ex.getErrorCode());
			
		}
	}
	
	public static DBConnect getInstance()
	{
		if(instance == null)
		{
			instance= new DBConnect();
		}
		
		return instance;
	}

}
