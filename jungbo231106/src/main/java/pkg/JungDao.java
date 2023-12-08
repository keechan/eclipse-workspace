package pkg;

import java.util.List;

public interface JungDao {
	void insert(JungVO vo);
	int maxSno();
	List<JungVO> select();
	JungVO selectSno(int sno);
	void update(JungVO vo);
	void delete(int sno);
	void cnt(String sno);
}
