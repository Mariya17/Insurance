package application;

import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ClaimsController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="Types"
    private ComboBox<String> Types; // Value injected by FXMLLoader

    @FXML // fx:id="claimBT"
    private Button claimBT; // Value injected by FXMLLoader
    
    @FXML
    private ImageView claimsImage;

    @FXML // fx:id="clientName"
    private ComboBox<String> clientName; // Value injected by FXMLLoader

    @FXML // fx:id="claims"
    private AnchorPane claims; // Value injected by FXMLLoader

    @FXML // fx:id="backBT"
    private Button backBT; // Value injected by FXMLLoader

    @FXML // fx:id="AgentName"
    private ComboBox<String> AgentName; // Value injected by FXMLLoader

    @FXML
    void chooseInsuranceType(ActionEvent event) {

    }

    @FXML
    void chooseAgentName(ActionEvent event) {

    }

    @FXML
    void chooseclientName(ActionEvent event) {

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
    	Logger.getInstance().writeLog("Go back to main window");
    }

    @FXML
    void claim(ActionEvent event) {
    	String infoMessage = "";
    	
    	if(clientName.getValue()==null){
    		infoMessage = "Please choose Client.";  		
    	}
    	else if(Types.getValue()==null){
    		infoMessage = "Please choose Insurance type.";
    	}
    	else if(AgentName.getValue()==null){
    		infoMessage = "Please choose Agent Name.";
    	}
    	else
    	{
        	Logger.getInstance().writeLog("Claim Insurance type: " + Types.getValue()+ 
        			"\n\t\t\t\tClient Name: " + clientName.getValue()+
        			"\n\t\t\t\tBy Agent: " + AgentName.getValue());
        	//TODO add to logger 
        	//TODO save claim in DB
        	infoMessage = "Claim filed!";
        	
    	}
    	JOptionPane.showMessageDialog(null, infoMessage, "InfoMessage", JOptionPane.INFORMATION_MESSAGE);

    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
        assert Types != null : "fx:id=\"Types\" was not injected: check your FXML file 'Claims.fxml'.";
        assert claimBT != null : "fx:id=\"claimBT\" was not injected: check your FXML file 'Claims.fxml'.";
        assert clientName != null : "fx:id=\"clientName\" was not injected: check your FXML file 'Claims.fxml'.";
        assert claims != null : "fx:id=\"claims\" was not injected: check your FXML file 'Claims.fxml'.";
        assert backBT != null : "fx:id=\"backBT\" was not injected: check your FXML file 'Claims.fxml'.";
        assert AgentName != null : "fx:id=\"AgentName\" was not injected: check your FXML file 'Claims.fxml'.";

        BufferedReader br = new BufferedReader(new FileReader("C://Users//Mariya Portnoy//WorkSpace//Insurance//src//application//Config.xml"));
        
        try {
            StringBuilder sb = new StringBuilder();
            String line ;

            while ((line = br.readLine()) != null){
	            if(line.contentEquals("#startAgents")){
	            	line = br.readLine();
	            	while (!line.contentEquals("#endAgents")) {
	           		 //Add Item
	            		AgentName.getItems().add(line);
	
	                   sb.append(line);
	                   line = br.readLine();       
	               }
	            }
            }           
        } finally {
            br.close();
        }
     // TODO get client name and his policy from DB and add it to relevant combo boxes
    }
}
