package f2.spw;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 import java.awt.geom.Rectangle2D;
 import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
 
 public class GameEngine{
 	GamePanel gp;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Timer timer;
	private SpaceShip y;
	private double difficulty = 0.1;
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
		}	
		gp.updateGameUI();
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
 } 