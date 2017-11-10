import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileSelectorFrame implements ActionListener {
	
	private JFrame frame;
	private JFileChooser fc;
	
	public FileSelectorFrame(JFrame frame) {
		this.frame = frame;
		
		this.fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.addActionListener(this);
		int returnVal = fc.showOpenDialog(frame);
	}
	
	private void getDirectories(String directory, String pre) {
		File file = new File(directory);
		
		String[] directories = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				File file = new File(current, name);
				return file.isDirectory() && !file.isHidden();
			}
		});
		
		for(String dir: directories) {
			File inner_file = new File(directory + "/" + dir);

			String[] inner_files = inner_file.list(new FilenameFilter() {
				@Override
				public boolean accept(File current, String name) {
					File file = new File(current, name);
					return file.isFile() && !file.isHidden();
				}
			});
			
			if(inner_files.length > 0) {
				System.out.println(pre + inner_file.getName() + Arrays.toString(inner_files));
			} else {
				System.out.println(pre + inner_file.getName());
			}
			getDirectories(inner_file.getPath(), pre + "*");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String file = fc.getSelectedFile().getPath();
		//System.out.println(file);
		getDirectories(file, "");
		
	}
}
