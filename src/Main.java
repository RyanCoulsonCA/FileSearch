import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class Main {

	public static void createAndShowGUI() { 
		SearchModel model = new SearchModel("");
		
		JFrame frame = new JFrame("File Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 340));
		frame.setResizable(false);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().setBackground(Color.WHITE);

		
		ContentPanel dirPanel = new ContentPanel(model, frame);
		model.addObserver(dirPanel);
		frame.getContentPane().add(dirPanel);

		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
