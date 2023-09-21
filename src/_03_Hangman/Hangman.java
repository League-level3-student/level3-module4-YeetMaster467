package _03_Hangman;

import java.util.Stack;

import javax.swing.*;

public class Hangman {
	
	int num = 0;
	Stack<String> words = new Stack<String>();
	
	public void showWindow() {
		String numInput = JOptionPane.showInputDialog("Enter how many rounds you want to play (between 1 and 269)");
		try {
			num = Integer.parseInt(numInput);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a valid number!");
			showWindow();
		}
		
		if (num < 1 || num > 269) {
			JOptionPane.showMessageDialog(null, "Enter a valid number!");
			showWindow();
		}
		
		for (int i = 0; i < num; i++) {
			Utilities.readRandomLineFromFile("dictionary.txt");
		}
	}
	
	public static void main(String[] args) {
		new Hangman().showWindow();
	}
}
