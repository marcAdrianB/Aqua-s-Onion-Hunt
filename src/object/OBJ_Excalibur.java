package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Excalibur extends SuperObject {

	public OBJ_Excalibur() {
		
		name = "Excalibur";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/excalibur.png"));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
