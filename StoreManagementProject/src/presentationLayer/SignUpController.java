package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.xml.bind.DatatypeConverter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import persistenceLayer.*;
import businessLayer.*;

public class SignUpController implements Initializable {
	
	 @FXML
	    private Button signButton;

	    @FXML
	    private Button login_two;

	    @FXML
	    private PasswordField mdp;

	    @FXML
	    private TextField prenom;

	    @FXML
	    private TextField nom;

	    @FXML
	    private TextField login;
	 
	    @FXML
	    void signUp() throws NoSuchAlgorithmException, IOException {
	    	
	    	
	    	UserDAO userdao=new UserDAO();
	    	String pass=mdp.getText();
	    	MessageDigest md = MessageDigest.getInstance("MD5");
		    md.update(pass.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		    
	    	User user=new User(login.getText(),nom.getText(),prenom.getText(),myHash);
	    	userdao.create(user);
	    	this.login_again();
	    	
	    	
	    }


	    @FXML
	    public void login_again() throws IOException {
	    	login_two.getScene().getWindow().hide();
	    	Stage loginStage = new Stage();
	    	FXMLLoader Loader = new FXMLLoader(getClass().getResource("signup.fxml"));
	    	Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
	    	Scene scene = new Scene(root);
	    	loginStage.setScene(scene);
	    	loginStage.show();
	    	loginStage.setResizable(false);

	    }


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			
			
		}

	
	

}
