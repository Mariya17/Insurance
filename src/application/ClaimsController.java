package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
		////Create ComboBox of insurance types by a customer name from db
		ModelCustomer db = new ModelCustomer();
		Types.getItems().clear();
		ObservableList<String> List_customerTypes = FXCollections.observableArrayList(db.getCustomerTypesList(clientName.getValue()));
		Types.setItems(List_customerTypes);
	}

	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("mainForm.fxml"));

			Stage stage = (Stage) backBT.getScene().getWindow();
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
		} catch (IOException io) {
			io.printStackTrace();
		}
		Logger.getInstance().writeLog("Go back to main window");
	}

	@FXML
	void claim(ActionEvent event) {
		String infoMessage = "";

		if (clientName.getValue() == null) {
			infoMessage = "Please choose Client.";
		} else if (Types.getValue() == null) {
			infoMessage = "Please choose Insurance type.";
		} else if (AgentName.getValue() == null) {
			infoMessage = "Please choose Agent Name.";
		} else {
			// Mariya return to factory
			Logger.getInstance().writeLog("Claim Insurance type: " + Types.getValue() + "\n\t\t\t\tClient Name: "
					+ clientName.getValue() + "\n\t\t\t\tBy Agent: " + AgentName.getValue());
			// saveBT.setText("Saved!");
			infoMessage = "Claim filed!";

		}
		JOptionPane.showMessageDialog(null, infoMessage, "InfoMessage", JOptionPane.INFORMATION_MESSAGE);

	}

	@SuppressWarnings("unchecked")
	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() throws IOException {
		assert Types != null : "fx:id=\"Types\" was not injected: check your FXML file 'Claims.fxml'.";
		assert claimBT != null : "fx:id=\"claimBT\" was not injected: check your FXML file 'Claims.fxml'.";
		assert clientName != null : "fx:id=\"clientName\" was not injected: check your FXML file 'Claims.fxml'.";
		assert claims != null : "fx:id=\"claims\" was not injected: check your FXML file 'Claims.fxml'.";
		assert backBT != null : "fx:id=\"backBT\" was not injected: check your FXML file 'Claims.fxml'.";
		assert AgentName != null : "fx:id=\"AgentName\" was not injected: check your FXML file 'Claims.fxml'.";

		BufferedReader br = new BufferedReader(
				new FileReader("C://Users//Galit//workspace//Insurance-master//src//application//Config.xml"));

		try {
			StringBuilder sb = new StringBuilder();
			String line;

			//Create ComboBox of agent's name from settings
			while ((line = br.readLine()) != null) {
				if (line.contentEquals("#startAgents")) {
					line = br.readLine();
					while (!line.contentEquals("#endAgents")) {
						// Add Item
						AgentName.getItems().add(line);

						sb.append(line);
						line = br.readLine();
					}
				}
			}
		} finally {
			br.close();
		}
		
		//Create ComboBox of customers name from db
		ModelCustomer db = new ModelCustomer();
		clientName.getItems().clear();
		ObservableList<String> List_customers = FXCollections.observableArrayList(db.getCustomerList());
		clientName.setItems(List_customers);
		
	}
}
