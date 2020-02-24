package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLayer.Fournisseur;
import businessLayer.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import persistenceLayer.*;

public class UserController implements Initializable {
	@FXML
    private Button vente_btn;
	@FXML
    private Button inventaire_btn;

    @FXML
    private Button fournisseur_btn;

    @FXML
    private Button client_btn;

    @FXML
    private TextField rechercherField;

    @FXML
    private Button rechercher_btn;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, Integer> id;

    @FXML
    private TableColumn<User, String> nom;

    @FXML
    private TableColumn<User, String> prenom;

    @FXML
    private TableColumn<User, String> mdp;

    @FXML
    private Button ajouter_btn;

    @FXML
    private Button modifier_btn;

    @FXML
    private Button supprimer_btn;
    
    
    ObservableList<User> users=null;
    
    	@FXML
    	void show_ventes() throws IOException
    	{	
    		Parent root = FXMLLoader.load(getClass().getResource("vente.fxml"));
	    	fournisseur_btn.getScene().setRoot(root);
    	}
	    
	    @FXML
	    void show_inventaire() throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
	    	fournisseur_btn.getScene().setRoot(root);

	    }

	    @FXML
	    void show_fournisseur() throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("fournisseur.fxml"));
	    	fournisseur_btn.getScene().setRoot(root);
	    }

	    @FXML
	    void show_client() throws IOException {
	    
	    	Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
	    	fournisseur_btn.getScene().setRoot(root);

	    }
	    
	    @FXML
	    void ajouter() throws IOException {

	    
		     Stage stage = new Stage();
		     Parent root = FXMLLoader.load(
		     UserController.class.getResource("ajouterUser.fxml"));
		     stage.setScene(new Scene(root));
	    	 stage.setTitle("Ajouter User");
	    	 stage.initModality(Modality.WINDOW_MODAL);
		     stage.initOwner(fournisseur_btn.getScene().getWindow());
		     stage.setResizable(false);
		     stage.show();
	    }

	    
	    @FXML
	    void modifier() throws IOException {
	    	
	    	 Stage stage = new Stage();
		     Parent root = FXMLLoader.load(
		     UserController.class.getResource("modifierUser.fxml"));
		     stage.setScene(new Scene(root));
	    	 stage.setTitle("Modifier User");
	    	 stage.initModality(Modality.WINDOW_MODAL);
		     stage.initOwner(fournisseur_btn.getScene().getWindow());
		     stage.setResizable(false);
		     stage.show();

	    }
	    
	    
	    @FXML
	    void rechercher() throws IOException {
	    	
	    	String text=rechercherField.getText();
	    	UserDAO recherche = new UserDAO();
	    	if(text.length()!=0)
	    	{
	        User user;
	    	user=recherche.search(text);
	    	users.clear();
	    	users.add(user);
	    	}
	    	else
	    	{
	    		users=recherche.selectAll();
	    	}
	    	table.setItems(users);
	    	
	    }
	    
	    @FXML
	    void supprimer() throws IOException {
	    	User user=table.getSelectionModel().getSelectedItem();
	    	UserDAO delete = new UserDAO();
	    	delete.delete(user);
	    	Stage stage= (Stage)supprimer_btn.getScene().getWindow();
	    	Parent root = FXMLLoader.load(UserController.class.getResource("user.fxml"));
	    	stage.setScene(new Scene(root));
	    	
	    }
	    
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		UserDAO data=new UserDAO();
		users=data.selectAll();
		
		this.id.setCellValueFactory(new PropertyValueFactory<>("IdUser"));
		this.nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		this.prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
		this.mdp.setCellValueFactory(new PropertyValueFactory<>("MotDePasse"));
		
		
		this.table.setItems(users);
		
		
	}

}
