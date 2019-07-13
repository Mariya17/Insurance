package application;

import javax.swing.JOptionPane;

public class ApartmentInsurance implements Insurance{

	public void computrInsCost(int age)
	{
		JOptionPane.showMessageDialog(null, "New Apartment insurance was created.\n The cost is: " + age*3 + "NIS.", "InfoMessage", JOptionPane.INFORMATION_MESSAGE);
	}
}