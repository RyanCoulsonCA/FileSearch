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
	
	public int getFileCount() {
		int count = 0;
		for(FTComponent c: components) {
			count += c.getFileCount();
		}
		return count;
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
	public SearchResults search(String term) {
		SearchResults finalResults = new SearchResults();
		
		for(FTComponent f: components) {
			SearchResults results = f.search(term);
			finalResults.addAll(results.getResults());
		}
		return finalResults;
	}
}