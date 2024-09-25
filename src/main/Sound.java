package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

	Clip clip;
	URL soundURL[] = new URL[50];
	FloatControl fc;
	int volumeScale = 3;
	float volume;
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/bgm_normal.wav");
		soundURL[1] = getClass().getResource("/sound/snd_heal_c.wav");
		soundURL[2] = getClass().getResource("/sound/snd_power.wav");
		soundURL[3] = getClass().getResource("/sound/doorunclock.wav");
		soundURL[4] = getClass().getResource("/sound/snd_grab.wav");
		soundURL[5] = getClass().getResource("/sound/mus_create.wav");
		soundURL[6] = getClass().getResource("/sound/snd_levelup.wav");
		soundURL[7] = getClass().getResource("/sound/snd_save.wav");
		soundURL[8] = getClass().getResource("/sound/snd_speedup.wav");
		soundURL[9] = getClass().getResource("/sound/snd_dumbvictory.wav");
		
		soundURL[10] = getClass().getResource("/sound/bgm_map1_title.wav");
		soundURL[11] = getClass().getResource("/sound/aquabgm (1).wav");
		soundURL[12] = getClass().getResource("/sound/snd_hurt1.wav");
		
		soundURL[13] = getClass().getResource("/sound/bgm_bossmap.wav");
		
		soundURL[14] = getClass().getResource("/sound/snd_select.wav");
		
		
	}
	
	public void setFile(int i) {
		
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			checkVolume();
			
		} catch(Exception e) {}
	
	}
	public void play() {
		 
		 clip.start();
		
	}
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	public void stop() {
		
		clip.stop();		
	}
	public void checkVolume() {
		
		switch(volumeScale) {
		
		case 0: volume = -80f; break;
		case 1: volume = -20f; break;
		case 2: volume = -12f; break;
		case 3: volume = -5f; break;
		case 4: volume = 1f; break;
		case 5: volume = 6f; break;
		
		}
		fc.setValue(volume);
	}
}
