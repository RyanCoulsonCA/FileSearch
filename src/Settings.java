
public final class Settings {
	private static final Settings INSTANCE = new Settings();
	private String search;
	private boolean exactString;
	private boolean isRegex;
	
	private Settings() {
		this.search = "";
		this.exactString = false;
		this.isRegex = false;
	}
	
	public void setSearchString(String s) {
		this.search = s;
	}
	
	public String getSearchString() {
		return this.search;
	}
	
	public String getSearch() {
		String toSearch = this.search;
		if(exactString&&!isRegex) {
			toSearch = "\\s" + this.search + "\\s";
		} else if(!exactString&&!isRegex) {
			toSearch = ".*" + this.search + ".*";
		}
		return toSearch;
	}
	
	public void setExactString(boolean exact) {
		this.exactString = exact;
	}
	
	public boolean getExactString() {
		return this.exactString;
	}
	
	public void setIsRegex(boolean regex) {
		this.isRegex = regex;
	}
	
	public boolean getIsRegex() {
		return this.isRegex;
	}
	
	public static Settings getInstance() {
		return INSTANCE;
	}
}
