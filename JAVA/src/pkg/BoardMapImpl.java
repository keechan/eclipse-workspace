package pkg;

import java.util.ArrayList;
import java.util.List;

public class BoardMapImpl implements BoardMap {
	MapVo1 m1 = new MapVo1();
	List<MapVo2> li = new ArrayList<>();
	MapVo2 m2 = new MapVo2();
	
	public MapVo1 insert() {
		m1.setCode(100);
		m1.setMsg("성공");
		m1.setMethod("insert");

		return m1;
	}
	
	public List<MapVo2> login() {
		m2.setId("ppk");
		m2.setPwd("1234");
		li.add(m2);
		
		return li;
	}

}
