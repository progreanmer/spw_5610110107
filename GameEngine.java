package f2.spw;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 import java.awt.geom.Rectangle2D;
 import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
 
 public class GameEngine implements KeyListener{
 	GamePanel gp;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Timer timer;
	private long score = 0;
	private SpaceShip y;
	private double difficulty = 0.1;
 	public GameEngine(GamePanel gp, SpaceShip y) {
 		this.gp = gp;
 		this.y = y;
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
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
		gp.sprites.add(e);
		enemies.add(e);
	}
	private void process(){
		if(Math.random() < difficulty){
			generateEnemy();
		}
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 100;
				
			}
		}	
		gp.updateGameUI(this);
		Rectangle2D.Double yr = y.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(yr)){
				die();
				return;
			}
		}
	}
	public void die(){
		timer.stop();
	}
	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			y.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			y.move(1);
			break;
		case KeyEvent.VK_D:
			difficulty += 0.1;
			break;
		}
	}
	public long getScore(){
		return score;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
 } 