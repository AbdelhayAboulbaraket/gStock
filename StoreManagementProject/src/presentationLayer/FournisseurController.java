package presentationLayer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLayer.Fournisseur;
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
import persistenceLayer.FournisseurDAO;

public class FournisseurController implements Initializable {
	
	@FXML
    private Button vente_btn;
    @FXML
    private Button inventaire_btn;
    
    @FXML
    private Button supprimer_btn;
    
    @FXML
    private Button rechercher_btn;
    
    @FXML
    private Button employer_btn;
    
    @FXML
    private Button client_btn;
    
    @FXML
    private Button ajouter_btn;
    
    @FXML
    private Button fournisseur_btn;
    
    @FXML
    private Button modifier_btn;
    
    @FXML
    private TextField rechercherField;
    
    @FXML
    private TableColumn<Fournisseur,Integer> Id;
    
    @FXML
    private TableColumn<Fournisseur,String> Nom;
    
    @FXML
    private TableColumn<Fournisseur,String> Tel;
    
    @FXML
    private TableColumn<Fournisseur,String> Email;
    
    @FXML
    private TableColumn<Fournisseur,String> Adresse;
    
    @FXML
    private TableView<Fournisseur> table;
   
    public TableView<Fournisseur> getTable()
    {
    	return table;
    }
    
    

    private ObservableList<Fournisseur> fournisseurs;
    
    @FXML
	void show_ventes() throws IOException
	{	
		Parent root = FXMLLoader.load(getClass().getResource("vente.fxml"));
    	fournisseur_btn.getScene().setRoot(root);
	}
    
    @FXML
    void show_inventaire() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
    	inventaire_btn.getScene().setRoot(root);

    }
	
    @FXML
    void show_employer() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
    	inventaire_btn.getScene().setRoot(root);
    }

    @FXML
    void show_client() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
    	inventaire_btn.getScene().setRoot(root);
    }

    
    @FXML
    void ajouter() throws IOException {

    
	     Stage stage = new Stage();
	     Parent root = FXMLLoader.load(AjouterFournisseurController.class.getResource("ajouterFournisseur.fxml"));
	     stage.setScene(new Scene(root));
    	 stage.setTitle("Ajouter Fournisseur");
    	 stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(inventaire_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();
    }

    
    @FXML
    void modifier() throws IOException {
    	
    	 Stage stage = new Stage();
    	 
    	 FXMLLoader loader=new FXMLLoader(getClass().getResource("modifierFournisseur.fxml"));
	     Parent root = (Parent) loader.load();
	     ModifierFournisseurController s=loader.getController();
    	 s.setFournisseuraModifier(this.table.getSelectionModel().getSelectedItem());
	     stage.setScene(new Scene(root));	     
    	 stage.setTitle("Modifier Fournisseur");
    	 stage.initModality(Modality.WINDOW_MODAL);
	     stage.initOwner(inventaire_btn.getScene().getWindow());
	     stage.setResizable(false);
	     stage.show();

    }
    
    @FXML
    void supprimer() throws IOException {
    	Fournisseur fournisseur=table.getSelectionModel().getSelectedItem();
    	FournisseurDAO delete = new FournisseurDAO();
    	delete.delete(fournisseur);
    	Stage stage= (Stage)supprimer_btn.getScene().getWindow();
    	Parent root = FXMLLoader.load(UserController.class.getResource("fournisseur.fxml"));
    	stage.setScene(new Scene(root));
    	
    }
    
    @FXML
    void rechercher() throws IOException {
    	
    	String text=rechercherField.getText();
    	FournisseurDAO recherche = new FournisseurDAO();
    	if(text.length()!=0)
    	{
        Fournisseur fournisseur;
    	fournisseur=recherche.find(text);
    	fournisseurs.clear();
    	fournisseurs.add(fournisseur);
    	}
    	else
    	{
    		fournisseurs=recherche.selectAll();
    	}
    	table.setItems(fournisseurs);
    	
    }
    

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		FournisseurDAO data=new FournisseurDAO();
		fournisseurs=data.selectAll();
		
		this.Id.setCellValueFactory(new PropertyValueFactory<>("IdFournisseur"));
		this.Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		this.Tel.setCellValueFactory(new PropertyValueFactory<>("Numero"));
		this.Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
		this.Adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
		
		this.table.setItems(fournisseurs);
	}

}
