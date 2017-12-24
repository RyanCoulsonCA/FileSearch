import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void createAndShowGUI() { 
		SearchModel model = new SearchModel("E:/");
		
		JFrame frame = new JFrame("File Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 300));
		frame.getContentPane().setLayout(new GridLayout(3, 2));
		frame.getContentPane().setBackground(Color.WHITE);
			
		DirectoryPanel dirPanel = new DirectoryPanel(model);
		model.addObserver(dirPanel);
		frame.getContentPane().add(dirPanel);
		
		JButton changeDir = new JButton("Change Directory");
		changeDir.addActionListener(new ChangeDirectoryActionListener(model, frame));
		frame.getContentPane().add(changeDir);
		
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
