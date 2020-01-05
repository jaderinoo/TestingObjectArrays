package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException
	{
		URL url = getClass().getResource("FxFXMLExample1.fxml");
	        if (url == null) {
	            System.out.println("Can't load FXML file");
	            Platform.exit();
	        }
	    VBox root = (VBox) FXMLLoader.load(url);

		// Create the Scene
		Scene scene = new Scene(root);
		// Set the Scene to the Stage
		stage.setScene(scene);
		// Set the Title to the Stage
		stage.setTitle("JavaFx Testing Environment");
		// Display the Stage
		stage.show();
	}
}
