package entity;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_Suisei extends Entity {
	
	public NPC_Suisei(GamePanel p) {
		
		super(p);
		
		direction = "down";
		
		getNPC();
		
		setDialogue();
		
	}

	public void getNPC() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/npc/suisei_up.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/npc/suisei_down.png"));
		
			left1 = ImageIO.read(getClass().getResourceAsStream("/npc/suisei_left.png"));
		
			right1 = ImageIO.read(getClass().getResourceAsStream("/npc/suisei_right.png"));
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void setDialogue() {
		
		dialogues[0] = "SUISEI \nAqu-tan!! I'm glad you're okay!";
		dialogues[1] = "SUISEI \nBad news, we got stranded in this unknown island!";
		dialogues[2] = "SUISEI \nThe only way to get out is to get all 45 onions!";
		dialogues[3] = "SUISEI \nYou see that onion icon at the bottom left of \nyour screen?";
		dialogues[4] = "SUISEI \nTry collecting those onions you see around and see \nwhat will happen!";
		
		
		
	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
		
		Random random = new Random();
		
		int i = random.nextInt(100)+1;
		
		if(i <= 25) {
			
			direction = "down";
			
		}
		if(i > 25 && i <= 50) {
			
			direction = "left";
			
		}
		if(i > 50 && i <= 75) {
			
			direction = "right";
			
		}
		if(i > 75 && i <= 100) {
			
			direction = "up";
			
		}
		
		actionLockCounter = 0;
		
		}
		
	}
	
	public void speak() {
		
		super.speak();
		 
	}
	
}
