

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;

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
    
    @FXML // fx:id="AgentName"
    private ComboBox<String> AgentName; // Value injected by FXMLLoader

    @FXML // fx:id="Types"
    private ComboBox<String> Types; // Value injected by FXMLLoader

    @FXML // fx:id="saveBT"
    private Button saveBT; // Value injected by FXMLLoader

    @FXML // fx:id="dueDate"
    private TextField dueDate; // Value injected by FXMLLoader

    @FXML // fx:id="backBT"
    private Button backBT; // Value injected by FXMLLoader

    @FXML // fx:id="ClientFirstName"
    private TextField ClientFirstName; // Value injected by FXMLLoader
    
    @FXML // fx:id="ClientLastName"
    private TextField ClientLastName; // Value injected by FXMLLoader

    @FXML // fx:id="sales"
    private AnchorPane sales; // Value injected by FXMLLoader
    
    @FXML // fx:id="Age"
    private ComboBox<String> Age; // Value injected by FXMLLoader

    @FXML
    void chooseInsuranceType(ActionEvent event) {

    }

    @FXML
    void handleClientLastName(ActionEvent event) {

    }

    @FXML
    void handleClientFirtsName(ActionEvent event) {

    }

    @FXML
    void handleDueDate(ActionEvent event) {
    }
    
    @FXML
    void chooseAgentName(ActionEvent event) {

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
    void chooseAge(ActionEvent event) {

    }
    
    @FXML
    void save(ActionEvent event) {
    	String infoMessage = "";
    	InsuranceFactory insuranceFactory = new InsuranceFactory();
    	
    	if(ClientFirstName.getText().isEmpty()){
    		infoMessage = "Please write client First Name.";  		
    	}
    	else if(ClientLastName.getText().isEmpty()){
    		infoMessage = "Please write client Last Name.";  		
    	}
    	else if(Types.getValue()==null){
    		infoMessage = "Please choose Insurance type.";
    	}
    	else if(AgentName.getValue()==null){
    		infoMessage = "Please choose Agent Name.";
    	}
    	else if(Age.getValue()==null){
    		infoMessage = "Please choose client age.";
    	}
    	else
    	{
        	//Mariya return to factory
        	Logger.getInstance().writeLog("Save Insurance type: " + Types.getValue()+ 
        			"\n\t\t\t\tClient Name: " + ClientFirstName.getText()+ " " + ClientFirstName.getText()+
        			"\n\t\t\t\tBy Agent: " + AgentName.getValue());
        	//saveBT.setText("Saved!");
        	Insurance ins = insuranceFactory.create(Types.getValue());
        	ins.computrInsCost(Integer.parseInt(Age.getValue()));
        	//infoMessage = "Data was saved!";
        	ClientFirstName.clear();
        	ClientLastName.clear();
        	return;
    	}
    	JOptionPane.showMessageDialog(null, infoMessage, "InfoMessage", JOptionPane.INFORMATION_MESSAGE);
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws IOException {
        assert Types != null : "fx:id=\"Types\" was not injected: check your FXML file 'Sales.fxml'.";
        assert saveBT != null : "fx:id=\"saveBT\" was not injected: check your FXML file 'Sales.fxml'.";
        assert dueDate != null : "fx:id=\"dueDate\" was not injected: check your FXML file 'Sales.fxml'.";
        assert ClientLastName != null : "fx:id=\"ClientLastName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert backBT != null : "fx:id=\"backBT\" was not injected: check your FXML file 'Sales.fxml'.";
        assert ClientFirstName != null : "fx:id=\"ClientFirstName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert AgentName != null : "fx:id=\"AgentName\" was not injected: check your FXML file 'Sales.fxml'.";
        assert sales != null : "fx:id=\"sales\" was not injected: check your FXML file 'Sales.fxml'.";

        
        BufferedReader br = new BufferedReader(new FileReader("C://Users//Mariya Portnoy//WorkSpace//Insurance//src//application//Config.xml"));
        
        //BufferedReader br = new BufferedReader(new FileReader("C://Git//Insurance//src//applicationConfig.xml"));
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        
        try {
            StringBuilder sb = new StringBuilder();
            String line ;
            
            while ((line = br.readLine()) != null){
	            if(line.contentEquals("#startInsurance")){
	            	line = br.readLine();
	            	while (!line.contentEquals("#endInsurance")) {
	           		 //Add Item
	               	Types.getItems().add(line);
	
	                   sb.append(line);
	                   line = br.readLine();       
	               }
	            }

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
 
        for(int i = 0;i<121;i++){
        	Age.getItems().add(Integer.toString(i));
        }
        
        //Due Date
        dueDate.setText(timeStamp);

        
    }
}
