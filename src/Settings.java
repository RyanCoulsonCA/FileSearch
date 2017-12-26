
public final class Settings {
	private static final Settings INSTANCE = new Settings();
	private String search;
	private boolean exactString;
	private boolean isRegex;
	private boolean showDetailedResults;
	
	private Settings() {
		this.search = "";
		this.exactString = false;
		this.isRegex = false;
		this.showDetailedResults = false;
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
	
	public boolean getIsDetailed() {
		return this.showDetailedResults;
	}
	
	public void setIsDetailed(boolean detailed) {
		this.showDetailedResults = detailed;
	}
	
	public static Settings getInstance() {
		return INSTANCE;
	}
}
