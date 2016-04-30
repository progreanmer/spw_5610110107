package f2.spw;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

public class Main{
	public static void main(String[] args){
		JFrame gframe = new JFrame("Space War");
		gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gframe.setSize(400, 650);
		SpaceShip y = new SpaceShip(140, 480, 60, 100);
		gframe.getContentPane().setLayout(new BorderLayout());
		GamePanel gp = new GamePanel();
		GameEngine engine = new GameEngine(gp, y);
		gframe.addKeyListener(engine);
		
		
		gframe.getContentPane().add(gp, BorderLayout.CENTER);
		gframe.setVisible(true);
		engine.start();
	}
}