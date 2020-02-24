package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.xml.bind.DatatypeConverter;

import businessLayer.*;
import businessLayer.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistenceLayer.*;
import persistenceLayer.UserDAO;

public class AjouterUserController implements Initializable {
	
	    @FXML
	    private Button retour_btn;
	    
	    @FXML
	    private TextField id;

	    @FXML
	    private TextField nom;

	    @FXML
	    private TextField prenom;

	    @FXML
	    private TextField mdp;

	    @FXML
	    private Button valider_btn;

	    @FXML
	    void retourner() throws IOException {
	    	
	    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
	    	 stage.close();
	    }
	    
	    @FXML
	    void ajouter() throws IOException, NoSuchAlgorithmException
	    {
	    	UserDAO nv= new UserDAO();
	    	
	    	MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(mdp.getText().getBytes());
		    
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    	
	    	User user=new User(id.getText(),nom.getText(),prenom.getText(),myHash);
	    	nv.create(user);
	    	Stage stage= (Stage)valider_btn.getScene().getWindow();
	    	Stage parent=(Stage)stage.getOwner();
	    	Parent root = FXMLLoader.load(UserController.class.getResource("user.fxml"));
	    	parent.setScene(new Scene(root));
	    	stage.close();
	    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
