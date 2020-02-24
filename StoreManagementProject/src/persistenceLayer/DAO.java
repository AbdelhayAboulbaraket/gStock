package persistenceLayer;

import dataBaseLayer.DBConnect;
import javafx.collections.ObservableList;


public abstract class DAO<T> {

	  DBConnect connect=null;
	   
	  public DAO(){
	    this.connect =DBConnect.getInstance();
	  }
	   
	  /**
	  * Méthode de création
	  * @param obj
	  * @return boolean 
	  */
	  public abstract ObservableList<T> selectAll();
	  public abstract boolean create(T obj);

	  /**
	  * Méthode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	  public abstract boolean delete(T obj);

	  /**
	  * Méthode de mise à jour
	  * @param obj
	  * @return boolean
	  */
	  public abstract boolean update(T obj);

	  /**
	  * Méthode de recherche des informations
	  * @param id
	  * @return T
	  */
	  public abstract T find(int id);
	
}
