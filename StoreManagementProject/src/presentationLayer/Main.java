package presentationLayer;
	


import businessLayer.Fournisseur;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistenceLayer.FournisseurDAO;



public class Main extends Application {
	@FXML
	static AnchorPane root;
	@Override
	public void start(Stage primaryStage) {
		try {
			root = FXMLLoader.load(getClass().getResource("login.fxml"));		
			//Parent root = FXMLLoader.load(getClass().getResource("/Application/Main/.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		FournisseurDAO fo=new FournisseurDAO();
		//fo.create(new Fournisseur("samir","jsp","jsp","jsp"));
	}
}
