import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryScanner {

	private File directory;
	private String[] directories;
	private ArrayList<String> files;
	
	public DirectoryScanner(String directory) {
		this.directory = new File(directory);
		this.files = new ArrayList<String>();
	}
	
	public ArrayList<String> fetchFiles(String pre) {
		directories = directory.list(new FilenameFilter() {
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
				//System.out.println(pre + inner_file.getName() + Arrays.toString(inner_files));
				
				for(String file: inner_files) {
					files.add(directory + "/" + file);
				}
			} else {
				//System.out.println(pre + inner_file.getName() + " [empty]");
			}

			DirectoryScanner recFolders = new DirectoryScanner(directory + "/" + dir);
			ArrayList<String> recFiles = recFolders.fetchFiles(pre + "*");
			files.addAll(recFiles);
		}
		return files;
	}
	
}
