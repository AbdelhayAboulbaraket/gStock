package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import businessLayer.Produit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import persistenceLayer.DAO;
import persistenceLayer.ProduitDAO;

public class ProduitController implements Initializable{
	@FXML
    private Button vente_btn;
    @FXML	
    private Button search;

    @FXML
    private Button fournisseur_btn;
    
    @FXML
    private Button employer_btn;
    
    @FXML
    private Button Ajouter_btn;

    @FXML
    private Button modifier_btn;
    
    @FXML
    private Button client_btn;
    
    @FXML
    public TableColumn<Produit, Integer> idProduit;

    @FXML
    public TableColumn<Produit, String> nom;
    
    @FXML
    public TableColumn<Produit, Integer> reste;

    @FXML
    public TableColumn<Produit, String> fournisseur;
    
    @FXML
    public TableColumn<Produit, Integer> quantite;
    
    @FXML
    public TableColumn<Produit, Double> prixAchat;
    
    @FXML
    public TableColumn<Produit, Date> dateAchat;
    
    @FXML
    public TableColumn<Produit, String> description;
    
    @FXML
    public TableColumn<Produit, String> prixVente;
    
    @FXML
    private Button chercherBoutton;
    @FXML
    private TextField chercherField;
    
    @FXML
	void show_ventes() throws IOException
	{	
		Parent root = FXMLLoader.load(getClass().getResource("vente.fxml"));
    	fournisseur_btn.getScene().setRoot(root);
	}
    
    @FXML
    void chercherProduit() throws IOException
    {
    	ProduitDAO prodDAO=new ProduitDAO();
    	System.out.println("salaaam");
    	
    	if(chercherField.getText().isEmpty())
    	{	produits=prodDAO.selectAll();
    		tbData.setItems(produits);
    	}
    	else
    	{
    		produits.clear();
    		produits.add(prodDAO.find(chercherField.getText()));
    		//Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
        	//fournisseur_btn.getScene().setRoot(root);
    		tbData.setItems(produits);
    	}
    	

    }


    @FXML
    private Button supprimerBoutton;
    @FXML
    void supprimerProduit() throws IOException
    {
    	
    	ProduitDAO prodDAO=new ProduitDAO();
    	Produit prod=tbData.getSelectionModel().getSelectedItem();
    	//System.out.println("oui");
    	//System.out.println(prod.getId()+" "+prod.getNom()+" "+ prod.getPrixAchat()+ " "+prod.getPrixVente()+ " "+ prod.getDescription());
    	prodDAO.delete(prod);
    	Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
    	fournisseur_btn.getScene().setRoot(root);
    	
    	
    }
    
    @FXML
    private TableView<Produit> tbData;
    
    
    private ObservableList<Produit> produits ;

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
    void show_client() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
    	fournisseur_btn.getScene().setRoot(root);
    }
    
    
    @FXML
    void modifier() throws IOException {
    	
    	 Stage stage = new Stage();
    	 FXMLLoader loader=new FXMLLoader(getClass().getResource("modifierProduit.fxml"));
	     Parent root = loader.load();
	     
	     ModifierProduitController s=loader.getController();
	     s.setProduitaModifier(this.tbData.getSelectionModel().getSelectedItem());
	     
	     stage.setScene(new Scene(root));
    	 stage.setTitle("Modifier Produit");
    	 stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(fournisseur_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();

    }
    
    @FXML
    void ajouter() throws IOException {
    	
    	 Stage stage = new Stage();
	     Parent root = FXMLLoader.load(UserController.class.getResource("ajouterProduit.fxml"));
	     stage.setScene(new Scene(root));
    	 stage.setTitle("Ajouter Produit");
    	 stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(fournisseur_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();

    }

   
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DAO<Produit> prodDao=new ProduitDAO();
	    produits=prodDao.selectAll();
		
		this.idProduit.setCellValueFactory(new PropertyValueFactory<>("Id")); //produit.getId();
		this.fournisseur.setCellValueFactory(new PropertyValueFactory<>("FournisseurNom")); //produit.getFournisseur().getName();
		this.nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		this.dateAchat.setCellValueFactory(new PropertyValueFactory<>("DateAchat"));
		this.prixAchat.setCellValueFactory(new PropertyValueFactory<>("PrixAchat"));
		this.quantite.setCellValueFactory(new PropertyValueFactory<>("QuantiteInitiale"));
		this.prixVente.setCellValueFactory(new PropertyValueFactory<>("PrixVente"));
		this.description.setCellValueFactory(new PropertyValueFactory<>("Description"));
		this.reste.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
		this.tbData.setItems(produits);
	}

}
