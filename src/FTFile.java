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
	public void search(String term) {
		try {
			Pattern p = Pattern.compile(".*"+term+".*");
			BufferedReader reader = new BufferedReader(new FileReader(this.file));
			String line;
			int lineNumber = 0;
			boolean found = false;
			
			while((line = reader.readLine()) != null) {
				line = line.toLowerCase();
				Matcher m = p.matcher(line);
				if(m.matches()) {
					System.out.println("[Line "+lineNumber+"] Found instance of `"+term+"` in file `"+this.file.getName()+"`.");
					found=true;
				}
				lineNumber++;
			}
			reader.close();
			
			if(!found) {
				System.out.println("Did not find `"+term+"` in file `"+this.file.getName()+"`.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}