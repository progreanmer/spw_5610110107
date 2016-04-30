package f2.spw;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.util.ArrayList;

public class GamePanel extends JPanel{

	private BufferedImage buffer_image;
	Graphics2D buffer_image_graphic;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	
	public GamePanel(){
		buffer_image = new BufferedImage(400,600, BufferedImage.TYPE_INT_ARGB);
		buffer_image_graphic = (Graphics2D) buffer_image.getGraphics();
		buffer_image_graphic.setBackground(Color.BLACK);
	}
	public void updateGameUI(GameEngine reporter){
		buffer_image_graphic.clearRect(0, 0, 400, 600);
		buffer_image_graphic.setColor(Color.WHITE);			
		buffer_image_graphic.drawString(String.format("%08d", reporter.getScore()), 300, 20);
 		for(Sprite s : sprites){
 			s.draw(buffer_image_graphic);
 		}
 		
		repaint();
	}
	@Override
	public void paint(Graphics gp){
		Graphics2D gp2d = (Graphics2D) gp;
		gp2d.drawImage(buffer_image, null, 0, 0);
	}
}
	