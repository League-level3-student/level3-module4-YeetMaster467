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
		String numInput = JOptionPane.showInputDialog("Enter how many rounds you want to play (between 1 and "
				+ Utilities.getTotalWordsInFile("dictionary.txt") + ")");
		try {
			num = Integer.parseInt(numInput);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a valid number!");
			showWindow();
			return;
		}

		if (num < 1 || num > Utilities.getTotalWordsInFile("dictionary.txt")) {
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
		label.setFont(new Font("Arial", Font.PLAIN, 48));
		for (int i = 0; i < word.length(); i++) {
			label.setText(label.getText() + "_ ");
		}
		// System.out.println(word);
		panel.add(label);
		frame.add(panel);
		frame.setTitle("Lives: " + lives);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();

	}

	public static void main(String[] args) {
		new Hangman().showWindow();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println(lives);
		if (!label.getText().contains(e.getKeyChar() + "") && e.getKeyChar() != '_' && e.getKeyChar() != ' ' && word.contains(e.getKeyChar() + "")) {
				StringBuilder s = new StringBuilder(label.getText());
				for (int i = 0; i < s.length() - 1; i += 2) {
					if (word.charAt(i / 2) == e.getKeyChar()) {
						s.replace(i, i + 1, e.getKeyChar() + "");
						label.setText(s.toString());
						frame.pack();
					}
				}
		} else {
			lives--;
			frame.setTitle("Lives: " + lives);
			if (lives == 0) {
				int option = JOptionPane.showConfirmDialog(null, "Game Over!\nWould you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					frame.dispose();
					showWindow();
					return;
				} else {
					System.exit(0);
				}
			}
		}
		if (!label.getText().contains("_")) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			reset();
		}
	}

	public void reset() {
		frame.dispose();
		if (rounds == num || words.isEmpty()) {
			JOptionPane.showMessageDialog(null, "You win! You have completed all " + num + " rounds!");
			System.exit(0);
		} else {
			word = words.pop();
			frame = new JFrame();
			panel = new JPanel();
			lives = 6;
			label = new JLabel("");
			label.setFont(new Font("Arial", Font.PLAIN, 48));
			for (int i = 0; i < word.length(); i++) {
				label.setText(label.getText() + "_ ");
			}
			// System.out.println(word);
			panel.add(label);
			frame.add(panel);
			frame.setTitle("Lives: " + lives);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.addKeyListener(this);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			rounds++;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
