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

public class ModifierClientController implements Initializable {
	
	  @FXML
	    private Button valider_btn;

	    @FXML
	    private Button retour_btn;

	    @FXML
	    private TextField adresse;

	    @FXML
	    private TextField tel;

	    @FXML
	    private TextField id;

	    @FXML
	    private TextField nom;

	    @FXML
	    private TextField email;
	    
	    public void setClient(Client input)
	    {
	    	this.nom.setText(input.getNom());
	    	this.id.setText(String.valueOf(input.getId()));
	    	this.email.setText(input.getEmail());
	    	this.adresse.setText(input.getAdresse());
	    	this.tel.setText(input.getTel());
	    }

	    @FXML
	    void modifierClient() throws IOException
	    {
	    	ClientDAO clientDAO=new ClientDAO();
	    	Client client=new Client((int)Integer.valueOf(this.id.getText()),nom.getText(),email.getText(),tel.getText(),adresse.getText());
	    	clientDAO.update(client);

	    	// actualiser la page de produits.
	    	Stage stage=(Stage) retour_btn.getScene().getWindow();
	    	Stage owner = (Stage) stage.getOwner();
	    	Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
	    	owner.getScene().setRoot(root);
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
		this.id.setDisable(true);
	}

}
