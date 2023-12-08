package pkg;

public class Member {
	private String color;
	private String name;
	
	public Member(String color, String name) {
		this.color = color;
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [color=" + color + ", name=" + name + "]";
	}	
}
