package main;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame("2D RPG Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 600); // Example size, can be changed
		window.setLocationRelativeTo(null); // Center the window
		window.setVisible(true);
	}
}
