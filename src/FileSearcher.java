import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileSearcher {
	
	private ArrayList<String> files;
	private HashMap<String, ArrayList<String>> found;
	private String[] terms;
	private BufferedReader reader;
	
	public FileSearcher(ArrayList<String> files) {
		this.files = files;
		this.found = new HashMap<String, ArrayList<String>>();
	}
	
	/**
	 * Generate a HashMap of files containing the given terms.
	 * @param terms	A string of terms separated by commas.	
	 * @return 		HashMap<String, ArrayList<String>> in the format: <term>:<array of files with term>.
	 */
	
	public HashMap<String, ArrayList<String>> find(String terms) {
		this.terms = terms.split(",");
		//this.terms = terms.replace(",", "|");
		//String pattern = "^.*("+this.terms+").*$";

		//Pattern p = Pattern.compile(pattern);

		for(String f: files) {
			File file = new File(f);
			try {
				reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				
				while(line != null) {
					//Matcher m = p.matcher(line);
					for(String term: this.terms) {
						if(line.contains(term)) {
							if(found.get(term) != null) {
								found.get(term).add(f);
							} else {
								found.put(term, new ArrayList<String>());
								found.get(term).add(f);
							}
						}
					}
	
					line = reader.readLine();
				}

				reader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		return found;
	}
}
