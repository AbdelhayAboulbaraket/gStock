package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import businessLayer.Fournisseur;
import businessLayer.*;
import javafx.collections.FXCollections;
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

public class AjouterVenteController implements Initializable {
	
	@FXML
    private Button retour_btn;

    @FXML
    private TableColumn<Vente,String> clientColumn;

    @FXML
    private TableColumn<Vente,Double> totalColumn;

    @FXML
    private TableColumn<Vente,Integer> quantiteColumn;

    @FXML
    private Label enStockLabel;

    @FXML
    private TableColumn<Vente,Double> prixUnitaireColumn;

    @FXML
    private TableView<Vente> tbData;

    @FXML
    private TableColumn<Vente,String> produitColumn;

    @FXML
    private Button vendre_btn;

    @FXML
    private Button supprimer_btn;

    @FXML
    private ChoiceBox<String> produit;

    @FXML
    private ChoiceBox<String> client;

    @FXML
    private TextField qteField;

    @FXML
    private Button ajouter_btn;

    @FXML
    private Button addProduit;

    @FXML
    private Button AddClient;

	private ObservableList<Vente> ventes=FXCollections.observableArrayList();

    
    
    
    @FXML
    void ajouter() throws IOException
    { 	VenteDAO venteDAO=new VenteDAO();
    	ventes.forEach((vente)->
    	{
    		venteDAO.create(vente);
    	});
    	Stage stage=(Stage) retour_btn.getScene().getWindow();
    	Stage owner = (Stage) stage.getOwner();
    	Parent root = FXMLLoader.load(getClass().getResource("vente.fxml"));
    	owner.getScene().setRoot(root);
    	stage.close();
    }
    @FXML
    public void ajouterProduit() throws IOException
    {
    	Stage stage = new Stage();
	     Parent root = FXMLLoader.load(UserController.class.getResource("ajouterProduitVente.fxml"));
	     stage.setScene(new Scene(root));
	     stage.setTitle("Ajouter Produit");
   	 	 stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(this.ajouter_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();
    }

    @FXML
    public void ajouterClient() throws IOException
    {
    	Stage stage = new Stage();
	     Parent root = FXMLLoader.load(
	     UserController.class.getResource("ajouterClientVente.fxml"));
	     stage.setScene(new Scene(root));
	     stage.setTitle("Ajouter Client");
	     stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(this.ajouter_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();
    }
    
    @FXML
    void supprimerVente() throws IOException
    {	System.out.println("haha");
    	ventes.remove(tbData.getSelectionModel().getSelectedItem());
    	tbData.setItems(ventes);
    }
    
    @FXML
    void ajouterPanier() throws IOException
    {
    	
    	ClientDAO clientDAO = new ClientDAO();
    	Client cl=clientDAO.find(client.getSelectionModel().getSelectedItem());
    	System.out.println(cl.getNom());
    	ProduitDAO prodDAO=new ProduitDAO();
    	Produit prod=prodDAO.find(produit.getSelectionModel().getSelectedItem());
    	System.out.println(prod.getNom());
    	int q=Integer.valueOf(qteField.getText());
    	
    	Vente v=new Vente(prod,cl,q,new Date());
    	
    	System.out.println(v.getClientNom()+"  "+v.getProduitNom()+"  "+v.getQuantite()+"  "+v.getTotal());
    	
    	ventes.add(v);

    	this.produitColumn.setCellValueFactory(new PropertyValueFactory<>("ProduitNom"));
		this.prixUnitaireColumn.setCellValueFactory(new PropertyValueFactory<>("ProduitPrixVente"));
		this.clientColumn.setCellValueFactory(new PropertyValueFactory<>("ClientNom"));
		this.quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
		this.totalColumn.setCellValueFactory(new PropertyValueFactory<>("Total"));
		this.tbData.setItems(ventes);
    }
    
	
	 @FXML
	    void retourner() throws IOException {
	    	
	    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
	    	 stage.close();
	    }
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ProduitDAO prodDAO=new ProduitDAO();
		ObservableList<String> produits;
		produits=prodDAO.selectAllNames();
		produit.setItems(produits);
		ClientDAO clientDAO=new ClientDAO();
		ObservableList<String> clients;
		clients=clientDAO.selectAllNames();
		client.setItems(clients);

		
	}

}
