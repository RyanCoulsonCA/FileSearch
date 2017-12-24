import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class DirectoryPanel extends JTextField implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchModel model;
	
	public DirectoryPanel(SearchModel model) {
		this.model = model;
		this.setEditable(false);
		this.setText("");
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setText(model.getCurrentDirectory());
	}
}
