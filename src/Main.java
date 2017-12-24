import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void createAndShowGUI() { 
		SearchModel model = new SearchModel("E:/Programming/Test");
		
		JFrame frame = new JFrame("File Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setResizable(false);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().setBackground(Color.WHITE);

		model.search(".*hey.*");
		
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
