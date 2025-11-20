package application;
	
import application.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			java.net.URL url = getClass().getResource("WhackAMole.fxml");
			java.net.URL imageURL = getClass().getResource("mole-1.png");
			Image moleImage = new Image(imageURL.toString());
			FXMLLoader fxmlLoader = new FXMLLoader(url);
			Parent root = fxmlLoader.load();
			Scene scene = new Scene(root);
			MainController mainController = fxmlLoader.getController();
			mainController.initialize(moleImage);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}