package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import main.Gamepanel;
import main.KeyHandler;

public class Player extends Entity {
	Gamepanel gp;
	KeyHandler keyH;

	public final int screenX;
	public final int screenY;
	
	int spriteCounter = 0;
	int spriteNum = 1;

	public Player(Gamepanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;

		solidArea = new Rectangle(8,16,32,32); 

		screenX = gp.screenWidth / 2 - (gp.tileSize * 3) / 2;
		screenY = gp.screenHeight / 2 - (gp.tileSize * 3) / 2;
		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		worldX = gp.tileSize * 10;
		worldY = gp.tileSize * 10;
		speed = 3;
		direction = "down";
	}

	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/player_right_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
			if (keyH.upPressed == true) {
				direction = "up";
			}
			if (keyH.downPressed == true) { 
				direction = "down";
			}
			if (keyH.leftPressed == true) {
				direction = "left";
			}
			if (keyH.rightPressed == true) {
				direction = "right";
			}

			collisionOn = false;
			gp.cChecker.checkTile(this);

			if (collisionOn == false) {
				switch (direction) {
					case "up":
						worldY -= speed;
						break;
					case "down":
						worldY += speed;
						break;
					case "left":
						worldX -= speed;
						break;
					case "right":
						worldX += speed;
						break;
				}
			}



			spriteCounter++;
			if (spriteCounter > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
			case "up":
				if (spriteNum == 1) {
					image = up1;
				} else {
					image = up2;
				}
				break;
			case "down":
				if (spriteNum == 1) {
					image = down1;
				} else {
					image = down2;
				}
				break;
			case "left":
				if (spriteNum == 1) {
					image = left1;
				} else {
					image = left2;
				}
				break;
			case "right":
				if (spriteNum == 1) {
					image = right1;
				} else {
					image = right2;
				}
				break;
		}

		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
