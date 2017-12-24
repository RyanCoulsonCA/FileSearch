import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ContentPanel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private SearchModel model;
	private JFrame frame;
	private JTextField directoryTextField;
	private JButton changeDir;
	private JLabel fileListTitle, fileCount, foundFilesLabel;
	private JPanel fileHeaderBlock, filePanel;
	private JScrollPane fileScrollPane;
	
	public ContentPanel(SearchModel model, JFrame frame) {
		this.model = model;
		this.frame = frame;
		this.setPreferredSize(new Dimension(500, 300));
		this.setLayout(new FlowLayout());
		this.setBackground(Color.WHITE);
		
		directoryTextField = new JTextField("Select directory to search from");
		directoryTextField.setEditable(false);
		directoryTextField.setColumns(26);
		directoryTextField.setFont(new Font("DIALOG", Font.PLAIN, 15));
		
		changeDir = new JButton("Change Directory");
		changeDir.addActionListener(new ChangeDirectoryActionListener(model, frame));
		
		/* Begin File Header */
		
		fileHeaderBlock = new JPanel();
		fileHeaderBlock.setPreferredSize(new Dimension(500, 30));
		fileHeaderBlock.setBackground(Color.GRAY);
		
		fileListTitle = new JLabel("Files");
		fileListTitle.setPreferredSize(new Dimension(470, 18));
		fileListTitle.setFont(new Font("DIALOG", Font.BOLD, 15));
		fileListTitle.setForeground(Color.WHITE);
		fileHeaderBlock.add(fileListTitle);

		/* End File Header */
		
		filePanel = new JPanel();
		filePanel.setBackground(Color.WHITE);
		
		fileCount = new JLabel("File count: " + model.getFileTree().getFileCount());
		fileCount.setPreferredSize(new Dimension(470, 15));
		fileCount.setFont(new Font("DIALOG", Font.BOLD, 12));
		
		foundFilesLabel = new JLabel("Found Files: \n");
		foundFilesLabel.setPreferredSize(new Dimension(470, 15));
		foundFilesLabel.setFont(new Font("DIALOG", Font.BOLD, 12));
		
		fileScrollPane = new JScrollPane(filePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		fileScrollPane.setPreferredSize(new Dimension(480, 150));
		fileScrollPane.setBackground(Color.RED);
		
		
		this.add(directoryTextField);
		this.add(changeDir);
		this.add(fileHeaderBlock);
		this.add(fileCount);
		this.add(foundFilesLabel);
		this.add(fileScrollPane);

	}

	@Override
	public void update(Observable o, Object arg) {
		directoryTextField.setText(model.getCurrentDirectory());
		fileCount.setText("File count: " + model.getFileTree().getFileCount());
		
		HashMap<String, File> results = model.getResults().getResults();
		filePanel.setPreferredSize(new Dimension(500, results.size() * 21));
		
		for(Map.Entry<String, File> map: results.entrySet()) {
			File file = map.getValue();
			String info = map.getKey();
			
			JLabel fileLabel = new JLabel(info); 
			fileLabel.setPreferredSize(new Dimension(470, 15));
			filePanel.add(fileLabel);
		}
	}
}
