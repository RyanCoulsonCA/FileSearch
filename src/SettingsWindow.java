import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingsWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Settings settings = Settings.getInstance();
	private JLabel searchString, exactString, isRegex;
	private JTextField search;
	private JCheckBox setExact, setRegex;
	private JPanel exact, regex;
	
	public SettingsWindow(JFrame frame) {	
		this.setTitle("File Search Settings");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(400, 170));
		this.setResizable(false);
		this.setLayout(new FlowLayout());
		this.setFont(new Font("DIALOG", Font.BOLD, 13));
		
		searchString = new JLabel("Search for: ");
		searchString.setPreferredSize(new Dimension(100, 30));
		
		search = new JTextField(20);
		search.setFont(new Font("DIALOG", Font.PLAIN, 15));
		search.setText(settings.getSearchString());
		search.setSelectionStart(0);
		
		exact = new JPanel();
		exact.setPreferredSize(new Dimension(400, 25));
		
		setExact = new JCheckBox();
		exactString = new JLabel("Search for exact string");
		
		exact.add(setExact);
		exact.add(exactString);
		
		regex = new JPanel();
		regex.setPreferredSize(new Dimension(400, 25));
		
		setRegex = new JCheckBox();
		isRegex = new JLabel("Search is regex format");
		
		regex.add(setRegex);
		regex.add(isRegex);
		
		if(settings.getExactString()) {
			setExact.setSelected(true);
		}
		
		if(settings.getIsRegex()) {
			setRegex.setSelected(true);
		}
		
		JButton close = new JButton("Exit");
		close.addActionListener(this);
		
		JButton save = new JButton("Save");
		save.addActionListener(this);
		
		this.getContentPane().add(searchString);
		this.getContentPane().add(search);
		this.getContentPane().add(exact);
		this.getContentPane().add(regex);
		this.getContentPane().add(close);
		this.getContentPane().add(save);
		
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Exit") {
			this.dispose();
		} else {
			if(search.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "You must enter a search!", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				settings.setExactString(setExact.isSelected());
				settings.setSearchString(search.getText());
				settings.setIsRegex(setRegex.isSelected());
				JOptionPane.showMessageDialog(this, "Settings Saved!");
				this.dispose();
			}

		}
	}
}
