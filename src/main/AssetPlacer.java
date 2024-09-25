package main;

import entity.NPC_Suisei;
import entity.NPC_Towa;

import object.OBJ_Boots;
import object.OBJ_Onion;
import object.OBJ_Pit;
import object.OBJ_Sign;
import object.OBJ_Door;
import object.OBJ_Excalibur;
import object.OBJ_Key;


public class AssetPlacer {

	GamePanel p;
	
	public AssetPlacer(GamePanel p) {
		
		this.p = p;
		
		
	}
	public void setObject() {
		
		int mapNum = 0;
		int i = 0;
		
		p.obj[mapNum][0] = new OBJ_Onion();
		p.obj[mapNum][0].worldX = 38*p.tileSize;
		p.obj[mapNum][0].worldY = 36*p.tileSize;
		
		p.obj[mapNum][1] = new OBJ_Onion();
		p.obj[mapNum][1].worldX = 9*p.tileSize;
		p.obj[mapNum][1].worldY = 37*p.tileSize;
		
		p.obj[mapNum][2] = new OBJ_Door();
		p.obj[mapNum][2].worldX = 8*p.tileSize;
		p.obj[mapNum][2].worldY = 24*p.tileSize;
		
		p.obj[mapNum][3] = new OBJ_Onion();
		p.obj[mapNum][3].worldX = 8*p.tileSize;
		p.obj[mapNum][3].worldY = 21*p.tileSize;
		
		p.obj[mapNum][4] = new OBJ_Onion();
		p.obj[mapNum][4].worldX = 7*p.tileSize;
		p.obj[mapNum][4].worldY = 8*p.tileSize;
		
		p.obj[mapNum][5] = new OBJ_Onion();
		p.obj[mapNum][5].worldX = 8*p.tileSize;
		p.obj[mapNum][5].worldY = 8*p.tileSize;
		
		p.obj[mapNum][6] = new OBJ_Onion();
		p.obj[mapNum][6].worldX = 9*p.tileSize;
		p.obj[mapNum][6].worldY = 8*p.tileSize;
		
		p.obj[mapNum][7] = new OBJ_Onion();
		p.obj[mapNum][7].worldX = 48*p.tileSize;
		p.obj[mapNum][7].worldY = 10*p.tileSize;
		
		p.obj[mapNum][8] = new OBJ_Excalibur();
		p.obj[mapNum][8].worldX = 46*p.tileSize;
		p.obj[mapNum][8].worldY = 26*p.tileSize;
		
		p.obj[mapNum][9] = new OBJ_Boots();
		p.obj[mapNum][9].worldX = 44*p.tileSize;
		p.obj[mapNum][9].worldY = 26*p.tileSize;
		
		p.obj[mapNum][10] = new OBJ_Onion();
		p.obj[mapNum][10].worldX = 46*p.tileSize;
		p.obj[mapNum][10].worldY = 29*p.tileSize;
		
		p.obj[mapNum][11] = new OBJ_Onion();
		p.obj[mapNum][11].worldX = 46*p.tileSize;
		p.obj[mapNum][11].worldY = 30*p.tileSize;
		
		p.obj[mapNum][12] = new OBJ_Onion();
		p.obj[mapNum][12].worldX = 36*p.tileSize;
		p.obj[mapNum][12].worldY = 43*p.tileSize;
		
		p.obj[mapNum][13] = new OBJ_Onion();
		p.obj[mapNum][13].worldX = 35*p.tileSize;
		p.obj[mapNum][13].worldY = 43*p.tileSize;
		
		p.obj[mapNum][14] = new OBJ_Onion();
		p.obj[mapNum][14].worldX = 34*p.tileSize;
		p.obj[mapNum][14].worldY = 43*p.tileSize;
		
		p.obj[mapNum][15] = new OBJ_Onion();
		p.obj[mapNum][15].worldX = 19*p.tileSize;
		p.obj[mapNum][15].worldY = 31*p.tileSize;
		
		p.obj[mapNum][16] = new OBJ_Onion();
		p.obj[mapNum][16].worldX = 25*p.tileSize;
		p.obj[mapNum][16].worldY = 33*p.tileSize;
		
		p.obj[mapNum][17] = new OBJ_Onion();
		p.obj[mapNum][17].worldX = 20*p.tileSize;
		p.obj[mapNum][17].worldY = 31*p.tileSize;
		
		p.obj[mapNum][18] = new OBJ_Key();
		p.obj[mapNum][18].worldX = 49*p.tileSize;
		p.obj[mapNum][18].worldY = 6*p.tileSize;
		
		p.obj[mapNum][19] = new OBJ_Onion();
		p.obj[mapNum][19].worldX = 9*p.tileSize;
		p.obj[mapNum][19].worldY = 36*p.tileSize;
		
		p.obj[mapNum][20] = new OBJ_Onion();
		p.obj[mapNum][20].worldX = 10*p.tileSize;
		p.obj[mapNum][20].worldY = 36*p.tileSize;
		
		p.obj[mapNum][21] = new OBJ_Onion();
		p.obj[mapNum][21].worldX = 8*p.tileSize;
		p.obj[mapNum][21].worldY = 36*p.tileSize;
		
		p.obj[mapNum][22] = new OBJ_Onion();
		p.obj[mapNum][22].worldX = 10*p.tileSize;
		p.obj[mapNum][22].worldY = 37*p.tileSize;
		
		p.obj[mapNum][23] = new OBJ_Onion();
		p.obj[mapNum][23].worldX = 8*p.tileSize;
		p.obj[mapNum][23].worldY = 37*p.tileSize;
		
		p.obj[mapNum][24] = new OBJ_Onion();
		p.obj[mapNum][24].worldX = 8*p.tileSize;
		p.obj[mapNum][24].worldY = 38*p.tileSize;
		
		p.obj[mapNum][25] = new OBJ_Onion();
		p.obj[mapNum][25].worldX = 9*p.tileSize;
		p.obj[mapNum][25].worldY = 38*p.tileSize;
		
		p.obj[mapNum][26] = new OBJ_Onion();
		p.obj[mapNum][26].worldX = 10*p.tileSize;
		p.obj[mapNum][26].worldY = 38*p.tileSize;
		
		p.obj[mapNum][27] = new OBJ_Onion();
		p.obj[mapNum][27].worldX = 50*p.tileSize;
		p.obj[mapNum][27].worldY = 27*p.tileSize;
		
		p.obj[mapNum][28] = new OBJ_Onion();
		p.obj[mapNum][28].worldX = 51*p.tileSize;
		p.obj[mapNum][28].worldY = 27*p.tileSize;
		
		p.obj[mapNum][29] = new OBJ_Onion();
		p.obj[mapNum][29].worldX = 52*p.tileSize;
		p.obj[mapNum][29].worldY = 27*p.tileSize;
		
		p.obj[mapNum][30] = new OBJ_Onion();
		p.obj[mapNum][30].worldX = 50*p.tileSize;
		p.obj[mapNum][30].worldY = 28*p.tileSize;
	
		p.obj[mapNum][31] = new OBJ_Onion();
		p.obj[mapNum][31].worldX = 51*p.tileSize;
		p.obj[mapNum][31].worldY = 28*p.tileSize;
		
		p.obj[mapNum][32] = new OBJ_Onion();
		p.obj[mapNum][32].worldX = 52*p.tileSize;
		p.obj[mapNum][32].worldY = 28*p.tileSize;
		
		p.obj[mapNum][33] = new OBJ_Onion();
		p.obj[mapNum][33].worldX = 50*p.tileSize;
		p.obj[mapNum][33].worldY = 29*p.tileSize;
		
		p.obj[mapNum][34] = new OBJ_Onion();
		p.obj[mapNum][34].worldX = 51*p.tileSize;
		p.obj[mapNum][34].worldY = 29*p.tileSize;
		
		p.obj[mapNum][35] = new OBJ_Onion();
		p.obj[mapNum][35].worldX = 52*p.tileSize;
		p.obj[mapNum][35].worldY = 29*p.tileSize;
		
		p.obj[mapNum][36] = new OBJ_Onion();
		p.obj[mapNum][36].worldX = 52*p.tileSize;
		p.obj[mapNum][36].worldY = 9*p.tileSize;
		
		p.obj[mapNum][37] = new OBJ_Onion();
		p.obj[mapNum][37].worldX = 53*p.tileSize;
		p.obj[mapNum][37].worldY = 9*p.tileSize;
		
		p.obj[mapNum][38] = new OBJ_Onion();
		p.obj[mapNum][38].worldX = 54*p.tileSize;
		p.obj[mapNum][38].worldY = 9*p.tileSize;
		
		p.obj[mapNum][39] = new OBJ_Onion();
		p.obj[mapNum][39].worldX = 52*p.tileSize;
		p.obj[mapNum][39].worldY = 10*p.tileSize;
		
		p.obj[mapNum][40] = new OBJ_Onion();
		p.obj[mapNum][40].worldX = 53*p.tileSize;
		p.obj[mapNum][40].worldY = 10*p.tileSize;
		
		p.obj[mapNum][41] = new OBJ_Onion();
		p.obj[mapNum][41].worldX = 54*p.tileSize;
		p.obj[mapNum][41].worldY = 10*p.tileSize;
		
		p.obj[mapNum][42] = new OBJ_Onion();
		p.obj[mapNum][42].worldX = 52*p.tileSize;
		p.obj[mapNum][42].worldY = 11*p.tileSize;
		
		p.obj[mapNum][43] = new OBJ_Onion();
		p.obj[mapNum][43].worldX = 53*p.tileSize;
		p.obj[mapNum][43].worldY = 11*p.tileSize;
		
		p.obj[mapNum][44] = new OBJ_Onion();
		p.obj[mapNum][44].worldX = 54*p.tileSize;
		p.obj[mapNum][44].worldY = 11*p.tileSize;
		
		p.obj[mapNum][45] = new OBJ_Onion();
		p.obj[mapNum][45].worldX = 34*p.tileSize;
		p.obj[mapNum][45].worldY = 24*p.tileSize;
		
		p.obj[mapNum][46] = new OBJ_Onion();
		p.obj[mapNum][46].worldX = 10*p.tileSize;
		p.obj[mapNum][46].worldY = 8*p.tileSize;
		
		p.obj[mapNum][47] = new OBJ_Onion();
		p.obj[mapNum][47].worldX = 11*p.tileSize;
		p.obj[mapNum][47].worldY = 8*p.tileSize;
		
		p.obj[mapNum][48] = new OBJ_Onion();
		p.obj[mapNum][48].worldX = 12*p.tileSize;
		p.obj[mapNum][48].worldY = 8*p.tileSize;
		
		p.obj[mapNum][49] = new OBJ_Door();
		p.obj[mapNum][49].worldX = 51*p.tileSize;
		p.obj[mapNum][49].worldY = 30*p.tileSize;
		
		p.obj[mapNum][50] = new OBJ_Door();
		p.obj[mapNum][50].worldX = 53*p.tileSize;
		p.obj[mapNum][50].worldY = 12*p.tileSize;
		
		p.obj[mapNum][51] = new OBJ_Key();
		p.obj[mapNum][51].worldX = 7*p.tileSize;
		p.obj[mapNum][51].worldY = 11*p.tileSize;
		
		p.obj[mapNum][52] = new OBJ_Key();
		p.obj[mapNum][52].worldX = 38*p.tileSize;
		p.obj[mapNum][52].worldY = 37*p.tileSize;
		
		p.obj[mapNum][53] = new OBJ_Pit();
		p.obj[mapNum][53].worldX = 7*p.tileSize;
		p.obj[mapNum][53].worldY = 9*p.tileSize;
		
		
		p.obj[mapNum][54] = new OBJ_Sign();
		p.obj[mapNum][54].worldX = 28*p.tileSize;
		p.obj[mapNum][54].worldY = 42*p.tileSize;
		
		
		p.obj[mapNum][55] = new OBJ_Sign();
		p.obj[mapNum][55].worldX = 49*p.tileSize;
		p.obj[mapNum][55].worldY = 16*p.tileSize;
		
		
		
	}
	public void setNPC() {
		
		int mapNum = 0;
		int i = 0;
		
		p.npc[mapNum][0] = new NPC_Suisei(p);
		p.npc[mapNum][0].worldX = 8*p.tileSize;
		p.npc[mapNum][0].worldY = 45*p.tileSize;
		
		p.npc[mapNum][1] = new NPC_Towa(p);
		p.npc[mapNum][1].worldX = 15*p.tileSize;
		p.npc[mapNum][1].worldY = 45*p.tileSize;
		
				
	}
	
}
