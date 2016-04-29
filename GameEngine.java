package f2.spw;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 import java.awt.geom.Rectangle2D;
 
 public class GameEngine {
 	GamePanel gp;
 
 
 	public GameEngine(GamePanel gp) {
 		this.gp = gp;
 	
 		gp.updateGameUI();
 		
 	}
 } 