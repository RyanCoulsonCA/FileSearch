import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class SearchModel extends Observable {
	private File directory;
	private FTFolder fileTree;
	private SearchResults results;

	public SearchModel(String file) {
		this.directory = new File(file);
		this.buildFileTree();
	}
	
	private void buildFileTree() {
		System.out.println("Building file tree `"+directory.getPath()+"`...");
		this.fileTree = new FTFolder(this.directory);
		this.fileTree.buildTree();
		System.out.println("Done!");
	}
	
	public String getCurrentDirectory() {
		return this.directory.getPath();
	}
	
	public void setCurrentDirectory(File file) {
		this.directory = file;	
		this.buildFileTree();
		this.setChanged();
		this.notifyObservers();
	}
	
	public FTFolder getFileTree() {
		return this.fileTree;
	}
	
	public void search(String search) {
		this.results = this.fileTree.search(search);
		System.out.println("Search complete");
	}
	
	public SearchResults getResults() {
		return this.results;
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		 super.addObserver(o);
		 this.setChanged();
		 this.notifyObservers();
	}
}
