package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SpaceShip extends Sprite{
	
	BufferedImage po;
	int step = 8;

	public SpaceShip(int x, int y, int width, int height){
		super(x,y,width,height);
	}
	
	@Override
	public void draw(Graphics2D g){
	try {
		po = ImageIO.read(new File("f2//spw//ship.png"));
 		
	} catch (IOException exp) {
            
	}
	g.drawImage(po, x, y, width, height, null);
	}
	public void move(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}
}