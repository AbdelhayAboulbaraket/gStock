package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import businessLayer.*;
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

public class venteController implements Initializable{
	
    @FXML
    private Button ajouter_btn;

    @FXML
    private Button supprimer_btn;


    @FXML
    private Button inventaire_btn;

    @FXML
    private Button vente_btn;

    @FXML
    private Button fournisseur_btn;

    @FXML
    private Button employer_btn;

    @FXML
    private Button client_btn;

    @FXML
    private TextField rechercherField;

    @FXML
    private Button rechercher_btn;

    @FXML
    private TableView<Vente> table;

    @FXML
    private TableColumn<Vente, Integer> id;

    @FXML
    private TableColumn<Vente, Produit> produit;

    @FXML
    private TableColumn<Vente, Client> client;

    @FXML
    private TableColumn<Vente, Integer> quantite;

    @FXML
    private TableColumn<Vente, Date> date_vente;

    @FXML
    private TableColumn<Vente,Integer> total;

    ObservableList<Vente> ventes=null;
    
    @FXML
    void supprimerVente() throws IOException
    {
    	Vente vente=table.getSelectionModel().getSelectedItem();
    	VenteDAO venteDAO = new VenteDAO();
    	venteDAO.delete(vente);
    	Stage stage= (Stage)supprimer_btn.getScene().getWindow();
    	Parent root = FXMLLoader.load(UserController.class.getResource("vente.fxml"));
    	stage.setScene(new Scene(root));
    	
    }
    
    @FXML
   	void show_ventes() throws IOException
   	{	
   		Parent root = FXMLLoader.load(getClass().getResource("vente.fxml"));
       	fournisseur_btn.getScene().setRoot(root);
   	}

    @FXML
    void show_fournisseur() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("fournisseur.fxml"));
    	fournisseur_btn.getScene().setRoot(root);
    }

    @FXML
    void show_employer() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
    	fournisseur_btn.getScene().setRoot(root);
    }
    
    @FXML
    void show_inventaire() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
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
	     AjouterVenteController.class.getResource("ajouterVente.fxml"));
	     stage.setScene(new Scene(root));
    	 stage.setTitle("Ajouter Vente");
    	 stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(fournisseur_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();


    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		VenteDAO data=new VenteDAO();
		ventes=data.selectAll();
		
		this.id.setCellValueFactory(new PropertyValueFactory<>("IdVente"));
		this.produit.setCellValueFactory(new PropertyValueFactory<>("ProduitNom"));
		this.client.setCellValueFactory(new PropertyValueFactory<>("ClientNom"));
		this.quantite.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
		this.date_vente.setCellValueFactory(new PropertyValueFactory<>("DateVente"));
		this.total.setCellValueFactory(new PropertyValueFactory<>("Total"));
		
		this.table.setItems(ventes);
		
	}

}
