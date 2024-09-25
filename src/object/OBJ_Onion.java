package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Onion extends SuperObject {

	public OBJ_Onion() {
		
		name = "Onion";
		
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/onion.png"));
			
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
