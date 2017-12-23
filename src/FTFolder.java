import java.io.File;
import java.util.ArrayList;

public class FTFolder implements FTComponent {
	private ArrayList<FTComponent> components;
	private File file;
	
	public FTFolder(File f) {
		this.components = new ArrayList<FTComponent>();
		this.file = f;
	}
	
	@Override
	/**
	 * Recursively build up the file tree starting with the root file.
	 */
	public void buildTree() {
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