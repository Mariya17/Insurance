package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ModelCustomer {
	String csvPath = "C:\\Users\\Galit\\workspace\\Insurance-master\\src\\application\\db.csv";
	ArrayList<String[]> dbMatrix = new ArrayList<String[]>();

	public ModelCustomer() {

		try (BufferedReader br = new BufferedReader(new FileReader(this.csvPath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] lineItems = line.split(",");
				this.dbMatrix.add(lineItems);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end of ModelCustomer constructor

	public ArrayList<String> getCustomerList() {
		ArrayList<String> resulte = new ArrayList<String>();
		for (int i = 0; i < this.dbMatrix.size(); i++)
			resulte.add(this.dbMatrix.get(i)[0] + " " + this.dbMatrix.get(i)[1]);
		return resulte;
	}// end of getCustomerList method

	public int custoumerInDB(String customer) {
		/*
		 * Description: If customer in DB returns the index in ArrayList else
		 * returns -1
		 */
		ArrayList<String> customers = getCustomerList();
		for (int i = 0; i < customers.size(); i++)
			if (customers.get(i).equals(customer))
				return i;

		return -1;
	}// end of custoumerInDB method

	public void addCostumer(String customerFirstName, String customerFamilyName, String insuranceType)
			throws IOException {
		/*
		 * Description: This method is responsible for getting a customer
		 * details and add the to DB
		 */
		int index = custoumerInDB(customerFirstName + " " + customerFamilyName);
		if (index != -1) {// if the customer is already in DB than need to add
							// only Insurance type
			this.dbMatrix.get(index)[2] += ":" + insuranceType;
		} else {// add a row in matrixDB
			String[] lineItems = { customerFirstName, customerFamilyName, insuranceType };
			this.dbMatrix.add(lineItems);
		}
		writeToCsvDB();
	}// end of addCostumer method

	private void writeToCsvDB() throws IOException {
		/*
		 * Description: This method is responsible for converting matrixDB to
		 * csv file
		 */
		try (PrintWriter writer = new PrintWriter(new File(this.csvPath))) {
			StringBuilder sb = new StringBuilder();
			for (String[] lineDB : this.dbMatrix) {
				String lineItems = lineDB[0] + "," + lineDB[1] + "," + lineDB[2] + "\n";
				sb.append(lineItems);

			}
			writer.write(sb.toString());
			writer.close();
		} catch (Exception e) {
			System.out.println("Please check if file " + this.csvPath + "is open");
		}

	}

	public ArrayList<String> getCustomerTypesList(String customer){
		ArrayList<String> resulte = new ArrayList<String>();
		int index = custoumerInDB(customer);//return the index of required customer
		String typesStr = this.dbMatrix.get(index)[2];
		try{
			String[] typesStrArr = typesStr.split(":");
		for(String s: typesStrArr)
			resulte.add(s);
		}catch(Exception e){
			resulte.add(typesStr);
		}
		
		return resulte;
	}// end of getCustomerTypesList method
}
