import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FTFolder implements FTComponent {
	private ArrayList<FTComponent> components;
	private File file;
	
	public FTFolder(File f) {
		this.components = new ArrayList<FTComponent>();
		this.file = f;
	}
	
	
	/**
	 * Recursively build up the file tree starting with the root file.
	 */
	@Override
	public void buildTree() {
		if(this.file.exists()) {
			File[] files = file.listFiles();
			
			for(File f: files) {
				if(!f.isHidden()) {	// we do not want to include hidden files or folders
					if(f.isDirectory()) {
						FTFolder newFolder = new FTFolder(f);
						newFolder.buildTree();
						components.add(newFolder);
					} else {
						FTFile newFile = new FTFile(f);
						components.add(newFile);
					}
				}
	
			}
		} else {
			System.out.println("ERROR: The path `"+file.getPath()+"` does not exist.");
		}
	}

	/**
	 * Recursively search through each file.
	 */
	@Override
	public void search(String term) {
		for(FTComponent f: components) {
			f.search(term);
		}
	}
}