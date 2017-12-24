import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class DirectoryTextField extends JTextField implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchModel model;
	
	public DirectoryTextField(SearchModel model) {
		this.model = model;
		this.setEditable(false);
		this.setText("Select directory to search from");
		this.setColumns(26);
		this.setFont(new Font("DIALOG", Font.PLAIN, 15));
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setText(model.getCurrentDirectory());
	}
}
