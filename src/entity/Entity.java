package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
	
	GamePanel p;
	
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX, solidAreaDefaultY;
	
	public boolean collisionIsOn = false;
	
	public int actionLockCounter = 0;
	
	String dialogues[] = new String[20];
	int dialogueIndex = 0;
	
	public String name;
	
	
	//chara status
	public int maxLife;
	public int life;
	
	
	public Entity(GamePanel p) {
		
		this.p = p;
		
	}
	
	public void setAction() {}
	
	public void speak() {
		
		if(dialogues[dialogueIndex] == null) {
			
			dialogueIndex = 0;
		}
		p.ui.currentDialogue = dialogues[dialogueIndex];
		dialogueIndex++;
		
		switch(p.player.direction) {
		
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "right":
			direction = "left";
			break;
		case "left":
			direction = "right";
			break;
			
		}
		
	}
	
	public void update() {
		
		setAction();
		
		collisionIsOn = false;
		p.cCheck.checkTile(this);
		
		
		
	
		
	}
	
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		
		int screenX = worldX - p.player.worldX + p.player.screenX;
		int screenY = worldY - p.player.worldY + p.player.screenY;
		
		if(worldX + p.tileSize > p.player.worldX - p.player.screenX && worldX - p.tileSize < p.player.worldX + p.player.screenX &&
				worldY + p.tileSize > p.player.worldY - p.player.screenY && worldY - p.tileSize < p.player.worldY + p.player.screenY) {
		
			if(direction == "down") {
				
					image = down1;
				
			}
			if(direction == "left") {
				
					image = left1;
				
			}
			if(direction == "right") {
				
					image = right1;
				
				
			}
			if(direction == "up") {
				
				image = up1;
			
			
			}
			
	
			
		g2.drawImage(image, screenX, screenY, p.tileSize, p.tileSize, null);
		
		}
		
	}
	
}
