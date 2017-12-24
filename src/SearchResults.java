import java.io.File;
import java.util.HashMap;

public class SearchResults {
	private HashMap<File, String> results;
	
	public SearchResults() {
		this.results = new HashMap<File, String>();
	}
	
	public void addResult(File f, String info) {
		System.out.println("added " + f.getName() + ": " + info);
		results.put(f, info);
	}
	
	public void addAll(HashMap<File, String> result) {
		results.putAll(result);
	}
	
	public HashMap<File, String> getResults() {
		return results;
	}
	
	public int getSize() {
		return results.size();
	}
}
