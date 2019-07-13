package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("mainForm.fxml")));
		// scene.getStylesheets().add("application.css");
		stage.setScene(scene);
		stage.setTitle("Insuranse MAGM");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
    
	Logger logger = Logger.getInstance();logger.writeLog("Start");

	launch(args);
            
        try {
        	logger.getInstance().writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
