import java.io.File;

public class Main {
	public static void main(String[] args) {
		File f = new File("E:\\Programming\\Test");
		FTFolder folder = new FTFolder(f);
		
		System.out.println("[FTFolder] Building File Structure...");
		folder.buildTree();
		System.out.println("[FTFolder] Done!");
		
		folder.search(".*hey.*");
	}
}
