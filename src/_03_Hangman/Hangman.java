package _03_Hangman;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class Hangman implements KeyListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	int num = 0;
	Stack<String> words = new Stack<String>();
	String nextValue;
	int lives;
	int rounds;
	String word;

	public void showWindow() {
		String numInput = JOptionPane.showInputDialog("Enter how many rounds you want to play (between 1 and 269)");
		try {
			num = Integer.parseInt(numInput);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a valid number!");
			showWindow();
			return;
		}
		
		if (num < 1 || num > 269) {
			JOptionPane.showMessageDialog(null, "Enter a valid number!");
			showWindow();
			return;
		}
		
		for (int i = 0; i < num; i++) {
			nextValue = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(nextValue)) {
				words.push(nextValue);
			} else {
				i--;
			}
		}
		
		rounds = 0;
		word = words.pop();
		frame = new JFrame();
		panel = new JPanel();
		lives = 6;
		label = new JLabel("");
		label.setFont(new Font("Serif", Font.PLAIN, 48));
		for (int i = 0; i < word.length(); i++) {
			label.setText(label.getText() + "_ ");
		}
		System.out.println(word);
		panel.add(label);
		frame.add(panel);
		frame.setTitle("Lives: " + lives);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		
	}

	public static void main(String[] args) {
		new Hangman().showWindow();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!label.getText().contains(e.getKeyChar() + "") && e.getKeyChar() != '_' && e.getKeyChar() != ' ') {
			if (word.contains(e.getKeyChar() + "")) {
				for (int i = 0; i < word.length() - 1; i++) {
					if (word.charAt(i) == e.getKeyChar()) {
						// new StringBuilder()
					}
				}
			} else {
				lives --;
			}
		} 
	}
	
	public void reset() {
		if (rounds == num) {
			
		} else {
			word = words.pop();
			frame = new JFrame();
			panel = new JPanel();
			lives = 6;
			label = new JLabel("");
			label.setFont(new Font("Serif", Font.PLAIN, 28));
			for (int i = 0; i < word.length(); i++) {
				label.setText(label.getText() + "_ ");
			}
			System.out.println(word);
			panel.add(label);
			frame.add(panel);
			frame.setTitle("Lives: " + lives);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			rounds ++;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
