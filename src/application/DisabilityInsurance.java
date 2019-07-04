package application;

import javax.swing.JOptionPane;

public class DisabilityInsurance implements Insurance{

	public void computrInsCost(int age)
	{
		JOptionPane.showMessageDialog(null, "New Disability insurance was created.\n The cost is: " + age + "NIS.", "InfoMessage", JOptionPane.INFORMATION_MESSAGE);
	}
}