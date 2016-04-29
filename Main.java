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
		gframe.getContentPane().setLayout(new BorderLayout());
		GamePanel gp = new GamePanel();
		GameEngine engine = new GameEngine(gp);
		
		
		//gframe.getContentPane().setBackground(Color.BLACK);
		gframe.getContentPane().add(gp, BorderLayout.CENTER);
		gframe.setVisible(true);
	}
}