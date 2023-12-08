package pkg;

import java.util.List;

public class JungServiceImpl implements JungService {
	JungDao dao = null;
	
	public JungServiceImpl() {
		dao = new JungDaoImpl();
	}
	
	@Override
	public void insert(JungVO vo) {
		dao.insert(vo);
	}

	@Override
	public int maxSno() {
		return dao.maxSno();
	}
	
	@Override
	public List<JungVO> select() {
		return dao.select();
	}

	@Override
	public JungVO selectSno(int sno) {
		
		return dao.selectSno(sno);
	}

	@Override
	public void update(JungVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int sno) {
		dao.delete(sno);
	}

	@Override
	public void cnt(String sno) {
		dao.cnt(sno);
	}

}