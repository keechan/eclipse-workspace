package pkg;

import java.util.HashSet;
import java.util.Set;

public class ThreadEx {
	public static void main(String[] args) {
		//List<String> li = new ArrayList<String>();
		//List<String> li = new Vector<String>();
		Set<String> li = new HashSet<String>();
		li.add("A");
		li.add("B");
		li.add("C");
		li.add("A");
		li.add("B");
		li.add(null);
		li.add(null);
		//System.out.println(li.size());
		//li.remove("A");
		//System.out.println(li.size());
		for(String i:li) {
			System.out.println(i);
		}
	}
}