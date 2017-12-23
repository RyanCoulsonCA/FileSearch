import java.io.File;

public class Main {
	public static void main(String[] args) {
		File f = new File("E:\\Programming\\repo_coulso13");
		FTFolder folder = new FTFolder(f);
		
		folder.buildTree();
	}
}
