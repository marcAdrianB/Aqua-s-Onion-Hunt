package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import object.OBJ_Heart;
import object.SuperObject;
import javax.imageio.ImageIO;

import entity.NPC_Suisei;

public class UI {
	
	public GamePanel p;
	NPC_Suisei npcS;
	Graphics2D g2;
	Sound s;
	Font font, font_bold, font2;
	BufferedImage image1, image2, image3, image4, image5, title1, onionbg, grassbg, 
	titlebg, selectArrow, heart_full, heart_half, heart_blank, aquaIcon;
	public boolean messageOn = false;
	public String message = "";
	public int messageDuration = 0;
	
	public String currentDialogue = "";
	public int commandNum = 0;
	public int titleScreenState = 0;
	int subState = 0;
	public double playTime;
	DecimalFormat dF = new DecimalFormat("0.00");
	
	userInput in;
	
	
	public UI(GamePanel p)  {
		
		this.p = p;
		
		
		try {
			
			InputStream is = getClass().getResourceAsStream("/font/determination-extended.ttf");
			
			font = Font.createFont(Font.TRUETYPE_FONT, is);
			
		} catch (FontFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		/*font = new Font("Determination Extended", Font.PLAIN, 27);
		font2 = new Font("Determination Extended", Font.PLAIN, 27);
		font_bold = new Font("Determination Extended", Font.BOLD, 50);*/
		SuperObject heart = new OBJ_Heart();
		heart_full = heart.image;
		heart_half = heart.image2;
		heart_blank = heart.image3;
		
		
		
		itemUI();
		
	}
	public void itemUI() {
		
		try {
			
			image1 = ImageIO.read(getClass().getResourceAsStream("/objects/onion.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/objects/speed_status.png"));
			image4 = ImageIO.read(getClass().getResourceAsStream("/objects/clock.png"));
			image5 = ImageIO.read(getClass().getResourceAsStream("/ui/EndScreenTint.png"));
			
			title1 = ImageIO.read(getClass().getResourceAsStream("/ui/titlesplash.png"));
			onionbg = ImageIO.read(getClass().getResourceAsStream("/ui/onion_title.png"));
			grassbg = ImageIO.read(getClass().getResourceAsStream("/ui/grass_title.png"));
			titlebg = ImageIO.read(getClass().getResourceAsStream("/ui/titlebg (2).png"));
			selectArrow = ImageIO.read(getClass().getResourceAsStream("/ui/select_arrow.png"));
			
			aquaIcon = ImageIO.read(getClass().getResourceAsStream("/objects/tamanegi.png"));
			
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	}
	public void showMessage(String text ) {
		
		message = text;
		messageOn = true;
		
	}
	
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		if(p.gameState == p.titleState) {
			
			
			titleScreen();
			
		}
		if(p.gameState == p.creditState) {
			
			
			creditScreen();
			
		}
		
		
			
		if(p.gameState == p.playState) {
		
	
		
		playerProfile();
			
		
		playerLife();
		
		if(p.player.speedstatus > 0) {
			
			g2.drawImage(image3, 515, 430, p.tileSize-15, p.tileSize-15, null);
		
		}
		
		
		
		g2.drawImage(image1, 20, 410, p.tileSize+15, p.tileSize+15, null);
		g2.drawImage(image2, 20, 340, p.tileSize+19, p.tileSize+19, null);
		g2.setFont(font.deriveFont(Font.PLAIN, 27));
		g2.setColor(Color.BLACK);
		g2.drawString(""+p.player.hasKey+"x", 92, 392);
		g2.drawString(""+p.player.onion+"x", 92, 451);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setFont(font.deriveFont(Font.PLAIN, 27));
		g2.setColor(Color.WHITE);
		g2.drawString(""+p.player.hasKey+"x", 90, 390);
		g2.drawString(""+p.player.onion+"x", 90, 449);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
	
	
		
		//message
		if(messageOn == true) {
			
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));	
			g2.setColor(Color.YELLOW);
			g2.drawString(message, 40, 325);
			
			messageDuration++;
			
			if(messageDuration > 120) {
				
				messageDuration = 0;
				messageOn = false;
				
				
			}
			
		}
		
		}
		if(p.gameState == p.pauseState) {
			
			playerProfile();
			playerLife();
			
			if(p.player.speedstatus > 0) {
				
				g2.drawImage(image3, 515, 430, p.tileSize-15, p.tileSize-15, null);
			
			}
			
			
			
			g2.drawImage(image1, 20, 410, p.tileSize+15, p.tileSize+15, null);
			g2.drawImage(image2, 20, 340, p.tileSize+19, p.tileSize+19, null);
			g2.setFont(font.deriveFont(Font.PLAIN, 27));
			g2.setColor(Color.BLACK);
			g2.drawString(""+p.player.hasKey+"x", 92, 392);
			g2.drawString(""+p.player.onion+"x", 92, 451);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2.setFont(font.deriveFont(Font.PLAIN, 27));
			g2.setColor(Color.WHITE);
			g2.drawString(""+p.player.hasKey+"x", 90, 390);
			g2.drawString(""+p.player.onion+"x", 90, 449);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			
		
			
			
			//message
			if(messageOn == true) {
				
				
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));	
				g2.setColor(Color.YELLOW);
				g2.drawString(message, 40, 325);
				
				messageDuration++;
				
				if(messageDuration > 120) {
					
					messageDuration = 0;
					messageOn = false;
					
					
				}
				
			}
			pauseScreen();
			
		}
		if(p.gameState == p.dialogueState) {
			
			playerProfile();
			
			playerLife();
			
			if(p.player.speedstatus > 0) {
				
				g2.drawImage(image3, 515, 430, p.tileSize-15, p.tileSize-15, null);
			
			}
			
			
			
			g2.drawImage(image1, 20, 410, p.tileSize+15, p.tileSize+15, null);
			g2.drawImage(image2, 20, 340, p.tileSize+19, p.tileSize+19, null);
			g2.setFont(font.deriveFont(Font.PLAIN, 27));
			g2.setColor(Color.BLACK);
			g2.drawString(""+p.player.hasKey+"x", 92, 392);
			g2.drawString(""+p.player.onion+"x", 92, 451);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2.setFont(font.deriveFont(Font.PLAIN, 27));
			g2.setColor(Color.WHITE);
			g2.drawString(""+p.player.hasKey+"x", 90, 390);
			g2.drawString(""+p.player.onion+"x", 90, 449);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			
		
			
			
			//message
			if(messageOn == true) {
				
				
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));	
				g2.setColor(Color.YELLOW);
				g2.drawString(message, 40, 325);
				
				messageDuration++;
				
				if(messageDuration > 120) {
					
					messageDuration = 0;
					messageOn = false;
					
					
				}
				
			}
			dialogueScreen();
		}
	
		
		if(p.gameState == p.optionsState) {
			
			optionsScreen();
			
		}
		if(p.gameState == p.gameOverState) {
			playerProfile();
			playerLife();
			
			if(p.player.speedstatus > 0) {
				
				g2.drawImage(image3, 515, 430, p.tileSize-15, p.tileSize-15, null);
			
			}
			
			
			
			g2.drawImage(image1, 20, 410, p.tileSize+15, p.tileSize+15, null);
			g2.drawImage(image2, 20, 340, p.tileSize+19, p.tileSize+19, null);
			g2.setFont(font.deriveFont(Font.PLAIN, 27));
			g2.setColor(Color.BLACK);
			g2.drawString(""+p.player.hasKey+"x", 92, 392);
			g2.drawString(""+p.player.onion+"x", 92, 451);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g2.setFont(font.deriveFont(Font.PLAIN, 27));
			g2.setColor(Color.WHITE);
			g2.drawString(""+p.player.hasKey+"x", 90, 390);
			g2.drawString(""+p.player.onion+"x", 90, 449);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			
		
			
			
			//message
			if(messageOn == true) {
				
				
				g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));	
				g2.setColor(Color.YELLOW);
				g2.drawString(message, 40, 325);
				
				messageDuration++;
				
				if(messageDuration > 120) {
					
					messageDuration = 0;
					messageOn = false;
					
					
				}
				
			}
			gameOverScreen();
			
		}
	}
	
	public void gameOverScreen() {
		
		
		String text = "GAME OVER";
		int textLength;
		int x;
		int y;
		
		g2.drawImage(image5, 0, 0, p.tileSize*1000, p.tileSize*1000, null);
		
		g2.setFont(font.deriveFont(Font.BOLD, 50));
		g2.setColor(Color.BLACK);
		
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		
		x = (p.screenHeight/2 - textLength/2)+185;
		y = p.screenWidth/2 + (p.tileSize)-140;
		g2.drawString(text, x+2, y+2);
		
		
		g2.setFont(font.deriveFont(Font.BOLD, 50));
		g2.setColor(Color.WHITE);
		
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		
		x = (p.screenHeight/2 - textLength/2)+185;
		y = p.screenWidth/2 + (p.tileSize)-140;
		g2.drawString(text, x, y);
		
		
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Go to Title";
		g2.drawString(text, 347, 252);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Go to Title";
		g2.drawString(text, 345, 250);
		if(commandNum == 0) {
			
			g2.drawImage(selectArrow, 315, 230, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Go to Title";
			g2.drawString(text, 345, 250);
			
			
		}
	
		
	}
	
		
	
	public void creditScreen() {
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 15F));
		g2.drawImage(titlebg, 0, 0, p.tileSize*12, p.tileSize*12, null);
		
		//subwindow
		int frameX = ((p.tileSize*4))/2 - 50;
		int frameY = p.tileSize;
		int frameWidth = p.tileSize*10;
		int frameHeight = p.tileSize*8;
		 
		subWindow(frameX, frameY, frameWidth, frameHeight);
		
		g2.drawString("Final Project in Computer Programming 2", frameX + 20, frameY + 30); frameY += p.tileSize-10;
		g2.drawString("Developed by:", frameX + 20, frameY + 30); frameY += p.tileSize/2;
		g2.drawString("Marc Brocelango", frameX + 20, frameY + 30); frameY += p.tileSize-10;
		g2.drawString("Art by:", frameX + 20, frameY + 30); frameY += p.tileSize/2;
		g2.drawString("Marc Brocelango", frameX + 20, frameY + 30); frameY += p.tileSize-10;
		g2.drawString("Music by:", frameX + 20, frameY + 30); frameY += p.tileSize/2;
		g2.drawString("Toby Fox, JUNKY", frameX + 20, frameY + 30); frameY += p.tileSize-10;
		g2.drawString("Characters from:", frameX + 20, frameY + 30); frameY += p.tileSize/2;
		g2.drawString("Hololive", frameX + 20, frameY + 30); frameY += p.tileSize-10;
		
		g2.drawImage(p.player.down1, frameX+225, frameY-185, p.tileSize*4, p.tileSize*4, null);
		
		
		int textX = frameX + p.tileSize + 20;
		int textY = p.tileSize*2+300;
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 20F));
		g2.drawString("Back", textX, textY);
		if(commandNum == 0) {
			
			g2.drawImage(selectArrow, textX - 30, textY - 17, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 20F));
			
			
			g2.drawString("Back", textX, textY);
			if(p.in.select == true) {
				
				p.gameState = p.titleState;
				p.in.select = false;
				commandNum = 2;
				
			} 
		}
	}
	
	public void optionsScreen() {
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 24F));
		g2.drawImage(titlebg, 0, 0, p.tileSize*12, p.tileSize*12, null);
		
		//subwindow
		int frameX = ((p.tileSize*4))/2+30;
		int frameY = p.tileSize;
		int frameWidth = p.tileSize*7;
		int frameHeight = p.tileSize*8;
		 
		subWindow(frameX, frameY, frameWidth, frameHeight);
		
		switch(subState) {
		case 0: options_top(frameX, frameY);
			break;
		case 1: options_control(frameX, frameY);
			break;
		case 2:
			break;
		
		}
		
		
	}
	public void options_control(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		String text = "CONTROLS";
		textX = frameX + p.tileSize + 50;
		textY = frameY + p.tileSize + 20;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 30F));
		g2.drawString(text, textX, textY);
		
		textX = frameX + p.tileSize - 20;
		textY += p.tileSize+25;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 20F));
		
		g2.drawString("Move/Navigate" , textX, textY); textY+=p.tileSize;
		g2.drawString("Select/Talk" , textX, textY); textY+=p.tileSize;
		g2.drawString("Pause" , textX, textY); textY+=p.tileSize;
		
		textX = frameX + p.tileSize*5-15;
		textY = frameY + p.tileSize + 90;
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 14F));
		g2.drawString("ARROW KEYS", textX, textY);textY += p.tileSize;
		g2.drawString("Z KEY", textX, textY);textY += p.tileSize;
		g2.drawString("ESCAPE", textX, textY);textY += p.tileSize;
		
		textX = frameX + p.tileSize;
		textY += p.tileSize+3;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 20F));
		g2.drawString("Back", textX, textY);
		if(commandNum == 0) {
			
			g2.drawImage(selectArrow, textX - 30, textY - 17, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 20F));
			
			
			g2.drawString("Back", textX, textY);
			if(p.in.select == true) {
				
				subState = 0;
				
			}
		}
	}
	
	
	public void options_top(int frameX, int frameY) {
		
		int textX;
		int textY;
		//title
		String title = "GAME SETTINGS";
		textX = frameX + p.tileSize + 15;
		textY = frameY + p.tileSize + 20;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 30F));
		g2.drawString(title, textX, textY);
		
		//music
		textX = frameX + p.tileSize;
		textY += p.tileSize+25;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 20F));
		g2.drawString("Music", textX, textY);
		if(commandNum == 0) {
			
			g2.drawImage(selectArrow, textX - 30, textY - 17, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 20F));
			
			
			g2.drawString("Music", textX, textY);
			
		}
			
		//SFX
		textX = frameX + p.tileSize;
		textY += p.tileSize;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 20F));
		g2.drawString("SFX", textX, textY);
		if(commandNum == 1) {
			
			g2.drawImage(selectArrow, textX - 30, textY - 17, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 20F));
			
			
			g2.drawString("SFX", textX, textY);
			
		}
		
		//Control
		textX = frameX + p.tileSize;
		textY += p.tileSize;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN,20F));
		g2.drawString("Controls", textX, textY);
		
		if(commandNum == 2) {
			
			g2.drawImage(selectArrow, textX - 30, textY - 17, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 20F));
			
			
			g2.drawString("Controls", textX, textY);
			if(p.in.select == true) {
				
				subState = 1;
				commandNum = 0;
				p.in.select = false;
			}
			
		}
		
		//back
		textX = frameX + p.tileSize;
		textY += p.tileSize*2;
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 20F));
		g2.drawString("Back", textX, textY);
		if(commandNum == 3) {
			
			g2.drawImage(selectArrow, textX - 30, textY - 17, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 20F));
			
			
			g2.drawString("Back", textX, textY);
			if(p.in.select == true) {
				
				p.gameState = p.titleState;
				commandNum = 1;
			}
		}
		
		g2.setColor(Color.WHITE);
		
		//music volume
		textX = frameX + p.tileSize*3+20;
		textY = frameY + p.tileSize*2 + 24;
		g2.drawRect(textX, textY, 120, 24);
		int volumeWidth = 24*p.music.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		//sfx volume
		textY += p.tileSize;
		g2.drawRect(textX, textY, 120, 24);
		volumeWidth = 24*p.sfx.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		p.config.saveConfig();
		
	}
	
	public void playerProfile() {
		
		g2.drawImage(aquaIcon, 30, 20, p.tileSize-10, p.tileSize-10, null);
		
		String text = "AQUA";
		g2.setFont(font.deriveFont(Font.PLAIN, 17f));
		g2.setColor(Color.BLACK);
		g2.drawString(text, 77, 48);
		g2.setFont(font.deriveFont(Font.PLAIN, 17f));
		g2.setColor(Color.WHITE);
		g2.drawString(text, 76, 47);
		
		
	}
	
	public void playerLife() {
		
		int x = (p.tileSize/2);
		int y = (p.tileSize/2)+30;
		int i = 0;
		
		//draw blank heart
		while(i < p.player.maxLife/2) {

			g2.drawImage(heart_blank, x, y, p.tileSize, p.tileSize, null);
			i++;
			x += p.tileSize;
			
		}
		
		//reset
		x = (p.tileSize/2);
		y = (p.tileSize/2)+30;
		i = 0;
		
		//draw current life
		while(i < p.player.life) {
			
			g2.drawImage(heart_half, x, y, p.tileSize, p.tileSize, null);
			i++;
			if(i < p.player.life) {
				
				g2.drawImage(heart_full, x, y, p.tileSize, p.tileSize, null);
				
			}
			i++;
			x += p.tileSize;
		}
		
		
		
	}
	
	
	public void titleScreen() {
		
		String text = "";
		
		if(titleScreenState == 0) {
			
		g2.drawImage(titlebg, 0, 0, p.tileSize*12, p.tileSize*12, null);
		
		
		
		g2.drawImage(title1, 30, -150, p.tileSize*11, p.tileSize*11, null);
		
		
		
		g2.drawImage(grassbg, 50, 150, p.tileSize*5, p.tileSize*5, null);
		
		g2.drawImage(p.player.down1, 150, 230, p.tileSize, p.tileSize, null);
		
		
		//instructions
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 15F));
		
		text = "Controls";
		g2.drawString(text, 50, 350);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 15F));
		
		text = "Movement - Arrow keys";
		g2.drawString(text, 50, 375);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 15F));
		
		text = "Select - Z";
		g2.drawString(text, 50, 400);
	
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 15F));
		
		
		
		//menu
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Start new game";
		g2.drawString(text, 347, 252);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Start new game";
		g2.drawString(text, 345, 250);
		if(commandNum == 0) {
			
			g2.drawImage(selectArrow, 315, 230, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Start new game";
			g2.drawString(text, 345, 250);
			
		}
		
		
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Game settings";
		g2.drawString(text, 347, 285);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Game settings";
		g2.drawString(text, 345, 283);
		if(commandNum == 1) {
			
			g2.drawImage(selectArrow, 315, 263, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Game settings";
			g2.drawString(text, 345, 283);
			
		}
		
		
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Credits";
		g2.drawString(text, 347, 318);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Credits";
		g2.drawString(text, 345, 316);
		if(commandNum == 2) {
			
			g2.drawImage(selectArrow, 315, 296, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Credits";
			g2.drawString(text, 345, 316);
			
		}
		
		
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Quit game";
		g2.drawString(text, 347, 351);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Quit game";
		g2.drawString(text, 345, 349);
		if(commandNum == 3) {
			
			g2.drawImage(selectArrow, 315, 329, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Quit game";
			g2.drawString(text, 345, 349);
			
		}
		

	}
		
		else if (titleScreenState == 1) {
			
			
			
		}
	
		
	}
	
	
	
	public void pauseScreen() {
		
		
		
		String text = "PAUSED";
		int textLength;
		int x;
		int y;
		
		g2.drawImage(image5, 0, 0, p.tileSize*1000, p.tileSize*1000, null);
		
		g2.setFont(font.deriveFont(Font.BOLD, 50));
		g2.setColor(Color.BLACK);
		
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		
		x = (p.screenHeight/2 - textLength/2)+185;
		y = p.screenWidth/2 + (p.tileSize)-140;
		g2.drawString(text, x+2, y+2);
		
		g2.setFont(font.deriveFont(Font.BOLD, 50));
		g2.setColor(Color.WHITE);
		
		textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		
		x = (p.screenHeight/2 - textLength/2)+185;
		y = p.screenWidth/2 + (p.tileSize)-140;
		g2.drawString(text, x, y);
		
		
		
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Resume";
		g2.drawString(text, 347, 252);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Resume";
		g2.drawString(text, 345, 250);
		if(commandNum == 0) {
			
			g2.drawImage(selectArrow, 315, 230, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Resume";
			g2.drawString(text, 345, 250);
			
		}
		

		
		g2.setColor(Color.BLACK);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Go to Title";
		g2.drawString(text, 347, 285);
		
		g2.setColor(Color.WHITE);
		g2.setFont(font.deriveFont(Font.PLAIN, 25F));
		
		text = "Go to Title";
		g2.drawString(text, 345, 283);
		if(commandNum == 1) {
			
			g2.drawImage(selectArrow, 315, 263, p.tileSize/2, p.tileSize/2, null);		
			
			g2.setColor(Color.PINK);
			g2.setFont(font.deriveFont(Font.PLAIN, 25F));
			
			text = "Go to Title";
			g2.drawString(text, 345, 283);
			
		}
		
		
	
		
	}
	
	
	
	public void dialogueScreen() {
		
		//window
		int x = p.tileSize;
		int y = p.tileSize/2;
		int width = p.screenWidth - (p.tileSize*2);
		int height = p.tileSize*2;
		
		subWindow(x, y, width, height);
		
		g2.setFont(font.deriveFont(Font.PLAIN, 16F));
		x += p.tileSize-20;
		y += p.tileSize-13;
		
		for(String line : currentDialogue.split("\n")) {
		g2.drawString(line, x, y);
		y += 20;
		}
		
	}
	
	public void subWindow(int x, int y, int width, int height) {
		
		Color c = new Color(0,0,0,200);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255,255,255);
		g2.setColor(c);;
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
	}
	
	
	
}
