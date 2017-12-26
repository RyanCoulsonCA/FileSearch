import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FTFile implements FTComponent {
	private File file;
	
	public FTFile(File f) {
		this.file = f;
	}
	
	@Override
	public void buildTree() {}
	
	@Override
	public int getFileCount() {
		return 0;
	}

	@Override
	public SearchResults search(String term) {
		SearchResults results = new SearchResults();
		
		try {
			Pattern p = Pattern.compile(".*"+term+".*");
			BufferedReader reader = new BufferedReader(new FileReader(this.file));
			String line;
			int lineNumber = 0;

			while((line = reader.readLine()) != null) {
				line = line.toLowerCase();
				Matcher m = p.matcher(line);
				if(m.matches()) {
					results.addResult(this.file, "[Line "+lineNumber+"] Found instance of `"+m.group(0)+"`");
				}
				lineNumber++;
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
}