package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
	
	GamePanel p;
	
	public Config(GamePanel p) {
		
		this.p = p;
		
	}
	
	public void saveConfig() {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));
			
			//music vol
			bw.write(String.valueOf(p.music.volumeScale));
			bw.newLine();
			
			//sfx vol
			bw.write(String.valueOf(p.sfx.volumeScale));
			bw.newLine();
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void loadConfig() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));
			
			String s = br.readLine();
			
			
			p.music.volumeScale = Integer.parseInt(s);
			
			s = br.readLine();
			p.sfx.volumeScale = Integer.parseInt (s);
			
			br.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
}
