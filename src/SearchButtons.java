import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SearchButtons extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Settings settings = Settings.getInstance();
	private SearchModel model;
	private JFrame frame;
	private JButton settingsButton, searchButton;

	public SearchButtons(SearchModel model, JFrame frame) {
		this.model = model;
		this.frame = frame;
		this.setPreferredSize(new Dimension(500, 80));
		this.setLayout(new FlowLayout());
		
		settingsButton = new JButton("Settings");
		settingsButton.setPreferredSize(new Dimension(150, 25));
		settingsButton.addActionListener(this);
		
		searchButton = new JButton("Search");
		searchButton.setPreferredSize(new Dimension(150, 25));
		searchButton.addActionListener(this);
		
		JPanel separator = new JPanel();
		separator.setPreferredSize(new Dimension(150, 10));
		
		this.add(settingsButton);
		this.add(separator);
		this.add(searchButton);
	}
	
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Settings") {
			SettingsWindow settingsFrame = new SettingsWindow(frame);
		} else {
			model.search(settings.getSearch());
		}
	}
}
