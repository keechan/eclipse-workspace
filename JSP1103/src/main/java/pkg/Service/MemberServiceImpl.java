package pkg.Service;

import java.util.List;

import pkg.dao.MemberDao;
import pkg.dao.MemberDaoImpl;
import pkg.model.MemberVO;

public class MemberServiceImpl implements MemberService {
	MemberDao dao = null;
	public MemberServiceImpl() {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public void insert(MemberVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.select(vo);
	}

	@Override
	public MemberVO edit(MemberVO vo) {
		// TODO Auto-generated method stub
		//System.out.println(vo.toString() + "****ServiceImpl****");
		return dao.edit(vo);
	}

	@Override
	public void delete(MemberVO vo) {
		// TODO Auto-generated method stub
		dao.delete(vo);
	}

}
