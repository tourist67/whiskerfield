
package main;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Gamepanel extends JPanel implements Runnable {

	// SCREEN SETTINGS
	final int originalTileSize = 16;
	final int scale = 3;

	final int tileSize = originalTileSize * scale; 
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow; 

	Thread gameThread;

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		while (gameThread != null) {
			update();
			repaint();
		}
	}

	public void update() {
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}
