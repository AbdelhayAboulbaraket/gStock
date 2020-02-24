package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import businessLayer.Fournisseur;
import businessLayer.Produit;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistenceLayer.FournisseurDAO;
import persistenceLayer.ProduitDAO;


public class AjouterProduitController implements Initializable {
	
	   @FXML
	    private Button retour_btn;

	    

	    @FXML
	    private TextField prixAchatField;

	    @FXML
	    private TextField quantiteField;

	    @FXML
	    private Button valider_btn;


	    @FXML
	    private ChoiceBox<String> fournisseurChoix;

	    @FXML
	    private TextField descriptionField;

	    @FXML
	    private TextField prixVenteField;

	    @FXML
	    private TextField nomField;
	    @FXML
	    private TextField idField;
	    
	    ObservableList<String> fournisseurs;

	    @FXML
	    void ajouterProduit() throws IOException
	    {
	    	ProduitDAO prodDAO=new ProduitDAO();
	    	FournisseurDAO fourDAO=new FournisseurDAO();
	    	//System.out.println(fournisseurChoix.getSelectionModel().getSelectedItem());
	    	Fournisseur fourn=fourDAO.find(fournisseurChoix.getSelectionModel().getSelectedItem());
	    	//System.out.println(nomField.getText());
	    	//System.out.println(fourn.getIdFournisseur()+fourn.getNom()+fourn.getEmail()+fourn.getAdresse()+fourn.getNumero());
	    	
	      
	    	
	    	Produit prod=new Produit(fourn,nomField.getText(),new Date(),Double.valueOf(prixAchatField.getText()),Integer.valueOf(quantiteField.getText())
	    			,Double.valueOf(prixVenteField.getText()),descriptionField.getText() );
	    	
	    	System.out.println(prod.getDescription());
	    	prodDAO.create(prod);

	    	// actualiser la page de produits.
	    	Stage stage=(Stage) retour_btn.getScene().getWindow();
	    	Stage owner = (Stage) stage.getOwner();
	    	Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
	    	owner.getScene().setRoot(root);
	    	stage.close();
    	
	    	
	    	
	    	
	    }

	    @FXML
	    void retourner() throws IOException {
	    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
	    	  stage.close();
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			//fournisseurChoix=new ChoiceBox<>();
			FournisseurDAO fournissDAO=new FournisseurDAO();
			fournisseurs=fournissDAO.selectAllNames();
			fournisseurChoix.setItems(fournisseurs);
			
		}

}
