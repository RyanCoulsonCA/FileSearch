import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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

	public static void createAndShowGUI(int width, int height) {
		
		JFrame frame = new JFrame("New UI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(width, height));
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new FlowLayout());
		
		// Initialize FileSelectorFrame
		FileSelectorFrame folderSelector = new FileSelectorFrame(frame);
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("FileSearch");
		titleLabel.setFont(new Font("PLAIN", Font.BOLD, 30));
		titleLabel.setForeground(Color.WHITE);
		
		frame.getContentPane().add(titleLabel);
		
		frame.pack();
		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(450, 150);
			}
		});
	}

}
