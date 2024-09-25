package main;
import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import env.EnvManager;
import object.SuperObject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable{

	
	final int actualtileSize = 16;
	final int scale = 3;
	
	public final int tileSize = actualtileSize*scale; 
	public final int screencolumnMax = 12;
	public final int screenrowMax = 10;
	public final int screenWidth = tileSize*screencolumnMax;
	public final int screenHeight = tileSize*screenrowMax;
	
	public final int worldColumnMax = 62;
	public final int worldRowMax = 56;
	public final int  maxMap = 10;
	public int currentMap = 0;
	
	
	//FPS
	public int FPS = 60;
	
	EnvManager envM = new EnvManager(this);
	
	Sound music = new Sound();
	Sound sfx = new Sound();
	
	public userInput in = new userInput(this);
	
	public ColChecker cCheck = new ColChecker(this);
	public AssetPlacer aPlacer = new AssetPlacer(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Config config = new Config(this);
	Thread gameThread;
	
	public Player player = new Player(this, in);
	public SuperObject obj[][] = new SuperObject[maxMap][100];
	public Entity npc[][] = new Entity[maxMap][10];
	
	//game state
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;
	public final int optionsState = 4;
	public final int creditState = 5;
	public final int gameOverState = 6;

	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(in);
		this.setFocusable(true);
		
	}
	
	public void setupGame() {
		
		aPlacer.setObject();
		aPlacer.setNPC();

		playMusic(10);
		
		gameState = titleState;
		
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInterval;
			
			lastTime = currentTime;
			
			if(delta > 1) {
				update();
				repaint();
				delta--;
				
			}
			
		}		
		
	}
	
	public void update() {
		
		if(gameState == playState) {
			
			player.update();
			
			for(int i = 0; i < npc[1].length; i++) {
				
				if(npc[currentMap][i] != null) {
					
					npc[currentMap][i].update();
					
				}
				
			}
			
			
		}
		if(gameState == pauseState) {
			
			
			
		}
		
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D gg = (Graphics2D)g;
		
		//debug
		long drawStart = 0;
		if (in.checkDrawTime == true) {
		drawStart = System.nanoTime();
		}
		
		//title screen
		if(gameState == titleState) {
		
			
		
			ui.draw(gg);
			
			
			
		}
		else {
			
			envM.draw(gg);
			
			for(int i = 0; i < obj[1].length; i++) {
				if(obj[currentMap][i] != null) {
					
					obj[currentMap][i].draw(gg, this);
					
				}
			}
			
			//npc
			for(int i = 0; i < npc[1].length; i++) {
				
				if(npc[currentMap][i] != null) {
					
					npc[currentMap][i].draw(gg);
					
				}
				
			}
		
			//player
			player.draw(gg);
			
			
			//ui
			ui.draw(gg);
			
			
		}
		
		//debug
		if(in.checkDrawTime == true) {
		long drawEnd = System.nanoTime();
		long passed = drawEnd - drawStart;
		gg.setColor(Color.WHITE);
		gg.drawString("_drawtime: " + passed, 10, 150);
		System.out.println("_drawtime: " + passed);
		}
		
		gg.dispose();
		
	}
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
		
	}
	public void stopMusic() {
		
		music.stop();
	}
	public void playSFX(int i ) {
		
		sfx.setFile(i);
		sfx.play();
		
	}
}

