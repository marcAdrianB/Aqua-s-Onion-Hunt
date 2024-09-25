package main;

import entity.Entity;

public class ColChecker {
	
	GamePanel p;
	
	
	public ColChecker(GamePanel p) {
		
		this.p = p;
		
	}
	
	public void checkTile(Entity entity) {
		
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
		int entityTopWorldY = entity.worldY + entity.solidArea.y;
		int entityBotWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/p.tileSize;
		int entityRightCol = entityRightWorldX/p.tileSize;
		int entityTopRow = entityTopWorldY/p.tileSize;	
		int entityBotRow = entityBotWorldY/p.tileSize;
		
		int tileNum1, tileNum2;
		
		switch (entity.direction) {
		
		case "up":
			entityTopRow = ((entityTopWorldY - entity.speed)/p.tileSize);
			tileNum1 = p.envM.mapTileNum[p.currentMap][entityLeftCol][entityTopRow];
			tileNum2 = p.envM.mapTileNum[p.currentMap][entityRightCol][entityTopRow];
			
			if(p.envM.env[tileNum1].collision == true || p.envM.env[tileNum2].collision == true) {
				entity.collisionIsOn = true;
			}
			
			break;
		case "down":
			entityBotRow = (entityBotWorldY + entity.speed)/p.tileSize;
			tileNum1 = p.envM.mapTileNum[p.currentMap][entityLeftCol][entityBotRow];
			tileNum2 = p.envM.mapTileNum[p.currentMap][entityRightCol][entityBotRow];
			
			if(p.envM.env[tileNum1].collision == true || p.envM.env[tileNum2].collision == true) {
				entity.collisionIsOn = true;
			}
			
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed)/p.tileSize;
			tileNum1 = p.envM.mapTileNum[p.currentMap][entityLeftCol][entityTopRow];
			tileNum2 = p.envM.mapTileNum[p.currentMap][entityLeftCol][entityBotRow];
			
			if(p.envM.env[tileNum1].collision == true || p.envM.env[tileNum2].collision == true) {
				entity.collisionIsOn = true;
			}
			
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed)/p.tileSize;
			tileNum1 = p.envM.mapTileNum[p.currentMap][entityRightCol][entityTopRow];
			tileNum2 = p.envM.mapTileNum[p.currentMap][entityRightCol][entityBotRow];
			
			if(p.envM.env[tileNum1].collision == true || p.envM.env[tileNum2].collision == true) {
				entity.collisionIsOn = true;
			}
			
			break;
			
			
		}
		
		
	}
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		for(int i = 0; i < p.obj[1].length; i++) {
			
			if(p.obj[p.currentMap][i] != null) {
				
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				p.obj[p.currentMap][i].solidArea.x = p.obj[p.currentMap][i].worldX + p.obj[p.currentMap][i].solidArea.x;
				p.obj[p.currentMap][i].solidArea.y = p.obj[p.currentMap][i].worldY + p.obj[p.currentMap][i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(p.obj[p.currentMap][i].solidArea)) {
						if(p.obj[p.currentMap][i].collision == true) {
							
							entity.collisionIsOn = true;
							
							
						}	
						if(player == true) {
							index = i;
							
						}
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(p.obj[p.currentMap][i].solidArea)) {
						if(p.obj[p.currentMap][i].collision == true) {
							
							entity.collisionIsOn = true;
							
						}	
						if(player == true) {
							index = i;
							
						}
						
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(p.obj[p.currentMap][i].solidArea)) {
						if(p.obj[p.currentMap][i].collision == true) {
							
							entity.collisionIsOn = true;
							
						}	
						if(player == true) {
							index = i;
							
						}
						
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(p.obj[p.currentMap][i].solidArea)) {
						if(p.obj[p.currentMap][i].collision == true) {
							
							entity.collisionIsOn = true;
							
						}	
						if(player == true) {
							index = i;
							
						}
						
					}
					break;
								
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				p.obj[p.currentMap][i].solidArea.x = p.obj[p.currentMap][i].solidAreaDefaultX;
				p.obj[p.currentMap][i].solidArea.y = p.obj[p.currentMap][i].solidAreaDefaultY;
				
			}
		}
		
		return index;
	}
	public int checkEntity(Entity entity, Entity[][] target) {
		
		int index = 999;
		
		for(int i = 0; i < target[1].length; i++) {
			
			if(target[p.currentMap][i] != null) {
				
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				target[p.currentMap][i].solidArea.x = target[p.currentMap][i].worldX + target[p.currentMap][i].solidArea.x;
				target[p.currentMap][i].solidArea.y = target[p.currentMap][i].worldY + target[p.currentMap][i].solidArea.y;
				
				switch(entity.direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					if(entity.solidArea.intersects(target[p.currentMap][i].solidArea)) {
		
							entity.collisionIsOn = true;
						
							index = i;
			
					}
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					if(entity.solidArea.intersects(target[p.currentMap][i].solidArea)) {
						
							entity.collisionIsOn = true;
					
							index = i;
						
					}
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					if(entity.solidArea.intersects(target[p.currentMap][i].solidArea)) {
						
							entity.collisionIsOn = true;
						
							index = i;
						
					}
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					if(entity.solidArea.intersects(target[p.currentMap][i].solidArea)) {
						
							entity.collisionIsOn = true;
					
							index = i;
		
					}
					break;
								
				}
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target[p.currentMap][i].solidArea.x = target[p.currentMap][i].solidAreaDefaultX;
				target[p.currentMap][i].solidArea.y = target[p.currentMap][i].solidAreaDefaultY;
				
			}
		}
		
		return index;
		
	} 
}
