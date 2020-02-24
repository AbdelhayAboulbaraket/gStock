package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import businessLayer.Fournisseur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistenceLayer.FournisseurDAO;

public class ModifierFournisseurController implements Initializable {
	
	@FXML
    private Button valider_btn;
	
    @FXML
    private TextField id;

    @FXML
    private Button retour_btn;

    @FXML
    private TextField adresse;

    @FXML
    private TextField tel;

    @FXML
    private TextField nom;

    @FXML
    private TextField email;
	  
	Fournisseur fournisseuraModifier;
	  

	   public void setFournisseuraModifier(Fournisseur input)
	    {	
		    this.nom.setText(input.getNom());
		    this.adresse.setText(input.getAdresse());
		    this.email.setText(input.getEmail());
		    this.tel.setText(input.getNumero());
		    this.id.setText(String.valueOf(input.getIdFournisseur()));		    
	    }

	    @FXML
	    public void retourner() 
	    {
	    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
	   	     stage.close();

	    }
	    
	    public void modifier() throws IOException
		{
			FournisseurDAO fournDAO=new FournisseurDAO();
			Fournisseur fourn=new Fournisseur((int)Integer.valueOf(this.id.getText()),this.nom.getText(),this.tel.getText(),this.email.getText(),this.adresse.getText());
			fournDAO.update(fourn);
			
			Stage stage= (Stage) retour_btn.getScene().getWindow();
	    	Stage parent=(Stage) stage.getOwner();
	    	Parent root = FXMLLoader.load(FournisseurController.class.getResource("fournisseur.fxml"));
	    	parent.setScene(new Scene(root));
	    	stage.close();
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
		this.id.setDisable(true);
	}

}
