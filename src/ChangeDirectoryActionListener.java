import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChangeDirectoryActionListener implements ActionListener {
	private SearchModel model;
	private JFrame frame;
	
	public ChangeDirectoryActionListener(SearchModel model, JFrame frame) {
		this.model = model;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(model.getCurrentDirectory()));
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(frame);
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			model.setCurrentDirectory(fileChooser.getSelectedFile());
		}
	}

}
