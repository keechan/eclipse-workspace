package pkg;

import java.util.ArrayList;
import java.util.List;

public class MapTest {
	public static void main(String[] args) {
//		BoardMap service2 = new BoardMapImpl();
//		Map<String, Object> service = service.insert();
//		Map<String, Object> board = service.insert();
//		System.out.println("code: " + board.get("code"));
//		System.out.println("msg: " + board.get("msg"));
//		System.out.println("method: " + board.get("method"));
//		System.out.println("size: " + service.size());

		MapVo2 mv2 = new MapVo2();
		mv2.setId("ppk");
		mv2.setPwd("12345");
		
		String id = "ppk";
		String pwd = "12345";
		
		List<MapVo2> service2 = new ArrayList<MapVo2>();
		for (MapVo2 m : service2) {
			if (m.getId().equals(id)) {
				if(m.getPwd().equals(pwd)) {
					System.out.println("로그인 성공!");
				} else {
					System.out.println("패스워드를 확인해주세요!!");
				}
			} else {
				System.out.println("ID를 확인해주세요!!");
			}
		}
	}
}