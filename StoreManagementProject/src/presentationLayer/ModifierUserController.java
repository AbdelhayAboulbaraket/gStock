package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ModifierUserController implements Initializable {
	
    @FXML
    private Button retour_btn;

    @FXML
    void retourner() throws IOException {


    	
    	 Stage stage = (Stage) retour_btn.getScene().getWindow();
    	 stage.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
