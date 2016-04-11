import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.Color;

public class Main{
	public static void main(String[] args){
		JFrame gframe = new JFrame("Space War");
		gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gframe.setSize(400, 650);
		gframe.getContentPane().setBackground(Color.BLACK);
		gframe.setVisible(true);
	}
}