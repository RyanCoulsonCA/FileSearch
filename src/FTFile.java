import java.io.File;

public class FTFile implements FTComponent {
	private File file;
	
	public FTFile(File f) {
		this.file = f;
	}
	
	@Override
	public void buildTree() {
		System.out.println("[FTFile] Found a leaf `" + this.file.getName() + "`.");
	}
}