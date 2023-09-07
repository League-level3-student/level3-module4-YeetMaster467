package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("");
	Stack<Character> deletedChars = new Stack<Character>();
	StringBuilder s = new StringBuilder("");
	
	public void showWindow() {
		panel.add(label);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Text Editor");
		frame.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == e.VK_DELETE) {
			char lastChar = label.getText().charAt(label.getText().length());
			deletedChars.push(lastChar);
			s = new StringBuilder(label.getText());
			label.setText(s.deleteCharAt(s.length()).toString());
		} else if (e.getKeyCode() == e.VK_ENTER) {
			char undidChar = deletedChars.pop();
			s = new StringBuilder(label.getText());
			label.setText(s.append(undidChar).toString());
		} else {
			label.setText(label.getText() + e.getKeyChar() + "");
		}
		frame.pack();
		if (frame.WIDTH < 800 || frame.HEIGHT < 600) {
			frame.setSize(800, 600);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {

	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().showWindow();
	}

}
