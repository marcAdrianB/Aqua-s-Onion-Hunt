package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image, image2, image3;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel p) {
		
		int screenX = worldX - p.player.worldX + p.player.screenX;
		int screenY = worldY - p.player.worldY + p.player.screenY;
		
		if(worldX + p.tileSize > p.player.worldX - p.player.screenX && worldX - p.tileSize < p.player.worldX + p.player.screenX &&
				worldY + p.tileSize > p.player.worldY - p.player.screenY && worldY - p.tileSize < p.player.worldY + p.player.screenY) {
			
		g2.drawImage(image, screenX, screenY, p.tileSize, p.tileSize, null);
		
		}
		
	}
	
}
