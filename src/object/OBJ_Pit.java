package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Pit extends SuperObject {

	public OBJ_Pit() {
		
		name = "Pit";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/pit.png"));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
