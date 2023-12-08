package pkg.board;

public class BoardVO {
	private int numid;
	private String title;
	private String content;
	
	private String ch1;
	private String ch2;
	
	
	public String getCh1() {
		return ch1;
	}
	public void setCh1(String ch1) {
		this.ch1 = ch1;
	}
	public String getCh2() {
		return ch2;
	}
	public void setCh2(String ch2) {
		this.ch2 = ch2;
	}
	public int getNumid() {
		return numid;
	}
	public void setNumid(int numid) {
		this.numid = numid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardVO [numid=" + numid + ", title=" + title + ", content=" + content + "]";
	}
}
