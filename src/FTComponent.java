import java.util.regex.Pattern;

public interface FTComponent {
	public void buildTree();
	public void search(String term);
	public void search(Pattern pattern);
}
