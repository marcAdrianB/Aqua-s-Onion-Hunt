package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class userInput implements KeyListener {
	
	GamePanel p;
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, upStop, 
	downStop, leftStop, rightStop, run, select, back, restart;
	
	public boolean checkDrawTime = false;
	
	public userInput(GamePanel p) {
		
		this.p = p;
		
	}
	
	
	public void keyTyped(KeyEvent e) {	
		
	}

	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		//title state
		
		if(p.gameState == p.titleState) {
			
			if(p.ui.titleScreenState == 0) {
				
				if(code == KeyEvent.VK_UP) {
					
					p.ui.commandNum--;
					p.playSFX(14);
					if(p.ui.commandNum < 0) {
						p.ui.commandNum = 3;
						
						
					}
					
				}
				if(code == KeyEvent.VK_DOWN) {
					
					p.ui.commandNum++;
					p.playSFX(14);
					if(p.ui.commandNum > 3) {
						p.ui.commandNum = 0;
						
						
						
					}
					
				}
				if(code == KeyEvent.VK_Z) {
					
					if(p.ui.commandNum == 0) {
						p.playSFX(14);
						p.gameState = p.playState;
						p.ui.commandNum = 0;
					}
					if(p.ui.commandNum == 1) {
						p.playSFX(14);
						p.gameState = p.optionsState;
						p.ui.commandNum = 0;
					}
						
					if(p.ui.commandNum == 2) {
						p.playSFX(14);
						p.gameState = p.creditState;
						
					}
					
					if(p.ui.commandNum == 3) {
						System.exit(0);
					}
					
					
				}
				
			}
			
			
			
		}
	
		
		//playstate
		if(p.gameState == p.playState) {
		if(code == KeyEvent.VK_UP) {
			
			upPressed = true;
			
		}
		if(code == KeyEvent.VK_DOWN) {
			
			downPressed = true;
			
		}
		if(code == KeyEvent.VK_LEFT) {
			
			leftPressed = true;
	
		}
		if(code == KeyEvent.VK_RIGHT) {
			
			rightPressed = true;
	
		}
		if(code == KeyEvent.VK_W) {
			
			upPressed = true;
			
		}
		if(code == KeyEvent.VK_S) {
			
			downPressed = true;
			
		}
		if(code == KeyEvent.VK_A) {
			
			leftPressed = true;
	
		}
		if(code == KeyEvent.VK_D) {
			
			rightPressed = true;
	
		}
		
		if(code == KeyEvent.VK_Z) {
			
			select = true;
	
		}
		if(code == KeyEvent.VK_X) {
			
			back = true;
	
		}
		if(code == KeyEvent.VK_ESCAPE) {
				p.playSFX(14);
				p.gameState = p.pauseState;
		}

		//debug
		if(code == KeyEvent.VK_0) {
			if(checkDrawTime == false) {
			checkDrawTime = true;
			} else if (checkDrawTime == true) {
				checkDrawTime = false;
			}
	
		}
		
		}
		
		//pausestate
		else if(p.gameState == p.pauseState) {
			
		
			if(code == KeyEvent.VK_ESCAPE) {
			p.playSFX(14);
			p.gameState = p.playState;
			
			}
		
			if(code == KeyEvent.VK_UP) {
				
				p.ui.commandNum--;
				p.playSFX(14);
				if(p.ui.commandNum < 0) {
					p.ui.commandNum = 1;
					
					
				}
				
			}
			if(code == KeyEvent.VK_DOWN) {
				
				p.ui.commandNum++;
				p.playSFX(14);
				if(p.ui.commandNum > 1) {
					p.ui.commandNum = 0;
					
					
					
				}
				
			}
			if(code == KeyEvent.VK_Z) {
				
				if(p.ui.commandNum == 0) {
					p.playSFX(14);
					p.gameState = p.playState;
					p.ui.commandNum = 0;
				}
				
				
				if(p.ui.commandNum == 1) {
					p.playSFX(14);
					p.gameState = p.titleState;
					p.ui.commandNum = 0;
				}
			
			}
			
		}
		
		
		//dialoguestate
		else if(p.gameState == p.dialogueState) {
			
			if(code == KeyEvent.VK_Z) {
				
				p.gameState = p.playState;
			
			}
			if(code == KeyEvent.VK_X) {
				
				p.gameState = p.playState;
			
			}
		} 
		
		else if(p.gameState == p.creditState) {
			
			if(code == KeyEvent.VK_Z) {
				
				select = true;
				p.playSFX(14);
				
			}
			if(code == KeyEvent.VK_UP) {
				
				p.ui.commandNum--;
				p.playSFX(14);
				if(p.ui.commandNum < 0) {
					p.ui.commandNum = 0;
					
					
				}
				
			}
			else if(code == KeyEvent.VK_DOWN) {
				
				p.ui.commandNum++;
				p.playSFX(14);
				if(p.ui.commandNum > 0) {
					p.ui.commandNum = 0;
					
					
					
				}
				
			}
			
			
			
		}
		else if(p.gameState == p.optionsState) {
			
			switch(p.ui.subState) {
			case 0:
			if(code == KeyEvent.VK_Z) {
				
				select = true;
				p.playSFX(14);
				
			}
			
			if(code == KeyEvent.VK_UP) {
				
				p.ui.commandNum--;
				p.playSFX(14);
				if(p.ui.commandNum < 0) {
					p.ui.commandNum = 3;
					
					
				}
				
			}
			else if(code == KeyEvent.VK_DOWN) {
				
				p.ui.commandNum++;
				p.playSFX(14);
				if(p.ui.commandNum > 3) {
					p.ui.commandNum = 0;
					
					
					
				}
				
			}
			else if(code == KeyEvent.VK_LEFT) {
				
				if(p.ui.subState == 0) {
					
					if(p.ui.commandNum == 0 && p.music.volumeScale > 0) {
						
						p.music.volumeScale--;
						p.music.checkVolume();
					}
					if(p.ui.commandNum == 1 && p.music.volumeScale > 0) {
						
						p.sfx.volumeScale--;
						;
					}
					
				}
				
			}
			else if(code == KeyEvent.VK_RIGHT) {
				if(p.ui.subState == 0) {
					
					if(p.ui.commandNum == 0 && p.music.volumeScale < 5) {
						
						p.music.volumeScale++;
						p.music.checkVolume();
					}
					if(p.ui.commandNum == 1 && p.music.volumeScale < 5) {
						
						p.sfx.volumeScale++;
						
					}
					
				}
				
				
			}
			break;
			case 1:
				if(code == KeyEvent.VK_Z) {
					
					select = true;
					p.playSFX(14);
					
				}
				if(code == KeyEvent.VK_UP) {
					
					p.ui.commandNum--;
					p.playSFX(14);
					if(p.ui.commandNum < 0) {
						p.ui.commandNum = 0;
						
						
					}
					
				}
				else if(code == KeyEvent.VK_DOWN) {
					
					p.ui.commandNum++;
					p.playSFX(14);
					if(p.ui.commandNum > 0) {
						p.ui.commandNum = 0;
						
						
						
					}
					
				}
				break;
			}
		}
		else if(p.gameState == p.gameOverState) {
			
			if(code == KeyEvent.VK_Z) {
				
				p.gameState = p.titleState;
				
			}
			if(code == KeyEvent.VK_UP) {
				
				p.ui.commandNum--;
				p.playSFX(14);
				if(p.ui.commandNum < 0) {
					p.ui.commandNum = 0;
					
					
				}
				
			}
			else if(code == KeyEvent.VK_DOWN) {
				
				p.ui.commandNum++;
				p.playSFX(14);
				if(p.ui.commandNum > 0) {
					p.ui.commandNum = 0;
					
					
					
				}
				
			}
			
			
			
		}
		
	}
	
	
	
	

	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_UP) {
			
			upPressed = false;
			upStop = true;
			
		}
		if(code == KeyEvent.VK_DOWN) {
			
			downPressed = false;
			downStop = true;
			
		}
		if(code == KeyEvent.VK_LEFT) {
			
			leftPressed = false;
			leftStop = true;
			
		}
		if(code == KeyEvent.VK_RIGHT) {
			
			rightPressed = false;
			rightStop = true;
	
		}
		if(code == KeyEvent.VK_W) {
			
			upPressed = false;
			
		}
		if(code == KeyEvent.VK_S) {
			
			downPressed = false;
			
		}
		if(code == KeyEvent.VK_A) {
			
			leftPressed = false;
	
		}
		if(code == KeyEvent.VK_D) {
			
			rightPressed = false;
	
		}
		/*if(code == KeyEvent.VK_SHIFT) {
			
			run = false;
	
		}*/
		if(code == KeyEvent.VK_Z) {
			
			select = false;
	
		}
		if(code == KeyEvent.VK_X) {
			
			back = false;
	
		}
		if(code == KeyEvent.VK_R) {
			
			restart = false;
	
		}
		
	}

}
