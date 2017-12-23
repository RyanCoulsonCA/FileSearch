import java.io.File;

public class Main {
	public static void main(String[] args) {
		File f = new File("E:\\Programming\\Test");
		FTFolder folder = new FTFolder(f);
		folder.buildTree();
		folder.search("ban");
	}
}
