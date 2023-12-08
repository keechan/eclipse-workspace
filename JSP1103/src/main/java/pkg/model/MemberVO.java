package pkg.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	public MemberVO() {}
}
