package presentationLayer;



import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;


import javax.xml.bind.DatatypeConverter;

import businessLayer.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistenceLayer.*;


public class LoginController implements Initializable {
	@FXML
	private Button login;
	
	@FXML
	private Button signUp;
	
	  @FXML
	    private TextField username;

	    @FXML
	    private PasswordField mdp;

	@FXML
	CheckBox rememberMe = new CheckBox("remember me");
	
    @FXML
    public void show() throws IOException {
    	login.getScene().getWindow().hide();
    	Stage articleStage = new Stage();
    	FXMLLoader Loader = new FXMLLoader(getClass().getResource("login.fxml"));
    	Parent root = FXMLLoader.load(getClass().getResource("produit.fxml"));
    	Scene scene = new Scene(root);
    	articleStage.setScene(scene);
    	articleStage.show();
    	articleStage.setResizable(false);
    	
    	
    }

    @FXML
    public void sign_in() throws IOException {
    	login.getScene().getWindow().hide();
    	Stage signupStage = new Stage();
    	FXMLLoader Loader = new FXMLLoader(getClass().getResource("login.fxml"));
    	Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
    	Scene scene = new Scene(root);
    	signupStage.setScene(scene);
    	signupStage.show();
    	signupStage.setResizable(false);
    	
    	
    	
    }
    	
    @FXML
    public void verifier() throws NoSuchAlgorithmException, IOException
    {	
    	UserDAO userdao=new UserDAO();
    	User user= userdao.find(username.getText());
    	
    	    	    
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(mdp.getText().getBytes());
	    
	    byte[] digest = md.digest();
	    String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
	    
	    if(myHash.equals(user.getMotDePasse()))
	    {
	    	this.show();
	    }
	    else
	    {
	    	mdp.setText("");
	    	username.setText("");
	    }
    	
    }
    
    @FXML
    public void remember() {
		//System.out.println("remembered");
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		UserDAO userdao=new UserDAO();
		int count=userdao.UserCount();
		if(count!=0) this.signUp.setDisable(true);
		else this.signUp.setDisable(false);
		
	}


}
