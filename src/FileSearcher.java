import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileSearcher {
	
	private ArrayList<String> files;
	private HashMap<String, ArrayList<String>> found;
	private String[] terms;
	private BufferedReader reader;
	
	public FileSearcher(ArrayList<String> files) {
		this.files = files;
		this.found = new HashMap<String, ArrayList<String>>();
	}
	
	public HashMap<String, ArrayList<String>> find(String terms) throws IOException {
		this.terms = terms.split(",");
		
		for(String f: files) {
			File file = new File(f);
			try {
				reader = new BufferedReader(new FileReader(file));
				
				
				for(String term: this.terms) {
					System.out.println("Search "+file+" for word: "+ term);
				}
				
				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		return found;
	}
}
