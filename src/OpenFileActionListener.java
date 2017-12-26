import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OpenFileActionListener implements ActionListener {
	private File file;
	private Desktop desktop;
	
	public OpenFileActionListener(File f) {
		this.file = f;
		this.desktop = Desktop.getDesktop();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			desktop.open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
