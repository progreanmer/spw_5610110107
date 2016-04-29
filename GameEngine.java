package f2.spw;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 import java.awt.geom.Rectangle2D;
 import javax.swing.Timer;
 
 public class GameEngine{
 	GamePanel gp;
	private Timer timer;
	private SpaceShip y;
 	public GameEngine(GamePanel gp, SpaceShip y) {
 		this.gp = gp;
 		this.y = y;
 		gp.updateGameUI();
		gp.sprites.add(y);
 			
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
		timer.setRepeats(true);
 	}
	public void start(){
 		timer.start();
 	}
	private void process(){
	
	gp.updateGameUI();}
 } 