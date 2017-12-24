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
		SearchModel model = new SearchModel("");
		
		JFrame frame = new JFrame("File Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setResizable(false);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().setBackground(Color.WHITE);
		
		/* Directory Information */
		DirectoryTextField dirPanel = new DirectoryTextField(model);
		model.addObserver(dirPanel);
		JButton changeDir = new JButton("Change Directory");
		changeDir.addActionListener(new ChangeDirectoryActionListener(model, frame));
		
		frame.getContentPane().add(dirPanel);
		frame.getContentPane().add(changeDir);
		/* End Directory Information */
		
		/* Begin File Information */
		
		JPanel fileList = new JPanel();
		fileList.setPreferredSize(new Dimension(500, 30));
		fileList.setBackground(Color.GRAY);
		
		JLabel fileListTitle = new JLabel("Files");
		fileListTitle.setPreferredSize(new Dimension(470, 18));
		fileListTitle.setFont(new Font("DIALOG", Font.BOLD, 15));
		fileListTitle.setForeground(Color.WHITE);
		fileList.add(fileListTitle);
		
		frame.getContentPane().add(fileList);
		
		/* End File Information */
		
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
