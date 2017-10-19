package pack;

import javax.swing.JOptionPane;

public class Resistors {
	public static void main(String[] args) {
		String[] colours = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
		boolean error = false;
		while (true) {
			String input = (String) JOptionPane.showInputDialog(null,
					"What, in order, are the colours of the resistor\n"
							+ "that you wish to find the value of? Please format\n"
							+ "your input as \"COLOUR1-COLOUR2-COLOUR3.\"\n\n" + "For example:\n" + "RED-ORANGE-BROWN",
					"Resistor Strength Calculator", 2, null, null, 6);
			input = input.replaceAll(" ", "").toLowerCase();
			String[] inputs = input.split("-");
			if (inputs.length != 3) {
				JOptionPane.showMessageDialog(null, "This input was invalid. Please try again.", "Error",
						JOptionPane.ERROR_MESSAGE);
				continue;
			}
			for (int i = 0; i < 3; i++) {
				for (int n = 0; n < 10; n++) {
					if (inputs[i].equals(colours[n])) {
						inputs[i] = n + ""; // adding an empty string is to make the int a string
						break;
					} else if (n == 9) {
						error = true;
					}
				}
			}
			if (error == true) {
				JOptionPane.showMessageDialog(null, "This input was invalid. Please try again.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"This resistor's value is " + (Integer.parseInt(inputs[0] + inputs[1]) //calculating total ohms
								* Math.pow(10, (Integer.parseInt(inputs[2])))) + " ohms, which\n"
										+ "can also be represented as "
										+ (inputs[0] + inputs[1]) + " x 10^" + (inputs[2]) + " ohms.", //showing equation with plugged-in variables
						"Resistor Strength Calculator", JOptionPane.INFORMATION_MESSAGE, null);
				System.exit(0);
			}
		}
	}
}
