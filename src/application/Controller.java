package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="SalesBT"
    private Button SalesBT; // Value injected by FXMLLoader

    @FXML // fx:id="MainWindow"
    private AnchorPane MainWindow; // Value injected by FXMLLoader

    @FXML // fx:id="ClaimsBT"
    private Button ClaimsBT; // Value injected by FXMLLoader

    @FXML // fx:id="ExitBT"
    private Button ExitBT; // Value injected by FXMLLoader

    @FXML
    void exit(ActionEvent event) {
    	// get a handle to the stage
        Stage stage = (Stage) ExitBT.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void goToSales(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Sales.fxml"));
            Stage stage = (Stage) SalesBT.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }

    }

    @FXML
    void goToClaims(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert SalesBT != null : "fx:id=\"SalesBT\" was not injected: check your FXML file 'mainForm.fxml'.";
        assert MainWindow != null : "fx:id=\"MainWindow\" was not injected: check your FXML file 'mainForm.fxml'.";
        assert ClaimsBT != null : "fx:id=\"ClaimsBT\" was not injected: check your FXML file 'mainForm.fxml'.";
        assert ExitBT != null : "fx:id=\"ExitBT\" was not injected: check your FXML file 'mainForm.fxml'.";

    }
}
