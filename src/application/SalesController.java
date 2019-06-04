

package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SalesController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Types"
    private ComboBox<String> Types; // Value injected by FXMLLoader

    @FXML // fx:id="AgentFirstName"
    private TextField AgentFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="agentID"
    private TextField agentID; // Value injected by FXMLLoader

    @FXML // fx:id="AgentLastName"
    private TextField AgentLastName; // Value injected by FXMLLoader

    @FXML // fx:id="clientID"
    private TextField clientID; // Value injected by FXMLLoader
    
    @FXML // fx:id="saveBT"
    private Button saveBT; // Value injected by FXMLLoader


    @FXML // fx:id="ClientLastName"
    private TextField ClientLastName; // Value injected by FXMLLoader
    
    @FXML // fx:id="backBT"
    private Button backBT; // Value injected by FXMLLoader


    @FXML // fx:id="ClientFirstName"
    private TextField ClientFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="sales"
    private AnchorPane sales; // Value injected by FXMLLoader

    @FXML
    void handleAgentID(ActionEvent event) {

    }

    @FXML
    void chooseInsuranceType(ActionEvent event) {

    }

    @FXML
    void handleAgentFirtsName(ActionEvent event) {

    }

    @FXML
    void handleAgentLastName(ActionEvent event) {

    }

    @FXML
    void handleClientLastName(ActionEvent event) {

    }

    @FXML
    void handleClientFirtsName(ActionEvent event) {

    }

    @FXML
    void handleClientID(ActionEvent event) {

    }
    

    @FXML
    void back(ActionEvent event) {
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainForm.fxml"));
            
            Stage stage = (Stage) backBT.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    @FXML
    void save(ActionEvent event) {
    	
    	saveBT.setText("Saved!");
    	//Mariya return to factory
    	Types.getItems();
       
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
        assert Types != null : "fx:id=\"Types\" was not injected: check your FXML file 'Sales.fxml'.";
        assert AgentFirstName != null : "fx:id=\"AgentFirstName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert agentID != null : "fx:id=\"agentID\" was not injected: check your FXML file 'Sales.fxml'.";
        assert AgentLastName != null : "fx:id=\"AgentLastName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert clientID != null : "fx:id=\"clientID\" was not injected: check your FXML file 'Sales.fxml'.";
        assert saveBT != null : "fx:id=\"saveBT\" was not injected: check your FXML file 'Sales.fxml'.";
        assert ClientLastName != null : "fx:id=\"ClientLastName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert backBT != null : "fx:id=\"backBT\" was not injected: check your FXML file 'Sales.fxml'.";
        assert ClientFirstName != null : "fx:id=\"ClientFirstName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert sales != null : "fx:id=\"sales\" was not injected: check your FXML file 'Sales.fxml'.";

        
        BufferedReader br = new BufferedReader(new FileReader("C://Users//Mariya Portnoy//WorkSpace//Insurance//src//application//Config.xml"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (!line.contentEquals("#AgentsID")) {
        		 //Add Item
            	Types.getItems().add(line);

                sb.append(line);
                line = br.readLine();       
            }
        } finally {
            br.close();
        }
    }
}
