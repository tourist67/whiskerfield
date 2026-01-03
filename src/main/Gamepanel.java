
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;

public class Gamepanel extends JPanel implements Runnable {

	// SCREEN SETTINGS
	final int originalTileSize = 16;
	final int scale = 3;

	public final int tileSize = originalTileSize * scale; 
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow; 

	// WORLD SETTINGS
	public final int maxWorldCol = 35;
	public final int maxWorldRow = 36;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;


	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public Player player = new Player(this, keyH);
	TileManager tileM = new TileManager(this);
	public CollisionChecker cChecker = new CollisionChecker(this);

	// FPS
	int FPS = 60;

	public Gamepanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000 / FPS; // 0.01666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (gameThread != null) {
			update();
			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long) remainingTime);

				nextDrawTime += drawInterval;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		player.update();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		tileM.draw(g2);
		player.draw(g2);

		g2.dispose();
	}
}
