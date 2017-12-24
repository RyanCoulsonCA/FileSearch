import java.io.File;
import java.util.HashMap;

public class SearchResults {
	private HashMap<String, File> results;
	
	public SearchResults() {
		this.results = new HashMap<String, File>();
	}
	
	public void addResult(File f, String info) {
		results.put(info, f);
	}
	
	public void addAll(HashMap<String, File> result) {
		results.putAll(result);
	}
	
	public HashMap<String, File> getResults() {
		return results;
	}
	
	public int getSize() {
		return results.size();
	}
}
