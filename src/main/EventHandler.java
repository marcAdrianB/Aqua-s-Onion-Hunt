package main;

import java.awt.Rectangle;

public class EventHandler {

	GamePanel p;
	Rectangle eventRect;
	int eventRectDefaultX, eventRectDefaultY;
	
	public EventHandler(GamePanel p) {
		
		this.p = p;
		
		eventRect = new Rectangle();
		eventRect.x = 23;
		eventRect.y = 23;
		eventRect.width = 2;
		eventRect.height = 2;
		eventRectDefaultX = eventRect.x;
		eventRectDefaultY = eventRect.y;
		
	}
	
	public void checkEvent() {
		
		if(hit(0,7,9,"down") == true || hit(0,7,9,"left") == true || hit(0,7,9,"up") == true) {
			
			damagePit(p.dialogueState);
			
			
		}
		else if(hit(0,54,17,"right") == true || hit(0,54,18,"right") == true) {
			
			
			teleport(1,6,19);
			p.stopMusic();
			p.playMusic(13);
			
		}
		else if(hit(1,6,19,"left") == true || hit(1,6,20,"left") == true) {
			
			
			teleport(0,53,17);
			p.stopMusic();
			p.playMusic(10);
			
		}
		
		
	}
	public boolean hit(int map, int eventCol, int eventRow, String reqDirection) {
		
		boolean hit = false;
		
		if(map == p.currentMap) {
		p.player.solidArea.x = p.player.worldX + p.player.solidArea.x;
		p.player.solidArea.y = p.player.worldY + p.player.solidArea.y;
		
		eventRect.x = eventCol*p.tileSize + eventRect.x;
		eventRect.y = eventRow*p.tileSize + eventRect.y;
		
		if(p.player.solidArea.intersects(eventRect)) {
			if(p.player.direction.equals(reqDirection) || reqDirection.equals("any")) {
				hit = true;
				
			}
			
			
		}
		
		p.player.solidArea.x = p.player.solidAreaDefaultX;
		p.player.solidArea.y = p.player.solidAreaDefaultY;
		
		eventRect.x = eventRectDefaultX;
		eventRect.y = eventRectDefaultY;
		
		
		}
		return hit;
	}
	
	public void damagePit(int gameState) {
		
		p.gameState = gameState;
		p.ui.currentDialogue = "You fall into a pit! \nYou took 1 damage.";
		p.player.life -= 1;
		p.playSFX(12);
		
	}
	
	public void teleport(int map, int x, int y) {
		
		p.currentMap = map;
		p.player.worldX = p.tileSize*x;
		p.player.worldY = p.tileSize*y;
		p.playSFX(3);
		
		
	}
}
