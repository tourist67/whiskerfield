package object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Gamepanel;

public class SuperObject {
  public BufferedImage image;
  public String name;
  public boolean collision = false;
  public int worldX, worldY;
  public boolean stackable = false;
  public int stackCount = 1;
  public boolean pickupable = true; // Can player pick this up?
  public int drawSize = -1; // Custom draw size, -1 means use tileSize

  public void draw(Graphics g2, Gamepanel gp) {
    int screenX = worldX - gp.player.worldX + gp.player.screenX;
    int screenY = worldY - gp.player.worldY + gp.player.screenY;
    
    int size = (drawSize > 0) ? drawSize : gp.tileSize;

    if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
        worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
        worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
        worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

        g2.drawImage(image, screenX, screenY, size, size, null);
    }
  }
}
