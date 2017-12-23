import java.io.File;

public class Main {
	public static void main(String[] args) {
		File f = new File("/Users/Ryan/Desktop/Computer Science/Programs/RecTest");
		FTFolder folder = new FTFolder(f);
		folder.buildTree();
		folder.search("ban");
	}
}
