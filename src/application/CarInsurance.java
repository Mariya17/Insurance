package application;

import javax.swing.JOptionPane;

public class CarInsurance implements Insurance{

	public void computrInsCost(int age)
	{
		JOptionPane.showMessageDialog(null, "New Car insurance was created.\n The cost is: " + (120-age)*4 + "NIS.", "InfoMessage", JOptionPane.INFORMATION_MESSAGE);
	}
}

