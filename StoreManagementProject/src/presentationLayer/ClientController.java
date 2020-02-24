package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLayer.Client;
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
import persistenceLayer.ClientDAO;
import persistenceLayer.ProduitDAO;

public class ClientController implements Initializable {
		
		@FXML
		private Button vente_btn;

	   @FXML
	    private Button modifierBoutton;

	    @FXML
	    private Button fournisseur_btn;

	    @FXML
	    private Button inventaire_btn;

	    @FXML
	    private TextField chercherField;

	    @FXML
	    private TableColumn<Client,String> adresse;

	    @FXML
	    private Button chercherBoutton;

	    @FXML
	    private TableColumn<Client,String> tel;

	    @FXML
	    private Button ajouter_btn;

	    @FXML
	    private TableColumn<Client, Integer> id;

	    @FXML
	    private TableColumn<Client,String> nom;

	    @FXML
	    private TableColumn<Client,String> email;

	    @FXML
	    private Button employer_btn;
	    
	    ObservableList<Client> clients;
	    
	    @FXML
	    private TableView<Client> tbData;



	    @FXML
	    void chercherClient() throws IOException
	    {
	    	ClientDAO clientDAO=new ClientDAO();	
	    	if(chercherField.getText().isEmpty())
	    	{	clients=clientDAO.selectAll();
	    		tbData.setItems(clients);
	    	}
	    	else
	    	{
	    		clients.clear();
	    		clients.add(clientDAO.find(chercherField.getText()));
	    		tbData.setItems(clients);
	    	}
	    }
	  



	    @FXML
	    void supprimerClient() throws IOException
	    {
	    	ClientDAO clientDAO=new ClientDAO();
	    	Client client=tbData.getSelectionModel().getSelectedItem();
	    	//System.out.println("oui");
	    	//System.out.println(prod.getId()+" "+prod.getNom()+" "+ prod.getPrixAchat()+ " "+prod.getPrixVente()+ " "+ prod.getDescription());
	    	clientDAO.delete(client);
	    	Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
	    	fournisseur_btn.getScene().setRoot(root);
	    }

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
	    void show_employer() throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
	    	fournisseur_btn.getScene().setRoot(root);

	    }
	    
	    @FXML
	    void ajouterClient() throws IOException {

	    
		     Stage stage = new Stage();
		     Parent root = FXMLLoader.load(
		     UserController.class.getResource("ajouterClient.fxml"));
		     stage.setScene(new Scene(root));
	    	 stage.setTitle("Ajouter Client");
	    	 stage.initModality(Modality.WINDOW_MODAL);
		     stage.initOwner(fournisseur_btn.getScene().getWindow());
		     stage.setResizable(false);
		     stage.show();
	    }

	    
	    @FXML
	    void modifierClient() throws IOException {
	    	
	    	Stage stage = new Stage();
	    	 
	    	 FXMLLoader loader=new FXMLLoader(getClass().getResource("modifierClient.fxml"));
		     Parent root = (Parent) loader.load();
		     ModifierClientController s=loader.getController();
		     s.setClient(this.tbData.getSelectionModel().getSelectedItem());
		     stage.setScene(new Scene(root));
	    	 stage.setTitle("Modifier Client");
	    	 stage.initModality(Modality.WINDOW_MODAL);
		     stage.initOwner(fournisseur_btn.getScene().getWindow());
		     stage.setResizable(false);
		     stage.show();

	    }
	    

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			ClientDAO clientDAO=new ClientDAO();
			clients=clientDAO.selectAll();
			this.id.setCellValueFactory(new PropertyValueFactory<>("Id"));
			this.nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
			this.tel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
			this.email.setCellValueFactory(new PropertyValueFactory<>("Email"));
			this.adresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
			
			tbData.setItems(clients);
		}

}
