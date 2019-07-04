package application;

import javax.swing.JOptionPane;

public class LifeInsurance implements Insurance{

	public void computrInsCost(int age)
	{
		JOptionPane.showMessageDialog(null, "New Life insurance was created.\n The cost is: " + Math.pow(age,2) + "NIS.", "InfoMessage", JOptionPane.INFORMATION_MESSAGE); 
	}
}
