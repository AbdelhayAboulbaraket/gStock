package presentationLayer;
import persistenceLayer.*;
import businessLayer.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjouterFournisseurController implements Initializable {
	
	
    @FXML
    private Button retour_btn;
   
    @FXML
    private Button validation_btn;
    
    @FXML
    private TextField id;
    
    @FXML
    private TextField nom;
    
    @FXML
    private TextField tel;
    
    @FXML
    private TextField email;
    
    @FXML
    private TextField adresse;
    
    Fournisseur fournisseraModifier;
    
 
    
    
    @FXML
    void ajouter() throws IOException
    {
    	FournisseurDAO nv= new FournisseurDAO();
    	Fournisseur fournisseur=new Fournisseur(nom.getText(),tel.getText(),adresse.getText(),email.getText());
    	nv.create(fournisseur);
    	Stage stage= (Stage)validation_btn.getScene().getWindow();
    	Stage parent=(Stage)stage.getOwner();
    	Parent root = FXMLLoader.load(
    		     UserController.class.getResource("fournisseur.fxml"));
    		     parent.setScene(new Scene(root));
    	stage.close();
    }
    
   
    
    
    @FXML
    void retourner() {
    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
   	     stage.close();
   	     
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		id.setDisable(true);
		//nom.setText(this.fournisseraModifier.getNom());
	}

}
