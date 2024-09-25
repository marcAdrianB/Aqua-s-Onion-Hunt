package env;

import main.GamePanel;


import java.awt.Graphics2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class EnvManager {

	GamePanel p;
	public Environment[] env;
	public int mapTileNum[][][];

	
	public EnvManager(GamePanel p) {

		this.p = p;

		env = new Environment[57];
		mapTileNum = new int[p.maxMap][p.worldColumnMax][p.worldRowMax];
		
		
		getEnvImage();
		loadMap("/maps/map.txt", 0);
		loadMap("/maps/bossmap.txt", 1);
		
		
	}
	public void getEnvImage() {
		
		try {
			
			env[0] = new Environment();
			env[0].image = ImageIO.read(getClass().getResourceAsStream("/environment/tree2.png"));
			env[0].collision = true;
			
			env[1] = new Environment();
			env[1].image = ImageIO.read(getClass().getResourceAsStream("/environment/tree1.png"));
			env[1].collision = true;
			
			env[2] = new Environment();
			env[2].image = ImageIO.read(getClass().getResourceAsStream("/environment/tree3.png"));
			env[2].collision = true;
			
			env[3] = new Environment();
			env[3].image = ImageIO.read(getClass().getResourceAsStream("/environment/grass.png"));
			
			env[4] = new Environment();
			env[4].image = ImageIO.read(getClass().getResourceAsStream("/environment/sand1.png"));
			
			env[5] = new Environment();
			env[5].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandtop.png"));
			
			env[6] = new Environment();
			env[6].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandbot.png"));
			
			env[7] = new Environment();
			env[7].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandtopbot.png"));
			
			env[8] = new Environment();
			env[8].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandright.png"));
			
			env[9] = new Environment();
			env[9].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandTopRight.png"));
			
			env[10] = new Environment();
			env[10].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandBotRight.png"));
			
			env[11] = new Environment();
			env[11].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandleft.png"));
			
			env[12] = new Environment();
			env[12].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandTopLeft.png"));
			
			env[13] = new Environment();
			env[13].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandBotLeft.png"));
			
			env[14] = new Environment();
			env[14].image = ImageIO.read(getClass().getResourceAsStream("/environment/sandleftright.png"));
			
			env[15] = new Environment();
			env[15].image = ImageIO.read(getClass().getResourceAsStream("/environment/water.png"));
			env[15].collision = true;
			
			env[16] = new Environment();
			env[16].image = ImageIO.read(getClass().getResourceAsStream("/house/wall.png"));
			env[16].collision = true;
			
			env[17] = new Environment();
			env[17].image = ImageIO.read(getClass().getResourceAsStream("/house/wallDoorRight.png"));
			env[17].collision = true;
			
			env[18] = new Environment();
			env[18].image = ImageIO.read(getClass().getResourceAsStream("/house/wallDoorLeft.png"));
			env[18].collision = true;
			
			env[19] = new Environment();
			env[19].image = ImageIO.read(getClass().getResourceAsStream("/house/wallDoorTop.png"));
			env[19].collision = true;
			
			env[20] = new Environment();
			env[20].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBot.png"));
			env[20].collision = true;
			
			env[21] = new Environment();
			env[21].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowTop.png"));
			env[21].collision = true;
			
			env[22] = new Environment();
			env[22].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowRight.png"));
			env[22].collision = true;
			
			env[23] = new Environment();
			env[23].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowLeft.png"));
			env[23].collision = true;
			
			env[24] = new Environment();
			env[24].image = ImageIO.read(getClass().getResourceAsStream("/house/window.png"));
			env[24].collision = true;
			
			env[25] = new Environment();
			env[25].image = ImageIO.read(getClass().getResourceAsStream("/house/doorTopLeft.png"));
			env[25].collision = true;
			
			env[26] = new Environment();
			env[26].image = ImageIO.read(getClass().getResourceAsStream("/house/doorTopRight.png"));
			env[26].collision = true;
			
			env[27] = new Environment();
			env[27].image = ImageIO.read(getClass().getResourceAsStream("/house/doorBotLeft.png"));
			env[27].collision = true;
			
			env[28] = new Environment();
			env[28].image = ImageIO.read(getClass().getResourceAsStream("/house/doorBotRight.png"));
			env[28].collision = true;
			
			env[29] = new Environment();
			env[29].image = ImageIO.read(getClass().getResourceAsStream("/house/wallBorderRight.png"));
			env[29].collision = true;
			
			env[30] = new Environment();
			env[30].image = ImageIO.read(getClass().getResourceAsStream("/house/wallBorderLeft.png"));
			env[30].collision = true;
			
			env[31] = new Environment();
			env[31].image = ImageIO.read(getClass().getResourceAsStream("/house/wallBorderBotRight.png"));
			env[31].collision = true;
			
			env[32] = new Environment();
			env[32].image = ImageIO.read(getClass().getResourceAsStream("/house/wallBorderBotLeft.png"));
			env[32].collision = true;
			
			env[33] = new Environment();
			env[33].image = ImageIO.read(getClass().getResourceAsStream("/house/roof.png"));
			env[33].collision = true;
			
			env[34] = new Environment();
			env[34].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderTop.png"));
			env[34].collision = true;
			
			env[35] = new Environment();
			env[35].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderBot.png"));
			env[35].collision = true;
			
			env[36] = new Environment();
			env[36].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderRight.png"));
			env[36].collision = true;
			
			env[37] = new Environment();
			env[37].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBotLeft.png"));
			env[37].collision = true;
			
			env[38] = new Environment();
			env[38].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBotRight.png"));
			env[38].collision = true;
			
			env[39] = new Environment();
			env[39].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBorderBotRight.png"));
			env[39].collision = true;
			
			env[40] = new Environment();
			env[40].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBorderBotLeft.png"));
			env[40].collision = true;
			
			env[41] = new Environment();
			env[41].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBorderTopRight.png"));
			env[41].collision = true;
			
			env[42] = new Environment();
			env[42].image = ImageIO.read(getClass().getResourceAsStream("/house/wallWindowBorderTopLeft.png"));
			env[42].collision = true;
			
			env[43] = new Environment();
			env[43].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderBotRight.png"));
			env[43].collision = true;
			
			env[44] = new Environment();
			env[44].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderBotLeft.png"));
			env[44].collision = true;
			
			env[45] = new Environment();
			env[45].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderTopRight.png"));
			env[45].collision = true;
			
			env[46] = new Environment();
			env[46].image = ImageIO.read(getClass().getResourceAsStream("/house/roofBorderTopLeft.png"));
			env[46].collision = true;
			
			env[47] = new Environment();
			env[47].image = ImageIO.read(getClass().getResourceAsStream("/house/brick.png"));
			env[47].collision = true;
			
			env[48] = new Environment();
			env[48].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterTopLeft.png"));
			env[48].collision = true;
			
			env[49] = new Environment();
			env[49].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterTop.png"));
			env[49].collision = true;
			
			env[50] = new Environment();
			env[50].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterTopRight.png"));
			env[50].collision = true;
			
			env[51] = new Environment();
			env[51].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterLeft.png"));
			env[51].collision = true;
			
			env[52] = new Environment();
			env[52].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterRight.png"));
			env[52].collision = true;
			
			env[53] = new Environment();
			env[53].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterBotLeft.png"));
			env[53].collision = true;
			
			env[54] = new Environment();
			env[54].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterBot.png"));
			env[54].collision = true;
			
			env[55] = new Environment();
			env[55].image = ImageIO.read(getClass().getResourceAsStream("/environment/waterBotRight.png"));
			env[55].collision = true;
			
			env[56] = new Environment();
			env[56].image = ImageIO.read(getClass().getResourceAsStream("/house/stairss.png"));
				
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void loadMap(String fileMap, int map) {
		
		try {
			
			InputStream map1 = getClass().getResourceAsStream(fileMap);
			BufferedReader br = new BufferedReader(new InputStreamReader(map1));
			
			int col = 0;
			int row = 0;
			
			while(col < p.worldColumnMax && row < p.worldRowMax) {
				
				String line = br.readLine();
				
				while(col < p.worldColumnMax) {
					
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[map][col][row] = num;
					col++;
					
				}
				if(col == p.worldColumnMax) {
					
					col = 0;
					row++;
				
				}
				
			}
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		
		int worldCol = 0;
		int worldRow = 0;
		
		
		while (worldCol < p.worldColumnMax && worldRow < p.worldRowMax) {
			
			int tileNum = mapTileNum[p.currentMap][worldCol][worldRow];
			
			
			int worldX = worldCol*p.tileSize;
			int worldY = worldRow*p.tileSize;
			int screenX = worldX - p.player.worldX + p.player.screenX;
			int screenY = worldY - p.player.worldY + p.player.screenY;
			
			if(worldX + p.tileSize > p.player.worldX - p.player.screenX && worldX - p.tileSize < p.player.worldX + p.player.screenX &&
					worldY + p.tileSize > p.player.worldY - p.player.screenY && worldY - p.tileSize < p.player.worldY + p.player.screenY) {
				
			g2.drawImage(env[tileNum].image, screenX, screenY, p.tileSize, p.tileSize, null);
			
			
			
			}
			
			worldCol++;
			
			if(worldCol == p.worldColumnMax) {
				worldCol = 0;
				worldRow++;
				
			}
			
		}
		
		//g2.drawImage(env[0].image, 0, 0, p.tileSize, p.tileSize, null);
		//g2.drawImage(env[1].image, 48, 0, p.tileSize, p.tileSize, null);
		//g2.drawImage(env[2].image, 96, 0, p.tileSize, p.tileSize, null);
		
	}
}







