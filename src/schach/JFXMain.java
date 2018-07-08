package schach;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JFXMain extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	@FXML
	private Text helloworld;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JFX Test");
        
        try {
        	System.out.println(JFXMain.class.getResource("TestLayout.fxml"));
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JFXMain.class.getResource("TestLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            //rootLayout.getChildren()
            primaryStage.setScene(scene);
            primaryStage.show();
            JFXMain controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@FXML
    private void initialize() {
		helloworld.setText("HUHU");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
