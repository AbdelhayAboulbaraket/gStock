package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLayer.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistenceLayer.ClientDAO;

public class AjouterClientControllerVente implements Initializable {
	
	 	@FXML
	    private Button retour_btn;
	 	@FXML
	    private TextField idField;

	    @FXML
	    private TextField adresseField;

	    @FXML
	    private TextField emailField;

	    @FXML
	    private TextField telField;

	    @FXML
	    private TextField nomField;

	    @FXML
	    private Button validerBoutton;

	    @FXML
	    void ajouterClient() throws IOException
	    {
	    	ClientDAO clientDAO=new ClientDAO();
	    	Client client=new Client(nomField.getText(),emailField.getText(),telField.getText(),adresseField.getText());
	    	clientDAO.create(client);

	    	// actualiser la page de produits.
	    	Stage stage=(Stage) retour_btn.getScene().getWindow();
	    	Stage owner = (Stage) stage.getOwner();
	    	Parent root = FXMLLoader.load(getClass().getResource("ajouterVente.fxml"));
	    	owner.getScene().setRoot(root);
	    	stage.close();
	    }

	    @FXML
	    void retourner() 
	    {
	    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
	   	     stage.close();
	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.idField.setDisable(true);
	}

}
