package persistenceLayer;

import dataBaseLayer.DBConnect;
import javafx.collections.ObservableList;


public abstract class DAO<T> {

	  DBConnect connect=null;
	   
	  public DAO(){
	    this.connect =DBConnect.getInstance();
	  }
	   
	  /**
	  * M�thode de cr�ation
	  * @param obj
	  * @return boolean 
	  */
	  public abstract ObservableList<T> selectAll();
	  public abstract boolean create(T obj);

	  /**
	  * M�thode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	  public abstract boolean delete(T obj);

	  /**
	  * M�thode de mise � jour
	  * @param obj
	  * @return boolean
	  */
	  public abstract boolean update(T obj);

	  /**
	  * M�thode de recherche des informations
	  * @param id
	  * @return T
	  */
	  public abstract T find(int id);
	
}
