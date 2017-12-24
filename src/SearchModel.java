import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class SearchModel extends Observable {
	private File directory;

	public SearchModel(String file) {
		this.directory = new File(file);
	}
	
	public String getCurrentDirectory() {
		return this.directory.getPath();
	}
	
	public void setCurrentDirectory(File file) {
		this.directory = file;
		this.setChanged();
		this.notifyObservers();
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}
}
