import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class GUIController {

	/*
	public static void createAndShowGUI(int width, int height) {
		
		JFrame frame = new JFrame("File Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(2, 1));
		
		// Initialize FileSelectorFrame
		FileSelectorFrame folderSelector = new FileSelectorFrame(frame);
		
		JTextField currentDirectory = new JTextField(folderSelector.getDirectory());
		currentDirectory.setSize(new Dimension(450, 50));
		currentDirectory.setEnabled(false);
		
		JPanel treeView = new JPanel();
		treeView.setLayout(new GridLayout(1, 2));
		
		JButton changeDirectory = new JButton("Change Directory");
		
		JLabel label2 = new JLabel("bleh2");
		treeView.add(changeDirectory); treeView.add(label2);
		
		
		frame.getContentPane().add(currentDirectory);
		frame.getContentPane().add(treeView);
		
		frame.pack();
		frame.setVisible(true);

	}*/
	
	public static void main(String[] args) {
		/*javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(450, 150);
			}
		});*/
		
		DirectoryScanner scanner = new DirectoryScanner("C:/Users/Ryan/Documents/RecTest");
		ArrayList<String> files = scanner.fetchFiles("");

		FileSearcher search = new FileSearcher(files);
		System.out.println(search.find("banapple"));
	}

}
