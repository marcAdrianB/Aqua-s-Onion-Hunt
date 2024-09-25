package entity;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;
import main.userInput;
import object.SuperObject;

public class Player extends Entity{
	
	GamePanel p;
	userInput in;
	SuperObject obj;
	
	public final int screenX;
	public final int screenY;
	
	public int hasKey = 0;
	public int onion = 0;
	public int speedstatus = 0;
	public int worth = 0;
	
	public int stillSpriteCounter = 0;
	
	
	public Player(GamePanel p, userInput in) {
		
		super(p);
		
		this.p = p;
		this.in = in;
		this.screenX = p.screenWidth/2 - (p.tileSize/2);
		this.screenY = p.screenHeight/2 - (p.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 14;
		solidArea.y = 20;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.height = 28;
		solidArea.width = 20;
		
		setDefaultValues();
		getChara();
		
	}
	public void setDefaultValues() {
		
		worldX = p.tileSize*11;
		worldY = p.tileSize*46;
		//worldX = p.tileSize*8;
		//worldY = p.tileSize*19;
		speed = 240/p.FPS;
		direction = "downstill";
		
		//playa status
		maxLife = 6;
		life = maxLife;
		
	}
	public void getChara() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/chara/aquaup1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/chara/aquaup2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/chara/aquaup3.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/chara/aquadown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/chara/aquadown2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/chara/aquadown3.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/chara/aqualeft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/chara/aqualeft2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/chara/aqualeft3.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/chara/aquaright1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/chara/aquaright2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/chara/aquaright3.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void update() {
		
		if(in.upPressed == true || in.downPressed == true || in.leftPressed == true || in.rightPressed == true || in.select == true) {
			
			if(in.leftPressed == true) {
				direction = "left";
				
				
			}
			if(in.rightPressed == true) {
				direction = "right";
				
				
			}
			if(in.upPressed == true) {
				direction = "up";
				
			
				
			}
			if(in.downPressed == true) {
				direction = "down";
				
				
			}
			
			//collision check
			collisionIsOn = false;
			p.cCheck.checkTile(this);
			
			//check obj col
			int objIndex = p.cCheck.checkObject(this, true);
			pickUpObject(objIndex);
			
			//check npc col
			int npcIndex = p.cCheck.checkEntity(this, p.npc);
			interactNPC(npcIndex);
			
			//check event
			p.eHandler.checkEvent();
			
		
			
			//if collision is false, player can move
			if(collisionIsOn == false && in.select == false) {
				
				switch(direction) {
				case "left":
					
						worldX -= speed;
						break;
					
					
				case "right":
					
					
						worldX += speed;
						break;
					
				case "up":
					
					
						worldY -= speed;
						break;
					
					
					
				case "down":
					
						worldY += speed;
						break;
					
						
				}
				
			}
			p.in.select = false;
			
			spriteCounter++;
			if(spriteCounter > 8) {
				if(spriteNum == 1) {
				spriteNum = 2;
				}
				else if(spriteNum == 2) {
				spriteNum = 3;
				}
				else if(spriteNum == 3) {
				spriteNum = 4;
				}
				else if(spriteNum == 4) {
				spriteNum = 1;
				}
				
				spriteCounter = 0;
			}
			
		} 
		else {
			stillSpriteCounter++;
			
			if(stillSpriteCounter == 20) {
				
				spriteNum = 2;
				
				stillSpriteCounter = 0;
				
			}
			
		}
		if(life <= 0) {
			
			p.gameState = p.gameOverState;
			
		}
	}
	
	public void interactNPC(int i) {
		
		if(i != 999) {
			
			if(p.in.select == true) {
			p.gameState = p.dialogueState;
			
			p.npc[p.currentMap][i].speak();
			}
		}
		p.in.select = false;
	}
	
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = p.obj[p.currentMap][i].name;
			
			switch(objectName) {
			
			case "Key":
				p.playSFX(1);
				hasKey++;
			
				p.obj[p.currentMap][i] = null;
	
				p.ui.showMessage("You got a key!");
				
				break;
			
			case "Locked Door": 
				if(hasKey > 0) {
					p.playSFX(3);
					p.obj[p.currentMap][i] = null;
					hasKey--;
					p.ui.showMessage("You unlocked the door!");
				} else if(hasKey == 0 || in.select == true) {
					
						p.ui.showMessage("The door is locked!");
						
						
				}
				
				break;
			case "Onion":
				p.playSFX(6);
				onion++;
				p.obj[p.currentMap][i] = null;
				
				if(onion == 45) {
					
					p.ui.showMessage("You collected 45 onions! Thank you for playing!");
					p.playSFX(9);
					break;
				}
				
				break;
				
			case "Boots":
				speedstatus++;
				p.playSFX(8);
				p.obj[p.currentMap][i] = null;
				p.ui.showMessage("Speed is boosted!");
				speed += 2;
				break;
				
			case "Excalibur":
				
				p.ui.showMessage("You are not worthy enough.");
	
				break;	
			case "Pit":
				
				break;
			case "Sign":
				p.ui.showMessage("TAMANEGI ISLAND");
			}
			
		}
		
		
	}
		
	
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);
		
		//g2.fillRect(x, y, p.tileSize, p.tileSize);
		
		BufferedImage image = null;
		
		if(direction == "up") {
			if(spriteNum == 1) {
				image = up2;
			}
			if(spriteNum == 2) {
				image = up1;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			if(spriteNum == 4) {
				image = up1;
			}
		}
		if(direction == "down") {
			if(spriteNum == 1) {
				image = down2;
			}
			if(spriteNum == 2) {
				image = down1;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			if(spriteNum == 4) {
				image = down1;
			}
		}
		if(direction == "left") {
			if(spriteNum == 1) {
				image = left2;
			}
			if(spriteNum == 2) {
				image = left1;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			if(spriteNum == 4) {
				image = left1;
			}
		}
		if(direction == "right") {
			if(spriteNum == 1) {
				image = right2;
			}
			if(spriteNum == 2) {
				image = right1;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			if(spriteNum == 4) {
				image = right1;
			}
			
		}
		if(direction == "upstill") {
			image = up1;
		}
		if(direction == "downstill") {
			image = down1;
		}
		if(direction == "leftstill") {
			image = left1;
		}
		if(direction == "rightstill") {
			image = right1;
		}
		g2.drawImage(image, screenX, screenY, p.tileSize, p.tileSize, null);
	}
}
