package entity;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC_Towa extends Entity {
	
	public NPC_Towa(GamePanel p) {
		
		super(p);
		
		direction = "down";
		
		getNPC();
		
		setDialogue();
		
	}

	public void getNPC() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/npc/towa_up.png"));
		
			down1 = ImageIO.read(getClass().getResourceAsStream("/npc/towa_down.png"));
		
			left1 = ImageIO.read(getClass().getResourceAsStream("/npc/towa_left.png"));
		
			right1 = ImageIO.read(getClass().getResourceAsStream("/npc/towa_right.png"));
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public void setDialogue() {
		
		dialogues[0] = "TOWA \nSigh...";
		dialogues[1] = "TOWA \nI think we have no choice but to collect \nall of those onions.";
		dialogues[2] = "TOWA \nThere are also keys scattered within this island. \nTry finding all of them as well.";
		dialogues[3] = "TOWA \nJust don't expect to find some fancy treasure \nhere though.";
		dialogues[4] = "TOWA \nTake care.";
		
		
		
		
		
	}
	
	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 60) {
		
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
	
}
