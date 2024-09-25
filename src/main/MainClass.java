package main;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainClass {
	
	//ImageIcon negi = new ImageIcon(".//res//objects//tamanegi.png");
	ImageIcon negi = new ImageIcon(getClass().getClassLoader().getResource("tamanegi.png"));
	
	public static void main(String[]args) {
		
		MainClass m = new MainClass();
		m.initializeGame();
		
	}
	
	public void initializeGame() {
		
		JFrame gameScreen = new JFrame();
		gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen.setResizable(false);
		
		gameScreen.setIconImage(negi.getImage());
		
		gameScreen.setTitle("Aqua's Onion Hunt");
		
		
		GamePanel gPanel = new GamePanel();
		gameScreen.add(gPanel);
		
		gPanel.config.loadConfig();
		
		
		gameScreen.pack();
		
		gameScreen.setLocationRelativeTo(null);
		gameScreen.setVisible(true);
		
		gPanel.setupGame();
		gPanel.startGameThread();
		
		
		
	}
}
